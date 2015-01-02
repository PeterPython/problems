// Problem 2.2: Implement an algorithm to find the kth to last element of a singly linked list.
// Page 77. Solution 185

import java.util.Iterator;

public class LinkedList<Item> implements Iterable<Item> {
	private Node first = null;

	private class Node {
		Item item;
		Node next;

		Node(Item item, Node next) {
			this.item = item;
			this.next = next;
		}
	}

	public void add(Item item) {
		first = new Node(item, first);
	}

	public Iterator<Item> iterator() {
		return new ListIterator();
	}

	private class ListIterator implements Iterator<Item> {
		private Node current = first;

		public boolean hasNext() {
			return current != null;
		}

		public Item next() {
			Item item = current.item;
			current = current.next;
			return item;
		}

		public void remove() {}
	}

	// Implement an algorithm to find the kth to last element of a singly linked list.
	public Item findKthNode(int k) {
		Node p1 = first;
		Node p2 = first;

		for(int i=0; i<k; i++) {
			p2 = p2.next;
		}

		while(p2.next != null) {
			p1 = p1.next;
			p2 = p2.next;
		}

		return p1.item;
	}


	// Main
	public static void main(String args[]) {
		LinkedList<Integer> ll = new LinkedList<Integer>();

		for(int i=1; i<=10; i++) {
			ll.add(i);
		}

		for(Integer i : ll) {
			System.out.print(i + " ");
		}
		System.out.println();

		System.out.println("findKthNode(0): " + ll.findKthNode(0));
		System.out.println("findKthNode(1): " + ll.findKthNode(1));
		System.out.println("findKthNode(9): " + ll.findKthNode(9));
	}
}