// Problem 3.2: How would you design a stack which, in addition to 
// push and pop, also has a function min which returns the minimum 
// element? Push, pop and min should all operate in O(1) time.
// Page 80. Solution 206. You have to use two stacks

public class StackMin<Item extends Comparable<Item>> {
	private Node first = null;
	private Node firstMin = null;

	private class Node {
		Item item;
		Node next;

		Node(Item item) {
			this.item = item;
		}
	}

	public void push(Item item) {
		Node oldFirst = first;
		first = new Node(item);
		first.next = oldFirst;

		if(firstMin==null || item.compareTo(firstMin.item) <0) {
			Node oldFirstMin = firstMin;
			firstMin = new Node(item);
			firstMin.next = oldFirstMin;
		}
	}

	public Item pop() {
		if(first != null) {
			Item item = first.item;
			first = first.next;

			if(item == firstMin.item) {
				firstMin = firstMin.next;
			}

			return item;
		}
		else {
			return null;
		}
	}

	public Item min() {
		return firstMin.item;
	}

	public Item peek() {
		return first.item;
	}
}