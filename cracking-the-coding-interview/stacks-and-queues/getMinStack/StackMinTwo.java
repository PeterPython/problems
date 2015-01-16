// Problem 3.2: How would you design a stack which, in addition to 
// push and pop, also has a function min which returns the minimum 
// element? Push, pop and min should all operate in O(1) time.
// Approach and implementation from the book
// Page 80. Solution 206. You have to use two stacks

import java.util.Stack;

public class StackMinTwo extends Stack<Integer> {
	Stack<Integer> min;

	public StackMinTwo() {
		min = new Stack<Integer>();
	}

	public void push(int item) {
		if(item <= min()) {
			min.push(item);
		}
		super.push(item);
	}

	public Integer pop() {
		int value = super.pop();
		if(value == min()) {
			min.pop();
		}
		return value;
	}

	public Integer min() {
		if(min.isEmpty()) {
			return Integer.MAX_VALUE;
		}
		else {
			return min.peek();
		}
	}
}