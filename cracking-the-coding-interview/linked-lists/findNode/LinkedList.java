import java.util.Iterator;

public class LinkedList<Item> implements Iterable<Item> {
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


	public static void main(String args[]) {
		LinkedList<Integer> ll = new LinkedList<Integer>();

		for(int i=1; i<=10; i++) {
			ll.add(i);
		}

		for(Integer i : ll) {
			System.out.print(i + " ");
		}
		System.out.println();
	}
}