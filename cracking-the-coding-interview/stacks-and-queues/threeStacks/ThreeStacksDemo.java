// Demo for Problem 3.1
// Problem 3.1: Describe how you could use a single array to implement three stacks
// Page 80. Solution 202

public class ThreeStacksDemo {
	public static void main(String args[]) {

		System.out.println("First implementation");
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


		System.out.println("Second implementation");
		ThreeStacksTwo st2 = new ThreeStacksTwo(3);

		// Push to First Stack
		st2.push(1, 0);
		st2.push(2, 0);
		st2.push(3, 0);

		// Pop First Stack
		st2.pop(0);
		st2.pop(0);
		st2.pop(0);

		// Push back to First Stack
		st2.push(1, 0);
		st2.push(2, 0);
		st2.push(3, 0);

		// Push to Second Stack
		st2.push(4, 1);
		st2.push(5, 1);
		st2.push(6, 1);

		// Pop Second Stack
		st2.pop(1);
		st2.pop(1);
		st2.pop(1);

		// Push to Third Stack
		st2.push(7, 2);
		st2.push(8, 2);
		st2.push(9, 2);

		// Pop Third Stack
		st2.pop(2);
		st2.pop(2);
		st2.pop(2);
	}
}