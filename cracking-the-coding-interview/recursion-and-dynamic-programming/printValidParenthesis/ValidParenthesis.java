// Problem 9.6: Implement an algorithm to print all valid (i.e., properly
// opened and closed) combinations of n-pairs of parentheses.
// Page 110. Solution 325

import java.util.ArrayList;

public class ValidParenthesis {
	public static ArrayList<String> printValidParenthesis(int pairs) {
		char str[] = new char[pairs*2];
		ArrayList<String> list = new ArrayList<String>();
		printValidParenthesis(list, pairs, pairs, str, 0);
		return list;
	}

	public static void printValidParenthesis(ArrayList<String> list, 
		int leftParenCount, int rightParenCount, char str[], int count) {

		// Invalid order
		if(leftParenCount < 0 || rightParenCount < leftParenCount) {
			return;
		}

		// No more parenthesis left
		if(leftParenCount == 0 && rightParenCount == 0) {
			String s = new String(str);
			list.add(s);
		}

		else {
			if(leftParenCount > 0) { //  Add left paren, if there are any left parens remaining
				str[count] = '(';
				printValidParenthesis(list, leftParenCount-1, rightParenCount, str, count+1);
			}

			if(rightParenCount > 0) { // Add right paren., if expression is valid
				str[count] = ')';
				printValidParenthesis(list, leftParenCount, rightParenCount-1, str, count+1);
			}
		}
	}


	// Main
	public static void main(String args[]) {
		ArrayList<String> list = printValidParenthesis(2);
		for(String str : list) {
			System.out.println(str);
		}
	}
}