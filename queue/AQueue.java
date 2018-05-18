package queue;

import other.Node;

public class AQueue<T> implements QueueInterface<T> {

	//Array = array
	private T[] array;
	//f%(array.length-1) = front value
	//b%(array.length-1) = back value
	private int f,b,size;
	//Infinite is true if queue is finite
	//Empty is true if empty
	private boolean infinite, empty;
	
	//Default constructor defauls to infinite
	public AQueue(){
		this.size=5;
		array = (T[]) new Object[size+1];
		f=0;
		b=size;
		infinite=true;
		empty=true;
	}
	
	//Constructor with size defaults to the size you put in
	public AQueue(int size){
		this.size=size;
		array = (T[]) new Object[size+1];
		f=0;
		b=size;
		infinite=false;
		empty=true;
	}
	
	//Constructor with size and boolean sets if the array is growing or not.
	public AQueue(int size, boolean infinite){
		this.size=size;
		array = (T[]) new Object[size+1];
		f=0;
		b=size;
		this.infinite=infinite;
		empty=true;
	}
	
	//if it needs to get bigger puts it in 0-size order and adds some cells
	private void enlarge() {
		T[] temp = (T[]) new Object[array.length+Math.floorDiv(array.length, 10)+1];
		for(int k=0,i=b%(array.length-1);size>k; i=(i>=(size-1))?0:i+1, k++){
			temp[k]=array[i];
			//System.out.println("Iter: k["+k+"]="+array[i]);
		}
		f=size;
		size=temp.length-1;
		b=size;
		array=temp;
	}
	
	//tries to see next element if DNE return null
	public T peek() {
		if(array[b%(array.length-1)]==null)
			return null;
		return array[b%(array.length-1)];
	}

	//tries to see next element if DNE throw exception
	public T element() throws QueueException {
		if(array[b%(array.length-1)]==null)
			throw new QueueException();
		return array[b%(array.length-1)];
	}

	//tries to add if not return null
	public boolean offer(T item) {
		if(b%array.length==f%array.length){
			if(infinite)
				enlarge();
			else
				return false;
		}
		array[(f++)%(array.length-1)]=item;
		return true;
	}

	//tries to add if not throws a exception
	public boolean add(T item) throws QueueException {
		if(b%array.length==f%array.length){
			if(infinite)
				enlarge();
			else
				throw new QueueException();
		}
		array[(f++)%(array.length-1)]=item;
		return true;
	}

	//tries to remove if not return null
	public T poll() {
		if(array[b%(array.length-1)]==null)
			return null;
		else
			return array[b++%(array.length-1)]=null;
	}

	//tries to remove if not throws a exception
	public T remove() throws QueueException {
		if(array[b%(array.length-1)]==null)
			throw new QueueException();
		else
			return array[b++%(array.length-1)]=null;
	}
	
	public String toString(){
		//Prints out array
		/*System.out.print("Array: [");
		for(int i=0;array.length-1>i;i++)
			System.out.print(array[i]+", ");
		System.out.println(array[array.length-1]+"]");//*/
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		if(array[b%(array.length-1)]==null){
			sb.append("]");
			return sb.toString();
		}
		sb.append(array[(b)%(array.length-1)]);
		for(int i=(b+1)%(array.length-1);f%(array.length-1)!=i; i=(i>=(size-1))?0:i+1)
			sb.append(", "+array[i]);
		sb.append("]");
		return sb.toString();
	}
	
}
