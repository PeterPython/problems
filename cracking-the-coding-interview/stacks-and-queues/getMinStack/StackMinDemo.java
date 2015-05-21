// Demo for Problem 3.2
// Problem 3.2: How would you design a stack which, in addition to 
// push and pop, also has a function min which returns the minimum 
// element? Push, pop and min should all operate in O(1) time.
// Page 80. Solution 206.

public class StackMinDemo {
	public static void main(String args[]) {

		System.out.println("Stack 1: ");
		StackMin<Integer> st = new StackMin<Integer>();

		st.push(5);
		st.push(4);
		System.out.println(st.min());

		st.push(3);
		System.out.println(st.min());

		st.pop();
		System.out.println(st.min());

		st.pop();
		System.out.println(st.min());


		System.out.println("\nStack 2: ");
		StackMinTwo st2 = new StackMinTwo();
		st2.push(5);
		st2.push(4);
		System.out.println(st2.min());

		st2.push(3);
		System.out.println(st2.min());

		st2.pop();
		System.out.println(st2.min());

		st2.pop();
		System.out.println(st.min());
	}
}