package stack;

public class AStack<T> implements StackInterface<T> {

	private T[] array;
	private int count;
	private boolean finite;
	
	public AStack(){
		finite=false;
		count=0;
		array= (T[]) new Object[10];
	}
	
	public AStack(int length){
		finite=true;
		count=0;
		array= (T[]) new Object[length];
	}
	
	private void enlarge() {
		T[] temp = (T[]) new Object[array.length+Math.floorDiv(array.length, 10)+1];
		for(int i=0;i<array.length;i++)
			temp[i]=array[i];
		array=temp.clone();
	}
	
	public T peek() {
		if(count<=0)
			return null;
		return array[count-1];
	}

	public void push(T item) throws StackException {
		if(finite==false){
			if(count>=array.length)
				enlarge();
		}else
			throw new StackException("Collection is full");
		array[count++]=item;
	}

	public T pop() throws StackException {
		if(count==0)
			throw new StackException("Collection is empty cannot pop");
		return array[--count];
	}

	public String toString(){
		if(count==0)
			return "The queue is empty";
		StringBuilder sb = new StringBuilder();
		sb.append('[');
		for(int i=0;i<count-1;i++){
			sb.append(array[i]+", ");
		}
		sb.append(array[count-1]);
		sb.append(']');
		return sb.toString();
	}
	
}
