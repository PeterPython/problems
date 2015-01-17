/*
Problem 3.3: Imagine a (literal) stack of plates. If the stack gets 
too high, it migh t topple. Therefore, in real life, we would likely 
start a new stack when the previous stack exceeds some threshold. 
Implement a data structure SetOfStacks that mimics this. SetOfStacks 
should be composed of several stacks and should create a new stack 
once the previous one exceeds capacity. SetOfStacks.push() and 
SetOfStacks.pop() should behave identically to a single stack (that 
is, pop() should return the same values as it would if there were 
just a single stack).
Page 80. Solution 208
*/

import java.util.Stack;
import java.util.ArrayList;

public class SetOfStacks {
	private ArrayList<Stack> stacksArray = new ArrayList<Stack>();
	private int capacity;

	public SetOfStacks(int capacity) {
		this.capacity = capacity;
	}

	public Stack getLastStack() {
		if(stacksArray.size() == 0) {
			return null;
		}
		else {
			return stacksArray.get(stacksArray.size()-1);
		}
	}

	public void push(int item) {
		Stack last = getLastStack();
		if(last != null && last.size() != capacity-1) {
			last.push(item);
		}
		else {
			Stack st = new Stack<Integer>();
			st.push(item);
			stacksArray.add(st);
		}
	}

	public int pop() {
		Stack last = getLastStack();
		int item = (int) last.pop();  // If last == null it will return null
		if(last.size() == 0) {
			stacksArray.remove(stacksArray.size()-1);
		}
		return item;
	}


	// Main
	public static void main(String args[]) {
		SetOfStacks ss = new SetOfStacks(3);
		ss.push(1);
		ss.push(2);
		ss.push(3);

		ss.pop();
		ss.pop();
		ss.pop();

		ss.push(1);
		ss.push(2);
		ss.push(3);

		ss.push(4);
	}
}