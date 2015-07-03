// Merging two sorted LinkedLists

public class Node {
	int item;
	Node next;

	public Node(int item) {
		this.item = item;
	}

	public void add(int item) {
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

	// Iterative Solution
	public static Node merge(Node n1, Node n2) {
		Node head = n1;  // Keep a pointer at the beginning of the node
		Node p = n1;  // Pointer to connect nodes

		// If n1 is null return n2 and viceversa
		if(n1 == null) {
			return n2;
		}
		else if(n2 == null) {
			return n1;
		}
		else if(n1 == null && n2 == null) {
			return null;
		}

		// Set p and head pointing to smallest node first
		if(n1.item < n2.item) {
			p = n1;
			head = n1;
			n1 = n1.next;
		}
		else {
			p = n2;
			head = n2;
			n2 = n2.next;
		}

		// Start traversing both lists and merging them
		while(n1 != null && n2 != null) {
			if(n1.item < n2.item) {
				p.next = n1;
				p = p.next;
				n1 = n1.next;
			}
			else {
				p.next = n2;
				p = p.next;
				n2 = n2.next;
			}
		}

		// Traverse the rest of the linked list
		if(n1 != null) {
			p.next = n1;
			p = p.next;
		}
		if(n2 != null) {
			p.next = n2;
			p = p.next;
		}

		return head;
	}


	public static void main(String args[]) {
		Node n1 = new Node(4);
		n1.add(3);
		n1.add(6);
		n1.add(9);

		Node n2 = new Node(2);
		n2.add(4);
		n2.add(7);
		n2.add(8);
		n2.add(10);

		Node merged = merge(n1, n2);

		Node i;
		for(i=merged; i.hasNext(); i=i.next) {
			System.out.print(i.item + " ");
		}
		System.out.print(i.item);
		System.out.println();
	}
}