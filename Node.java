public class Node{
	private String data;
	private Node next;

	public Node(String value){
	data = value;
	next = null;
	}

	public String getData(){
		return data;
	}

	public Node getNext(){
		return next;
	}

	public void setData(String newval){
		data = newval;
	}

	public void setNext(Node newnext){
		next = newnext;
	}

}