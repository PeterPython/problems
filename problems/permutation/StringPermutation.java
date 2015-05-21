// Get all the permutations of a string
// http://stackoverflow.com/questions/4240080/generating-all-permutations-of-a-given-string

import java.util.ArrayList;

public class StringPermutation {
	public static void getPermutations(String str) {
		getPermutations("", str);
	}

	private static void getPermutations(String prefix, String str) {
		int n = str.length();

		if(n == 0) {
			System.out.println(prefix);
		}

		for(int i=0; i<n; i++) {
			getPermutations(prefix + str.charAt(i), str.substring(0,i) + str.substring(i+1));
		}
	}

	// Put the permutations into an Array List
	public static ArrayList<String> getPermutationsToArray(String str) {
		ArrayList<String> array = new ArrayList<String>();
		getPermutationsToArray(array, "", str);
		return array;
	}

	public static void getPermutationsToArray(ArrayList<String> array, String prefix, String str) {
		int n = str.length();

		if(n == 0) {
			array.add(prefix);
		}

		for(int i=0; i<n; i++) {
			getPermutationsToArray(array, prefix + str.charAt(i), str.substring(0,i) + str.substring(i+1));
		}
	}

	// Main
	public static void main(String args[]) {
		String str = "abc";

		System.out.println("Original String: " + str + "\n");

		System.out.println("Permutations: ");
		getPermutations(str);
		System.out.println();
		System.out.println("Permutations to Array List:");
		ArrayList<String> array = getPermutationsToArray("abc");

		for(String s : array) {
			System.out.println(s);
		}
	}
}