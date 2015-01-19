// Problem 3.6: Write a program to sort a stack in ascending order (with 
// biggest items on top). You may use at most one additional stack to 
// hold items, but you may not copy the elements into any other data 
// structure (such as an array). The stack supports the following 
// operations: push, pop, peek, and isEmpty.
// Page 81. Solution 215

import java.util.Stack;

public class SortedStack {
	public static Stack<Integer> sort(Stack<Integer> stack) {
		Stack<Integer> sorted = new Stack();
		int temp;

		while(!stack.isEmpty()) {
			temp = stack.pop();

			while(!sorted.isEmpty() && sorted.peek() > temp) {
				stack.push(sorted.pop());
			}

			sorted.push(temp);
		}	
		return sorted;
	}
}