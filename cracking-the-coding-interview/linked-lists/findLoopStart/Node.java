// Problem 2.6: Given a circular linked list, implement an algorithm which returns the node at the beginning of the loop.
// Page 78. Solution 193

public class Node<Item> {
	Item item;
	Node next;

	Node(Item item) {
		this.item = item;
	}

	public void add(Item item) {
		Node end = new Node(item);
		Node current = this;

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
		Node n = new Node(1);
		for(int i=2; i<=10; i++) {
			n.add(i);
		}

		Node i;
		for(i=n; i.hasNext(); i=i.next) {
			System.out.print(i.item + " ");
		}
		System.out.print(i.item);
		System.out.println();
	}
}