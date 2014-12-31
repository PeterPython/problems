// Sequential list
// Problem 2.1: Write code to remove duplicates from an unsorted linked list. Page 184

import java.util.HashSet;
import java.util.Iterator;

public class SequentialList<Item> implements Iterable<Item> {
	Node first = null;

	private class Node {
		Item data;
		Node next = null;

		Node(Item data, Node next) {
			this.data = data;
			this.next = next;
		}

		Node(Item data) {
			this.data = data;
		}
	}

	public void add(Item d) {
		first = new Node(d, first);
	}


	public void removeNode(Item item) {
		if(first == null) {
			return;
		}

		if(first.data == item) {
			first = first.next;
		}

		Node current = first;
		while(current.next != null) {
			if(current.next.data == item) {
				current.next = current.next.next;
			}
			current = current.next;
		}
		current.next = null;
	}

	// Problem 2.1: Write code to remove duplicates from an unsorted linked list.
	public void removeDuplicates() {
		Node current = first;
		Node previous = null;
		HashSet<Item> hash = new HashSet<Item>();

		while(current != null) {
			if(hash.contains(current.data)) {
				previous.next = current.next;
			}
			else {
				hash.add(current.data);
				previous = current;
			}
			current = current.next;
		}
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
			Item n = current.data;
			current = current.next;
			return n;
		}

		public void remove() {}
	}
}