// Problem 2.5: You have two numbers represented by a linked list, 
// where each node contains a single digit. The digits are stored in 
// reverse order, such that the Ts digit is at the head of the list. 
// Write a function that adds the two numbers and returns the sum as a linked list.
// page 77. Solution 190

public class Node {
	int item;
	Node next;

	Node(int item) {
		this.item = item;
	}

	public void add(int item) {
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

	public static Node addNumbers(Node n, Node m) {
		Node sum = null;
		int carry = 0;
		int partial;

		while(n != null || m != null) {
			partial = n.item + m.item + carry;

			// Check if has to carry
			if(partial < 10) {
				carry = 0;
			}
			else {
				partial -= 10;
				carry = 1; 
			}

			// Check if sum has been initilized
			if(sum == null) {
				sum = new Node(partial);
			}
			else {
				sum.add(partial);
			}

			// Check if n and m has reached null
			if(n != null) {
				n = n.next;
			}
			else {
				n.item = 0;
			}

			if(m != null) {
				m = m.next;
			}
			else {
				m.item = 0;
			}
		}

		if(carry == 1) {
			sum.add(1);
		}

		return sum;
	}


	// Main
	public static void main(String args[]) {
		Node n = new Node(7);
		n.add(1);
		n.add(6);

		System.out.print("n = 617: ");
		Node i;
		for(i=n; i.hasNext(); i=i.next) {
			System.out.print(i.item + " ");
		}
		System.out.print(i.item);
		System.out.println();

		Node m = new Node(5);
		m.add(9);
		m.add(2);

		System.out.print("m = 295: ");
		for(i=m; i.hasNext(); i=i.next) {
			System.out.print(i.item + " ");
		}
		System.out.print(i.item);
		System.out.println();


		Node sum = addNumbers(n, m);

		System.out.print("Sum: ");
		for(i=sum; i.hasNext(); i=i.next) {
			System.out.print(i.item + " ");
		}
		System.out.print(i.item);
		System.out.println();
	}
}