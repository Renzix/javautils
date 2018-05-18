package list;
import java.lang.reflect.Array;

public class AList<T> implements GenericListInterface<T> {
	
	private T[] l;
	private int count;
	private boolean infinite;
	
	public AList(){
		count = 0;
		l=(T[]) new Object[5];
		infinite=true;
	}
	
	public AList(int size){
		count = 0;
		l=(T[]) new Object[size];
		infinite=false;
	}
	
	public AList(int size, boolean infinite){
		count = 0;
		l=(T[]) new Object[size];
		this.infinite=infinite;
	}
	
	public AList(T[] array){
		l=(T[]) new Object[array.length];
		for(int i=0;i<array.length;i++){
			l[i]=array[i];
			count++;
		}
		infinite=false;
	}
	
	//Addition to array
	public void add(T item) throws ListException{
		try{
			if(l.length>=count)
				if(infinite)
					enlarge();
				else
					throw new ListException("Cannot add array full");
			l[count] = item;
			count++;
		}catch(OutOfMemoryError e){
			throw new ListException(e);
		}
	}
	
	public void insert(int index, T item) throws ListException{
		if(item==null)
			throw new ListException("Cannot add item is null");
		if(index>count||count==0)
			throw new ListException("Cannot insert not enough members of array");
		if(l.length>=count)
			if(infinite)
				enlarge();
			else
				throw new ListException("Cannot add array full");
		count++;
		for(int i=count;i>=index;i--)
			l[i]=l[i-1];
		l[index-1]=item;
	}
	
	private void enlarge() {
		T[] temp = (T[]) new Object[l.length+Math.floorDiv(l.length, 10)+1];
		for(int i=0;i<l.length;i++)
			temp[i]=l[i];
		l= temp.clone();
	}
	
	//Deletion of parts of the array
	public T remove() throws ListException{
		if(count<=0)
			throw new ListException("No members in array");
		count--;
		return l[count];
	}
	
	public T remove(int index) throws ListException{
		if(index>count||index<=0)
			throw new ListException("Cannot delete not enough members in array");
		T item = l[index-1];
		for(int i=index;i<count;i++)
			l[i-1]=l[i];
		count--;
		return item;
	}
	
	public void clear(){
		count=0;
	}
	
	//Changing parts of array
	public void swap(int first, int last) throws ListException{
		T temp=get(first);
		set(first,get(last));
		set(last,temp);
	}
	
	public void move(int first, int last) throws ListException{
		if(last==count)
			add(remove(first));
		else	
			insert(last, remove(first));
	}
	
	public void set(int index, T item) throws ListException{
		if(count>=index&&index>0)
			l[index-1]=item;
		else
			throw new ListException("Cannot set not enough members in the array");
	}
	
	//Returning parts of array
	public int size(){
		return count;
	}
	
	public boolean contains(T item){
		if(find(item)>=1)
			return true;
		else
			return false;
	}
	
	public int find(T item){
		for(int i=0;i<count;i++){
			if(item.equals(l[i]))
				return i+1;
		}
		return 0;
	}
	
	public AList<Integer> findAll(T item) throws ListException{
		AList<Integer> found = new AList<Integer>();
		for(int i=0;count>i;i++){
			if(item.equals(l[i]))
				found.add(i+1);
		}
		return found;
	}
	
	public T get(int index) throws ListException{
		if(index>count)
			throw new ListException("Cannot get not enought members");
		return l[index-1];
	}
	
	public boolean isEmpty(){
		if(count==0)
			return true;
		else
			return false;
	}
	
	public T[] toArray(Class<T> type){
		try{
			T[] array = (T[]) Array.newInstance(type,count);
			for(int i=0;i<count;i++)
				array[i]=l[i];
			return  array.clone();
		}catch(ClassCastException e){
			return null;
		}
	}
	
	public AList<T> clone(){
		AList<T> temp = new AList<T>(l.length, infinite);
		for(int i=1;count>=i;i++){
			try {
				temp.add(get(i));
			} catch (ListException e) {
				e.printStackTrace();
			}
		}
		return temp;
	}
	
	public String toString(){
		if(count==0)
			return "The list is empty";
		StringBuilder sb = new StringBuilder();
		sb.append('[');
		for(int i=0;i<count-1;i++){
			sb.append(l[i]+", ");
		}
		sb.append(l[count-1]);
		sb.append(']');
		return sb.toString();
	}
	
	
}
