// Problem 3.1: Describe how you could use a single array to implement three stacks
// This is the implementation and approach from the book
// Page 80. Solution 202

public class ThreeStacksTwo {
	private int array[];
	private int pointer[] = {0, 0, 0};
	private int size;

	ThreeStacksTwo(int size) {
		array = new int[size*3];
		this.size = size;
	}

	public void push(int i, int stackNumber) {
		if(pointer[stackNumber] >= (stackNumber+1)*size) {
			throw new RuntimeException("Stack is full");
		}
		else {
			array[goToStack(stackNumber)] = i;
			pointer[stackNumber]++;
		}
	}

	public int pop(int stackNumber) {
		if(pointer[stackNumber] == 0) {
			throw new RuntimeException("Stack is empty");
		}
		else {
			pointer[stackNumber]--;
			return array[goToStack(stackNumber)];
		}
	}

	public static int goToStack(int stackNumber) {
		return (stackNumber * size) + (pointer[stackNumber]);
	}

}