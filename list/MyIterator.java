package list;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

public class MyIterator<T> implements ListIterator<T> {

	private int index=1;
	private GenericListInterface<T> list;
	
	public MyIterator(GenericListInterface<T> list){
		this.list=list;
	}
	
	public boolean hasNext() {
		if(index>=list.size())
			return false;
		else
			return true;
	}


	public T next() throws NoSuchElementException {
		try {
			return list.get(index++);
		} catch (ListException e) {
			throw new NoSuchElementException();
		}
	}
	
	public void remove() throws NoSuchElementException{
		try {
			list.remove(index-1);
		} catch (ListException e) {
			throw new NoSuchElementException();
		} catch (NullPointerException e){
			throw new NoSuchElementException();
		}
	}

	public void add(T item) throws OutOfMemoryError {
		try {
			list.insert(index, item);
		} catch (ListException e) {
			throw new OutOfMemoryError();
		}catch (NullPointerException e){
			throw new NoSuchElementException();
		}
	}

	public boolean hasPrevious() {
		if(index<=1)
			return false;
		else
			return true;
	}

	public int nextIndex() {
		return index+1;
	}

	public T previous() {
		try {
			return list.get(--index);
		} catch (ListException e) {
			throw new NoSuchElementException();
		}
	}

	public int previousIndex() {
		return index-1;
	}

	public void set(T item) throws OutOfMemoryError {
		try {
			list.set(index, item);
		} catch (ListException e) {
			throw new OutOfMemoryError();
		}
		
	}
}
