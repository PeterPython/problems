// Program to reverse a Linked List

public class Node<Item> {
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

	public static Node reverseLinkedList(Node head) {
		if(head == null || head.next == null) {
			return null;
		}
		Node second = head.next;
		head.next = null;
		Node first = head;
		
		while(second.next != null) {
			Node temp = second.next;
			second.next = first;
			first = second;
			second = temp;
		}
		second.next = first;
		first = second;

		return first;
	}


	// Using recursion to reverse LinkedList
	public static Node recursiveReverse(Node node) {
		return recursiveReverse(node, null);
	}

	// Using recursion to reverse LinkedList
	public static Node recursiveReverse(Node current, Node prev) {
		if(current == null) {
			return null;
		}

		// If previous node is not null set next to previous
		Node next = current.next;
		if(prev != null) {
			current.next = prev;
		}
		else {
			current.next = null;
		}

		// When reach the end of Linked List
		if(next == null) {
			return current;
		}

		return recursiveReverse(next, current);
	}


	// Main
	public static void main(String args[]) {
		Node ll = new Node(1);
		ll.add(2);
		ll.add(3);
		ll.add(4);

		Node i;
		for(i=ll; i.next!=null; i=i.next) {
			System.out.print(i.item + " ");
		}
		System.out.print(i.item);
		System.out.println();

		Node ll2 = reverseLinkedList(ll);

		for(i=ll2; i.next!=null; i=i.next) {
			System.out.print(i.item + " ");
		}
		System.out.print(i.item);
		System.out.println();
		System.out.println("Recursive: ");

		Node ll3 = new Node(1);
		ll3.add(2);
		ll3.add(3);
		ll3.add(4);

		Node ll4 = recursiveReverse(ll3);
		for(i=ll4; i.next!=null; i=i.next) {
			System.out.print(i.item + " ");
		}
		System.out.print(i.item);
		System.out.println();
	}
}