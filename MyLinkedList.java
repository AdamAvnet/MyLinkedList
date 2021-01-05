public class MyLinkedList{
	private int size;
	private Node head;
	private Node tail;

	public MyLinkedList(){
		size = 0;
	}

	public int size(){
		return size;
	}

	private Node nthNode(int index){
		Node current = head;
		int i = 0;
		while(i < size()){
			if(i == index)
				return current;
			i += 1;
			current = current.getNext();
		}
		throw new IndexOutOfBoundsException();
	}

	public boolean add(String value){
		Node newnode = new Node(value);
		tail = newnode;
		if(size() > 0)
			nthNode(size - 1).setNext(newnode);
		else
			head = newnode;
		size += 1;
		return true;
	}

	public boolean add(int index, String value){
		if(index >= size())
			return add(value);
		Node newnode = new Node(value);
		newnode.setNext(nthNode(index));
		if(index == 0)
			head = newnode;
		else
			nthNode(index - 1).setNext(newnode);
		return true;
	}
	
	public String get(int index){
		return nthNode(index).getData();
	}
	
	public String set(int index, String value){
		String oldvalue = nthNode(index).getData();
		nthNode(index).setData(value);
		return oldvalue;
	}
	
	public String toString(){
		String str = "";
		for(int i = 0; i < size(); i++){
			str = str + nthNode(i).getData() + ", ";
		}
		return str;
	}
}