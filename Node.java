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

	private Node getNext(){
		return next;
	}

	public void setData(String newval){
		data = newval;
	}

	private void setNext(Node newnext){
		next = newnext;
	}

}