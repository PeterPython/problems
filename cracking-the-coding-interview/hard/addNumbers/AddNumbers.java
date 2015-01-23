// Problem 18.1: Write a function that adds two numbers. You should not use + or any arithmetic operators.
// Page 167. Solution 462

public class AddNumbers {
	public static int addNumbers(int a, int b) {
		if(b == 0) {
			return a;
		}
		int sum = a^b;   // Add without carry
		int carry = (a&b) << 1;  // Carry, but don't add

		return addNumbers(sum, carry);  // Recurse
	}


	public static void main(String args[]) {
		int sum = addNumbers(2, 5);

		System.out.println(sum);
	}
}