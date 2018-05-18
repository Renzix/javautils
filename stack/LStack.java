package stack;

import other.Node;

public class LStack<T> implements StackInterface<T> {

	private Node<T> head;
	
	public LStack(){
		head = null;
	}
	
	public T peek() {
		if(head==null)
			return null;
		return head.getData();
	}

	public void push(T item) throws StackException {
		try{
			Node<T> temp = new Node<T>(item, head);
			head = temp;
		}catch(OutOfMemoryError e){
			throw new StackException(e);
		}
	}

	public T pop() throws StackException {
		if(head==null)
			throw new StackException("Collection is empty cannot pop");
		T item = head.getData();
		head=head.getNext();
		return item;
	}
	
	public String toString(){
		if(head==null)
			return "The stack is empty";
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
