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
	}
}