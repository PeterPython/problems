class Palindrome {
	public static void main(String args[]) {
		System.out.println(isPalindrome("Hola"));   // False
		System.out.println(isPalindrome("Race car"));    // True
		System.out.println(isPalindrome("A car, a man, a maraca"));    // True
		System.out.println(noSpace("A car, a man, a maraca"));   
	}

	public static boolean isPalindrome(String word) {
		word = word.toLowerCase().replaceAll("[\\s\\W]", "");   // Changes to lower case and removes spaces using Regular expressions
		for(int i=0; i<(word.length()/2); i++) {
			if(word.charAt(i) != word.charAt(word.length()-1-i)) {
				return false;
			} 
		}
		return true;
	}

	// Testing ReGex
	public static String noSpace(String str) {
		str = str.replaceAll("[\\s\\W]", "");   // You hava to use \\ to escape a single backslash
		return str;
	}

}