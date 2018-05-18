package list;

public interface GenericListInterface <T> {
	//Add
	public void add(T item) throws ListException;
	public void insert(int index, T item) throws ListException;
	//Remove
	public T remove(int index) throws ListException;
	public void clear();
	//Change
	public void set(int index, T item) throws ListException;
	public void move(int first, int last) throws ListException;
	//Return
	public int size();
	public T get(int index) throws ListException;
	public boolean contains(T item);
	public boolean isEmpty();
	public T[] toArray(Class<T> type);
	
}
