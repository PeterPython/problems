// Problem 2.7: Implement a function to check if a linked list is a palindrome
// Page 78. Solution 196

import java.util.Stack;

public class Node<Item> {
	Item item;
	Node next;

	Node(Item item) {
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


	// Problem 2.7: Implement a function to check if a linked list is a palindrome
	public boolean isPalindrome(Node head) {
		Node slowRunner = head;
		Node fastRunner = head;

		Stack<Item> reverse = new Stack<Item>();

		// Add elements to the stack until the middle
		while(fastRunner != null && fastRunner.next != null) {
			reverse.push((Item) slowRunner.item);
			slowRunner = slowRunner.next;
			fastRunner = fastRunner.next.next;
		}

		// If the number of elements is odd we need to skip the middle element
		if(fastRunner != null) {
			slowRunner = slowRunner.next;
		}

		// Compare
		while(slowRunner != null) {
			if(reverse.peek() != slowRunner.item) {
				return false;
			}
			reverse.pop();
			slowRunner = slowRunner.next;
		}
		return true;
	}

	// Main
	public static void main(String args[]) {
		Node n = new Node(0);
		n.add(1);
		n.add(2);
		n.add(3);
		n.add(2);
		n.add(1);
		n.add(0);

		System.out.println("Is palindrome?: " + n.isPalindrome(n));
	}
}