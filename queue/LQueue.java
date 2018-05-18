package queue;

import other.Node;

public class LQueue<T> implements QueueInterface<T>{

	private Node<T> head;
	private Node<T> tail;
	private int MAX_SIZE;
	private int count;
	private boolean infinite;
	
	public LQueue(){
		head=null;
		tail=head;
		MAX_SIZE=0;
		infinite=true;
	}
	
	
	public LQueue(int size){
		head=null;
		tail=head;
		if(size>0){
			infinite=false;
		}else if(size<=0){
			infinite=true;
		}
		this.MAX_SIZE=size;
	}
	
	//Asks for first var
	public T peek() {
		if(head==null)
			return null;
		return head.getData();
	}
	
	public T element() throws QueueException{
		if(head==null)
			throw new QueueException();
		return head.getData();
	}

	//tries to put item in queue
	public boolean offer(T item) {
		if(!infinite&&MAX_SIZE<=count)
			return false;
		Node<T> temp= new Node<T>(item, null);
		if(head==null)
			head=temp;
		else
			tail.setNext(temp);
		tail=temp;
		count++;
		return true;
	}

	public boolean add(T item) throws QueueException{
		if(!infinite&&MAX_SIZE<=count)
			throw new QueueException();
		Node<T> temp= new Node<T>(item, null);
		if(head==null)
			head=temp;
		else
			tail.setNext(temp);
		tail=temp;
		count++;
		return true;
	}
	
	public T poll() {
		if(head==null)
			return null;
		T info=head.getData();
		head=head.getNext();
		count--;
		return info;
	}

	public T remove() throws QueueException {
		if(head==null)
			throw new QueueException();
		T info=head.getData();
		head=head.getNext();
		count--;
		return info;
	}

	public String toString(){
		if(head==null)
			return "[]";
		StringBuilder sb = new StringBuilder();
		Node<T> temp = head.clone();
		sb.append('[');
		while(temp.getNext()!=null){
			sb.append(temp.getData()+", ");
			temp=temp.getNext();
		}
		sb.append(temp.getData()+"]");
		return sb.toString();
	}
}
