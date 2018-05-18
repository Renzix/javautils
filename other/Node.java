package other;

public class Node<T> {
	/* Constructors: Define both attributes
	 * Attributes: data,next,count(static)
	 * Methods: Setters/getters, Clone, toString  */
	
	private T data;
	private Node<T> next;
	private static int count;

	public Node(T data, Node next){
		setData(data);
		setNext(next);
		count++;
	}
	
	public T getData(){
		return data;
	}
	
	public void setData(T data){
		this.data = data;
	}
	
	public Node getNext() {
		return next;
	}
	
	public void setNext(Node next) {
		this.next = next;
	}

	public static int getCount() {
		return count;
	}
	
	public String toString(){
		return data+"";
	}
	
	public Node<T> clone(){
		return new Node<T>(getData(), getNext());
	}
	
	protected void finalize() throws Throwable{
		count--;
		super.finalize();
	}
}
