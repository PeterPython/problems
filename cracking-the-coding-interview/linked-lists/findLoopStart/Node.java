// Problem 2.6: Given a circular linked list, implement an algorithm which returns the node at the beginning of the loop.
// Page 78. Solution 193

public class Node<Item> {
	Item item;
	Node next;

	Node(Item item) {
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

	public boolean hasNext() {
		return next != null;
	}

	public static Node findLoopStart(Node head) {
		Node slowRunner = head;
		Node fastRunner = head;

		// Find meeting point. Which is loopSize - k steps in the linkedlist
		while(fastRunner != null && fastRunner.next != null) {
			slowRunner = slowRunner.next;
			fastRunner = fastRunner.next.next;

			if(slowRunner == fastRunner) {   // Collision
				break;
			}
		}

		// Not a loop
		if(fastRunner == null || fastRunner.next == null) {
			return null;
		}

		slowRunner = head;
		while(slowRunner != fastRunner) {
			slowRunner = slowRunner.next;
			fastRunner = fastRunner.next;
		}

		return slowRunner;
	}


	// Main
	public static void main(String args[]) {
		Node n = new Node(1);
		for(int i=2; i<=11; i++) {
			n.add(i);
		}

		Node k = n.next.next.next;

		Node i;
		for(i=n; i.hasNext(); i=i.next) {
			System.out.print(i.item + " ");
		}
		System.out.print(i.item);
		System.out.println();
		i.next = k;

		Node beginning = findLoopStart(n);

		System.out.println("Beginning of loop: " + beginning.item);
	}
}