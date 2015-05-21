// Problem 4.2: Given a directed graph, design an algorithm 
// to find out whether there is a route between two nodes.
// Page 86. Solution 221

import java.util.Iterator;

public class Bag<Item> implements Iterable<Item> {
	private Node first;

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
}