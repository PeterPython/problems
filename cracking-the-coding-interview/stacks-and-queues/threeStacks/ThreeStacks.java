// Problem 3.1: Describe how you could use a single array to implement three stacks
// Page 80. Solution 202

public class ThreeStacks {
	private int first;
	private int second;
	private int third;
	private int size;
	private int array[];

	public ThreeStacks(int size) {
		array = new int[size];
		this.size = size;
		first = 0;
		second = size/3;
		third = (size*2)/3;
	}

	// First stack
	public void pushFirst(int i) {
		if(first <= (size/3)-1) {
			array[first++] = i;
		}
		else {
			throw new RuntimeException("First stack is full");
		}
	}

	public int popFirst() {
		if(first == 0) {
			throw new RuntimeException("First Stack is empty");
		}
		else {
			return array[--first];
		}
	}


	// Second stack
	public void pushSecond(int i) {
		if(second <= ((size*2)/3)-1) {
			array[second++] = i;
		}
		else {
			throw new RuntimeException("Second stack is full");
		}
	}

	public int popSecond() {
		if(second <= size/3) {
			throw new RuntimeException("Second stack is empty");
		}
		else {
			return array[--second];
		}
	}


	// Third stack
	public void pushThird(int i) {
		if(third < size) {
			array[third++] = i;
		}
		else {
			throw new RuntimeException("Third stack is full");
		}
	}

	public int popThird() {
		if(third <= ((size*2)/3)) {
			throw new RuntimeException("Third Stack is empty");
		}
		else {
			return array[--third];
		}
	}


	public static void main(String args[]) {
		ThreeStacks st = new ThreeStacks(9);

		// Push to First Stack
		st.pushFirst(1);
		st.pushFirst(2);
		st.pushFirst(3);

		// Pop First Stack
		st.popFirst();
		st.popFirst();
		st.popFirst();

		// Push back to First Stack
		st.pushFirst(1);
		st.pushFirst(2);
		st.pushFirst(3);

		// Push to Second Stack
		st.pushSecond(4);
		st.pushSecond(5);
		st.pushSecond(6);

		// Pop Second Stack
		st.popSecond();
		st.popSecond();
		st.popSecond();

		// Push to Third Stack
		st.pushThird(7);
		st.pushThird(8);
		st.pushThird(9);

		// Pop Third Stack
		st.popThird();
		st.popThird();
		st.popThird();
	}
}