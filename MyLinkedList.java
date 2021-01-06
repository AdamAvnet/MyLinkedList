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
		if(index <= size() / 2){
			Node current = head;
			int i = 0;
			if(index < 0)
				i = size() + 100;
			while(i < size()){
				if(i == index)
					return current;
				i += 1;
				current = current.getNext();
			}
		}else{
			Node current = tail;
			int i = size() - 1;
			if(index > size())
				i = -1;
			while(i >= 0){
				if(i == index)
					return current;
				i -= 1;
				if(i > 0)
					current = current.getPrev();
			}
		}
		throw new IndexOutOfBoundsException("The index is out of bounds");
	}

	public boolean add(String value){
		Node newnode = new Node(value);
		if(size() > 0){
			Node nod = nthNode(size - 1);
			newnode.setPrev(nod);
			nod.setNext(newnode);
		}else
			head = newnode;
		tail = newnode;
		size += 1;
		return true;
	}

	public boolean add(int index, String value){
		if(index > size() || index < 0)
			throw new IndexOutOfBoundsException("The index is out of bounds");
		if(index == size())
			return add(value);
		Node newnode = new Node(value);
		Node nod = nthNode(index);
		nod.setPrev(newnode);
		newnode.setNext(nod);
		if(index == 0)
			head = newnode;
		else{
			Node nody = nthNode(index - 1);
			newnode.setPrev(nody);
			nody.setNext(newnode);
		}
		size += 1;
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
		String str = "[";
		for(int i = 0; i < size() - 1; i++){
			str = str + nthNode(i).getData() + ", ";
		}
		str = str + nthNode(size() - 1).getData() + "]";
		return str;
	}
}