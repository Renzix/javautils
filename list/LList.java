package list;
import java.lang.reflect.Array;

import other.Node;

public class LList<T> implements GenericListInterface<T> {

	private Node<T> head;
	private Node<T> tail;
	private int count;
	
	public LList(){
		head = null;
		tail = null;
		count=0;
	}
	
	public LList(T[] array){
		head = null;
		tail = null;
		count=0;
		for(int i=0;array.length>i;i++){
			try {
				add(array[i]);
			} catch (ListException e) {
				e.printStackTrace();
			}
			count++;
		}
	}
	
	//Addition to list
	public void add(T item) throws ListException {
		try{
			Node<T> temp = new Node<T>(item, null);
			if(head==null)
				head = temp;
			else
				tail.setNext(temp);
			tail = temp;
			count++;
		}catch(OutOfMemoryError e){
			throw new ListException(e);
		}
	}

	public void insert(int index, T item) throws ListException {
		if(head==null||index>count||index<0)
			throw new ListException("Cannot insert not enough members in list");
		try{
			Node<T> temp = new Node<T>(item, null);
			temp.setData(item);
			temp.setNext(head.getNext());
			if(index==1){
				temp.setNext(head);
				head=temp;
			}else{
				Node<T> after = new Node<T>(item, null);
				Node<T> before = new Node<T>(item, null);
				after=head;
				for(int i=1;index>i;i++){
					before=after;
					after=after.getNext();
				}
				before.setNext(temp);	
				temp.setNext(after);
			}
		}catch(OutOfMemoryError e){
			throw new ListException(e);
		}
		count++;
	}
	
	//Deletion of parts of the list
	
	public T remove() throws ListException{
		return remove(count);
	}
	
	public T remove(int index) throws ListException {
		if(head==null||index>count||index<0)
			throw new ListException("Cannot insert not enough members in list");
		Node<T> temp=null;
		try{
			if(index==1){
				temp=head;
				head=head.getNext();
			}else{
				Node<T> after = head;
				Node<T> before = null;
				for(int i=1;index>i;i++){
					before=after;
					after=after.getNext();
				}
				temp=after;
				after=after.getNext();
				before.setNext(after);
			}
		}catch(OutOfMemoryError e){
			throw new ListException(e);
		}
		count--;
		return temp.getData();
	}

	public void clear() {
		head=null;
		tail=null;
		count=0;
	}

	//Changing parts of a list
	public void swap(int first, int last) throws ListException{
		T temp=get(first);
		set(first,get(last));
		set(last,temp);
	}
	
	public void move(int first, int last)throws ListException{
		if(last==count)
			add(remove(first));
		else	
			insert(last, remove(first));
	}
	
	//Returning parts of list
	public int size(){
		return count+1;
	}
	
	public boolean contains(T item) {
		if(find(item)>=1)
			return true;
		else
			return false;
	}
	
	public int find(T item) {
		Node<T> temp = new Node<T>(null, head);
		for(int i=0;count>i;i++){
			if(item.equals(temp.getData()))
				return i;
			temp=temp.getNext();
		}
		return 0;
	}
	
	public LList<Integer> findAll(T item) throws ListException{
		LList<Integer> found = new LList<Integer>();
		Node<T> temp = new Node<T>(null, head);
		for(int i=0;count>i;i++){
			if(item.equals(temp.getData()))
				found.add(i);
			temp=temp.getNext();
		}
		return found;
	}
	
	public void set(int index, T item) throws ListException {
		if(head==null||index>count||index<0)
			throw new ListException("Cannot insert not enough members in list");
		Node<T> temp = new Node<T>(null, head);
		for(int i=0;index>i;i++)
			temp=temp.getNext();
		temp.setData(item);
	}

	public T get(int index) throws ListException {
		if(head==null||index>count||index<0)
			throw new ListException("Cannot insert not enough members in list");
		Node<T> temp = new Node<T>(null, head);
		for(int i=0;index>i;i++)
			temp=temp.getNext();
		return temp.getData();
	}	

	public boolean isEmpty() {
		if(count==0)
			return false;
		else
			return true;
	}

	public T[] toArray(Class<T> type) {
		try{
			Node<T> temp = head;
			T[] array = (T[]) Array.newInstance(type,count);
			for(int i=0;i<count;i++){
				array[i]= temp.getData();
				temp=temp.getNext();
			}
			return array;
		}catch(ClassCastException e){
			return null;
		}
	}
	
	public String toString(){
		if(count==0)
			return "The list is empty";
		Node<T> temp = head;
		StringBuilder sb = new StringBuilder();
		sb.append('[');
		while(temp.getNext()!=null){
			sb.append(temp.getData()+", ");
			temp=temp.getNext();
		}
		sb.append(temp.getData());
		sb.append(']');
		return sb.toString();
	}

}
