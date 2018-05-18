package tree;
import list.ListException;
import other.Node;

//WORK IN PROGRESS

public class Folder{
	Folder rHead;
	Folder rTail;
	Folder next;
	Node head;
	Node tail;
	String name;
	public Folder(String name){
		rHead=rTail=null;
		head=tail=null;
		this.name=name;
	}
	
	public boolean addRoot(String name){
		Folder temp = new Folder(name);
		try{
			if(rHead==null)
				rHead = temp;
			else
				rTail.setNext(temp);
			rTail = temp;
			return true;
		}catch(OutOfMemoryError e){
			return false;
		}
	}
	
	public boolean addRoot(Folder temp){
		try{
			if(rHead==null)
				rHead = temp;
			else
				rTail.setNext(temp);
			rTail = temp;
			return true;
		}catch(OutOfMemoryError e){
			return false;
		}
	}

	public boolean deleteRoot(String name){
		Folder temp = rHead.clone();
		while(temp.getNext()!=null){
			if(name.equals(temp.getName()))
				return true;
			temp=temp.getNext();
		}
		return false;
	}
	
	protected void setNext(Folder next) {
		this.next=next;
	}
	
	protected Folder getNext(){
		return next;
	}
	
	public boolean addNode(Node temp){
		try{
			if(head==null)
				head = temp;
			else
				tail.setNext(temp);
			tail = temp;
			return true;
		}catch(OutOfMemoryError e){
			return false;
		}
	}
	
	public boolean deleteNode(){
		return false;
	}
	
	public void reName(String name){
		this.name=name;
	}
	
	public String getName(){
		return name;
	}
	
	public Folder clone(){
		return null;
	}
	
	public String toString(){
		StringBuilder sb = new StringBuilder();
		return sb.toString();
	}
	
}
