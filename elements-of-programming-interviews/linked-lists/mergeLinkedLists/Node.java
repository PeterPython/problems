// Problem 7.1: Write a function that takes Land F, and returns the
// merge of Land F. Your code should use O(1) additional storage-it 
// should reuse the nodes from the lists provided as input.
// Page63. Solution 207

public class Node<Item extends Comparable<Item>> {
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

	// Problem 7.1
	public static Node merge(Node n, Node m) {
		Node merged = null;
		Node mergedHead = null;

		while(n != null && m != null) {
			if((n.item).compareTo(m.item) < 0) {
				if(merged == null) {
					merged = n;
					mergedHead = n;
				}
				else {
					merged.next = n;
					merged = merged.next;
				}
				n = n.next;
			}
			else {
				if(merged == null) {
					merged = m;
					mergedHead = m;
				}
				else {
					merged.next = m;
					merged = merged.next;
				}
				m = m.next;
			}
		}

		// The rest of the list if they are not the same size
		while(n != null) {
			merged.next = n;
			n = n.next;
		}

		while(m != null) {
			merged.next = m;
			m = m.next;
		}

		return mergedHead;
	}

	// Main
	public static void main(String args[]) {
		Node n = new Node(2);
		n.add(5);
		n.add(7);

		Node m = new Node(3);
		m.add(11);

		Node merged = merge(n, m);
		Node i;
		for(i=merged; i.hasNext(); i=i.next) {
			System.out.print(i.item + " ");
		}
		System.out.println(i.item);
	}
}