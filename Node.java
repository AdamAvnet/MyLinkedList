public class Node{
	private String data;
	private Node next;
	private Node prev;

	public Node(String value){
	data = value;
	next = null;
	prev = null;
	}

	public String getData(){
		return data;
	}

	public Node getNext(){
		return next;
	}
	
	public Node getPrev(){
		return prev;
	}

	public void setData(String newval){
		data = newval;
	}

	public void setNext(Node newnext){
		next = newnext;
	}
	
	public void setPrev(Node newprev){
		prev = newprev;
	}

}