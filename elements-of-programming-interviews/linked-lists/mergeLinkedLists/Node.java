// Problem 7.1: Write a function that takes Land F, and returns the
// merge of Land F. Your code should use O(1) additional storage-it 
// should reuse the nodes from the lists provided as input.
// Page63. Solution 207

public class Node<Item> {
	Item item;
	Node next;

	public Node(Item item) {
		this.item = item;
	}

	public void add(Item item) {
		Node current = this;
		Node end = new Node(item);

		while(current.next != null) {
			current = current.next;
		}

		current.next = end;
	}

	public boolean hasNext() {
		return next != null;
	}

	public Node merge(Node n, Node m) {
		Node merged;
		Node mergedHead;

		while(n != null || m != null) {
			if(n.item < m.item) {
			}
		}
	}

	// Main
	public static void main(String args[]) {

	}
}