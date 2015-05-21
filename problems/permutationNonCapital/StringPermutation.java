// Find all the permutations of a string but the Uppercase characters must remain in the same position

import java.util.*;

public class StringPermutation {
	public static HashMap<Integer, Character> getListUpper(String str) {

		// Put all the upper case letters in a hash map
		HashMap<Integer, Character> listUpperCase = new HashMap<Integer, Character>();

		for(int i=0; i<str.length(); i++) {
			if(String.valueOf(str.charAt(i)).matches("[A-Z]")) {
				listUpperCase.put(i, str.charAt(i));
			}
		}

		return listUpperCase;
	}

	public static void stringPermutation(String str) {
		HashMap<Integer, Character> listUpper = getListUpper(str);
		str = str.replaceAll("[A-Z]", "");  // Remove all the upper cases from the string
		stringPermutation("", str, listUpper);
	}

	public static void stringPermutation(String perm, String str, HashMap<Integer, Character> listUpper) {
		int n = str.length();

		if(n == 0) {
			String withUpper = putUpperBack(perm, listUpper);  // Put all the upper cases back to the string
			System.out.println(withUpper);
			return;
		}

		for(int i=0; i<n; i++) {
			stringPermutation(perm + str.charAt(i), str.substring(0, i) + str.substring(i+1), listUpper);
		}
	}

	// Put all the upper case back into the string
	public static String putUpperBack(String str, HashMap<Integer, Character> listUpper) {
		int n = str.length() + listUpper.size();
		StringBuilder builder = new StringBuilder();

		int i = 0;
		while(builder.length() < n) {
			if(listUpper.containsKey(builder.length())) {
				builder.append(listUpper.get(builder.length()));
			}
			else {
				builder.append(str.charAt(i));
				i++;
			}
		}

		return builder.toString();
	}

	// Main
	public static void main(String args[]) {
		stringPermutation("AB");
		System.out.println();

		stringPermutation("aBc");
		System.out.println();

		stringPermutation("aXbYcZ");
		System.out.println();
	}
}