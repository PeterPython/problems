public class Node<Item> {
	public Item item;
	public Node next;

	public Node(Item item) {
		this.item = item;
	}

	public void add(Item item) {
		Node tail = new Node(item);
		Node current = this;

		while(current.next != null) {
			current = current.next;
		}

		current.next = tail;
	}

	public boolean hasNext() {
		return next != null;
		// return this != null;
	}

	// Main
	public static void main(String args[]) {
		Node n = new Node(1);
		n.add(2);
		n.add(3);
		n.add(4);

		Node i;
		for(i=n; i.hasNext(); i=i.next) {
			System.out.print(i.item + " ");
		}
		System.out.print(i.item);
		System.out.println();
	}
}