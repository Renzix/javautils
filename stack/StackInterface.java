package stack;

public interface StackInterface<T> {
	public T peek();
	public void push(T item) throws StackException;
	public T pop() throws StackException;
}
