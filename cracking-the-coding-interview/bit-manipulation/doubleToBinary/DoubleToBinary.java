/*
Problem 5.2: 
Given a real number between 0 and 1 (e.g.,0.72) that is passed in as a double, 
print the binary representation. If the number cannot be represented accurately 
in binary with at most 32 characters, print "ERROR."
Page 92. Solution 243
*/

import java.util.Stack;

public class DoubleToBinary {
	public static String doubleToBinary(double n) {
		Stack<Integer> st = new Stack<Integer>();
		int num = (int) n;
		String bin = "";  // You should use StringBuilder (append method) instead of String concatenation

		while(num != 0) {
			st.push(num & 1);
			num >>= 1;
		}

		while(!st.isEmpty()) {
			bin += st.pop().toString();
		}
		bin += ".";

		// Fraction part
		double fraction = n - Math.floor(n);
		int binDecimal;

		while(fraction > 0) {
			binDecimal = (int) (fraction*2);
			bin += "" + binDecimal;
			fraction = (fraction*2) - (double) binDecimal;
		}

		return bin;
	}


	public static void main(String args[]) {
		double d = 153.625;

		System.out.println(doubleToBinary(d));
	}
}