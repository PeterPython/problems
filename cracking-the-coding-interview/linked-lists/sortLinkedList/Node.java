// Problem 2.4: Write code to partition a linked list around a value x, 
// such that all nodes less than come before alt nodes greater than or equal to x.
// Page 77. Solution 188

public class Node<Item extends Comparable<Item>> {
	Item item;
	Node next;

	public Node(Item item) {
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


	// Problem 2.4
	public Node sortLinkedList(Node head, Item x) {
		Node current = head;

		Node lessThan = null;
		Node lessThanHead = null;
		Node greaterThan = null;
		Node greaterThanHead = null;

		while(current != null) {
			if(current.item.compareTo(x) < 0) {
				if(lessThan == null) {
					lessThanHead = current;
					lessThan = lessThanHead;
				}
				else {
					lessThan.next = current;
					lessThan = lessThan.next;
				}
			}
			else {
				if(greaterThan == null) {
					greaterThanHead = current;
					greaterThan = greaterThanHead;
				}
				else {
					greaterThan.next = current;
					greaterThan = greaterThan.next;
				}
			}
			current = current.next;
		}

		if(lessThanHead == null) {
			return greaterThanHead;
		}

		// Concatenate
		lessThan.next = greaterThanHead;

		return lessThanHead;
	}

	public Node changeNode(Node n) {
		n.next = null;
		return n;
	}


	public boolean hasNext() {
		return next != null;
		// return this != null;
	}

	// Main
	public static void main(String args[]) {
		Node n = new Node(2);
		n.add(4);
		n.add(1);
		n.add(7);
		n.add(6);
		n.add(3);
		n.add(5);

		Node i;
		for(i=n; i.hasNext(); i=i.next) {
			System.out.print(i.item + " ");
		}
		System.out.print(i.item);
		System.out.println();

		Node nod = n.sortLinkedList(n, 4);

		for(i=nod; i.hasNext(); i=i.next) {
			System.out.print(i.item + " ");
		}
		System.out.print(i.item);
		System.out.println();

		// n.changeNode(n);

		// Node i;
		// for(i=n; i.hasNext(); i=i.next) {
		// 	System.out.print(i.item + " ");
		// }
		// System.out.print(i.item);
		// System.out.println();
	}
}