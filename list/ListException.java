package list;

public class ListException extends Exception {
	private String message;
	public ListException(String m){
		message = m;
	}
	
	public ListException(OutOfMemoryError e) {
		message = "Out of Memory Error";
	}


	public String toString(){
		return message;
	}
	
}
