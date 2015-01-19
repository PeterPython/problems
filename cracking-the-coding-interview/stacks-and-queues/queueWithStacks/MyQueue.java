// Problem 3.5: Implement a MyQueue class which implements a queue using two stacks.
// Page 81. Solution 213

import java.util.Stack;

public class MyQueue<Item> {
	Stack<Item> addStack, removeStack;

	public MyQueue() {
		addStack = new Stack<Item>();
		removeStack = new Stack<Item>();
	}

	// Add item to the Queue
	public void add(Item item) {
		while(!removeStack.isEmpty()) {
			addStack.push(removeStack.pop());
		}
		addStack.push(item);
	}

	// Remove item from the Queue
	public Item remove() {
		while(!addStack.isEmpty()) {
			removeStack.push(addStack.pop());
		}
		return removeStack.pop();
	}

	public boolean isEmpty() {
		return (addStack.isEmpty() && removeStack.isEmpty());
	}
}