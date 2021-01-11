public class MyLinkedList{
	private int size;
	private Node head;
	private Node tail;

	public MyLinkedList(){
		size = 0;
		head = null;
		tail = null;
	}

	public int size(){
		return size;
	}

	private Node nthNode(int index){
		if(index < size() / 2){
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

	public void add(int index, String value){
		if(index > size() || index < 0)
			throw new IndexOutOfBoundsException("The index is out of bounds");
		if(index == size())
			add(value);
		else{
			Node newnode = new Node(value);
			Node nod = nthNode(index);
			Node nody = nthNode(0);
			if(index > 0)
				nody = nthNode(index - 1);
			nod.setPrev(newnode);
			newnode.setNext(nod);
			if(index == 0)
				head = newnode;
			else{
				newnode.setPrev(nody);
				nody.setNext(newnode);
			}
			size += 1;
		}
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
		if(size() > 0)
			str = str + nthNode(size() - 1).getData() + "]";
		else
			str = "[]";
		return str;
	}

	public String toStringReversed(){
		String str = "[";
		for(int i = 0; i < size() - 1; i++){
			str = str + nthNode(size() - i - 1).getData() + ", ";
		}
		if(size() > 0)
			str = str + nthNode(0).getData() + "]";
		else
			str = "[]";
		return str;
	}

	public String remove (int index){
		if(index >= size() || index < 0)
			throw new IndexOutOfBoundsException("The index is out of bounds");
		String oldvalue = nthNode(index).getData();
		Node nody = nthNode(0);
		Node nod = nthNode(0);
		if(size() == 1){
			head = null;
			tail = null;
		}else if(index == 0){
				nody = nthNode(1);
				nody.setPrev(null);
				head = nody;
		}else if(index == size() - 1){
				nod = nthNode(size() - 2);
				nod.setNext(null);
				tail = nod;
		}else{
				nody = nthNode(index - 1);
				nod = nthNode(index + 1);
				nody.setNext(nod);
				nod.setPrev(nody);
		}
		size -= 1;
		return oldvalue;
	}

	public void extend(MyLinkedList other){
		Node nody = other.head;
		Node nod = tail;
		int newsize = size() + other.size();
		nod.setNext(nody);
		if(other.size() > 0){
			nody.setPrev(nod);
			tail = other.tail;
		}
		size = newsize;
		other.head = null;
		other.tail = null;
		other.size = 0;
	}
		
				
				
}