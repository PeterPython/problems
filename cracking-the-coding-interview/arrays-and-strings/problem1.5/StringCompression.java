// Problem 1.5
// Implement a method to perform basic string compression using the counts of repeated characters. 
// For example, the string aabcccccaaa would become a2blc5a3. If the "compressed" string would not 
// become smaller than the original string, your method should return the original string.
// Page 176

class StringCompression {
	public static String compression(String str) {
		int c = 1;
		String s = "";

		for(int i=0; i<str.length(); i++) {
			if(i == str.length()-1) {
				s += str.charAt(i) + "" + c;
				break;
			}
			else if(str.charAt(i) == str.charAt(i+1)) {
				c++;
			}
			else {
				s += str.charAt(i);
				s += c;
				c = 1;
			}
		}

		if(s.length() < str.length()) {
			return s;
		} else {
			return str;
		}
	}


	// Main
	public static void main(String args[]) {
		String str = "aabcccccaaa";
		System.out.println(str);
		System.out.println(compression(str));
		System.out.println();

		str = "abc";
		System.out.println(str);
		System.out.println(compression(str));
		System.out.println();

		str = "abccccd";
		System.out.println(str);
		System.out.println(compression(str));
		System.out.println();

		str = "abcc";
		System.out.println(str);
		System.out.println(compression(str));
		System.out.println();

		str = "aaaaaaaaaaaaaaaaaaaaabcc";
		System.out.println(str);
		System.out.println(compression(str));
		System.out.println();
	}
}