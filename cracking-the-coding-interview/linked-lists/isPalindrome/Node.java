public class Node<Item> {
	Item item;
	Node next;

	Node(Item item) {
		this.item = item;
	}

	public void add(Item item) {
		Node current = this;
		Node end = new Node(item);

		while(current.next != null) {
			current = current.next;
		}

		current.next = end;
	}

	public boolean hasNext() {
		return next != null;
	}


	// Main
	public static void main(String args[]) {
		
	}
}