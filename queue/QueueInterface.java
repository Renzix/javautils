package queue;

public interface QueueInterface <T> {
	public T peek();
	public T element() throws QueueException;
	public boolean offer(T item);
	public boolean add(T item) throws QueueException;
    public T poll();
    public T remove() throws QueueException;
	
}
