package stack;

public class StackException extends Exception {

	public StackException(){
		
	}
	
	public StackException(String string) {
		// TODO Auto-generated constructor stub
	}
	
	public StackException(OutOfMemoryError e) {
		System.out.println("Out of memory Exception: " +e);
	}

}
