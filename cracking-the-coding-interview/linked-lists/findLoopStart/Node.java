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

	}
}