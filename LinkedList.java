public class LinkedList {

	protected Node head;
	protected int size;	

	public LinkedList() {
		head = null;	
		size = 0;
	}

	public void clear() {
		head = null;
		size = 0;
	}

	public Node head() {
		return head;
	}
	
	//adds a node to the end of a current list 
	public void add(Object item) { 
		if(head == null) {
			head = new Node(item);
			size++;
		} else {
			Node current = head;
			while(current.getNext() != null) {
				current = current.getNext();
			}
			current.setNext(new Node(item));
			size++;
		}
	}

	//removes a particular node
	public boolean remove(Object item) { 
		if (size == 0)
			return false;
		if (item.equals(head.getItem())) {
			head = head.getNext();
			size--;
			return true;
		} else {
			Node curr = head;
			while (curr.getNext() != null && !item.equals(curr.getNext().getItem())) {
				curr = curr.getNext();
			}
			if (curr.getNext() == null)
				return false;
			else {
				curr.setNext(curr.getNext().getNext());
				size--;
				return true;
			}
		}
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public String toString() {
		String s = "[" + size + ": ";
		for (Node current = head; current != null; current = current.getNext())
			s += current.getItem().toString() + " ";
		return s + "]";
	}

	//inner node class
	public class Node {
		private Object item;
		private Node next;

		public Node(Object item) {
			this.item = item;
			this.next = null;
		}
		public Node(Object item, Node next) {
			this.item = item;
			this.next = next;
		}
		public void setNext(Node nextNode) {
			next = nextNode;
		}
		public Node getNext() {
			return next;
		}
		public Object getItem() {
			return item;
		}
		public void setItem(Object item){
			this.item = item;
		}
		public String toString(){
			return item.toString();
		}
	}
}