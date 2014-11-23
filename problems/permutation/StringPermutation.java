// Get all the permutations of a string
// http://stackoverflow.com/questions/4240080/generating-all-permutations-of-a-given-string

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

	// Main
	public static void main(String args[]) {
		String str = "abc";

		System.out.println("Original String: " + str + "\n");

		System.out.println("Permutations: ");
		getPermutations(str);
	}
}