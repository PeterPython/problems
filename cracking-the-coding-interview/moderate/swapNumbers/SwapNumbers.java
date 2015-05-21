// Problem 17.1: Write a function to swap a number in place (that is, without temporary variables).
// Page 163. Solution 130.

public class SwapNumbers {
	public static void main(String args[]) {
		int a = 1;
		int b = 9;

		a = a^b;
		b = a^b;
		a = a^b;

		System.out.println(a);
		System.out.println(b);
	}
}