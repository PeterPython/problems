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

public class SetOfStacks<Item> {
	private Node first;

	private class Node {
		Item item;
		Node next;

		public Node(Item item) {
			this.item = item;
		}
	}

	public void push(Item item) {
		Node oldFirst = first;
		first = new Node(item);
		first.next = oldFirst;
	}

	public Item pop() {
		if(first != null) {
			Item item = first.item;
			first = first.next;
			return item;
		}
		else {
			return null;
		}
	}
}