// Problem 1.5
// Implement a method to perform basic string compression using the counts of repeated characters. 
// For example, the string aabcccccaaa would become a2blc5a3. If the "compressed" string would not 
// become smaller than the original string, your method should return the original string.
// Page 176

class StringCompression {

	// This is not very efficient because string concatenation takes O(n^2)
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

 // More efficient
	public static String compression2(String str) {
		char charArray[] = new char[str.length()+1];
		char charCount[];

		int k = 0;
		int c = 1;

		for(int i=0; i<str.length(); i++) {
			if(i == str.length()-1) {
				charArray[k++] = str.charAt(i);
				charCount = String.valueOf(c).toCharArray();

				for(char x : charCount) {
					if(k >= str.length()) {
						return str;
					}
					charArray[k++] = x;
				}
				break;
			}
			else if(str.charAt(i) == str.charAt(i+1)) {
				c++;
			}
			else {
				charArray[k++] = str.charAt(i);
				charCount = String.valueOf(c).toCharArray();
				c = 1;

				for(char x : charCount) {
					if(k >= str.length()) {
						return str;
					}
					charArray[k++] = x;
				}
			}
		}
		return String.valueOf(charArray);
	}

	// Main
	public static void main(String args[]) {
		String str = "aabcccccaaa";
		System.out.println(str);
		System.out.println(compression2(str));
		System.out.println();

		str = "abc";
		System.out.println(str);
		System.out.println(compression2(str));
		System.out.println();

		str = "abccccd";
		System.out.println(str);
		System.out.println(compression2(str));
		System.out.println();

		str = "abcc";
		System.out.println(str);
		System.out.println(compression2(str));
		System.out.println();

		str = "aaaaaaaaaaaaaaaaaaaaabcc";
		System.out.println(str);
		System.out.println(compression2(str));
		System.out.println();
	}
}