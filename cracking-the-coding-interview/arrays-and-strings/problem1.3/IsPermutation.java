// Problem 1.3 Given two strings,write a method to decide if one is a permutation of the other.
// Page 174

import java.util.*;

class IsPermutation {

	// isPermutation method that uses sort
	public static boolean isPermutation(String str1, String str2) {
		if(str1.length() != str2.length()) {
			return false;
		}

		// Sort str1
		char stChar[] = str1.toCharArray();
		Arrays.sort(stChar);
		str1 = new String(stChar);

		// Sort str2
		stChar = str2.toCharArray();
		Arrays.sort(stChar);
		str2 = new String(stChar);

		return(str1.equals(str2));
	}

	// More efective isPermutation method
	public static boolean isPermutation2(String str1, String str2) {
		if(str1.length() != str2.length()) {
			return false;
		}

		int intArray[] = new int[256];

		char charArray[] = str1.toCharArray();

		for(char c : charArray) {
			intArray[c]++;
		}

		for(int i=0; i<str2.length(); i++) {
			int c = str2.charAt(i);
			if(--intArray[c] < 0) {
				return false;
			}
		}

		return true;
	}


	// Main
	public static void main(String args[]) {
		String str1 = "abc";
		String str2 = "acbd";
		String str3 = "cba";

		System.out.println(isPermutation(str1, str2)); // false
		System.out.println(isPermutation(str1, str3)); // true
		System.out.println(isPermutation2(str1, str2)); // false
		System.out.println(isPermutation2(str1, str3)); // true
	}
}