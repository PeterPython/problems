// Demo for Problem 3.6: Stack sorting

import java.util.Stack;

public class Demo {
	public static void main(String args[]) {
		Stack<Integer> st = new Stack();
		st.push(6);
		st.push(7);
		st.push(5);
		st.push(3);
		st.push(4);
		st.push(2);
		st.push(1);

		Stack<Integer> sorted = SortedStack.sort(st);

		for(int i : sorted) {
			System.out.print(i + " ");
		}
		System.out.println();
	}
}