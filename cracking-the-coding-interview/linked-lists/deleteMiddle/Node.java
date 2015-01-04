// Problem 2.3: Implement an algorithm to delete a node in the middle of a singly linked list, given only access to that node.
// Page 77. Solution 187

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

	public Node deleteNode(Node head, Item item) {
		Node node = head;

		if(node.item == item) {
			return node.next;
		}

		while(node.next != null) {
			if(node.next.item == item) {
				node.next = node.next.next;
				return head;
			}
			node = node.next;
		}
		return head;
	}

	// Implement an algorithm to delete a node in the middle of a singly linked list, given only access to that node.
	public static void deleteMiddle(Node middle) {
		if(middle == null || middle.next == null) {
			return;
		}

		middle.item = middle.next.item;
		middle.next = middle.next.next;
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

		Node nod = n.deleteNode(n, 4);

		for(i=nod; i.hasNext(); i=i.next) {
			System.out.print(i.item + " ");
		}
		System.out.print(i.item);
		System.out.println();
	}
}