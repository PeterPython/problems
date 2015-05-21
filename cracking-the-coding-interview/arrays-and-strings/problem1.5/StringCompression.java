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

	// public static String compression(String str) {
	// 	int size = countCompression(str);
	// 	if(size >= str.length()) {
	// 		return str;
	// 	}

	// 	StringBuilder mystr = new StringBuilder();
	// 	char last = str.charAt(0);
	// 	int count = 1;

	// 	for(int i=1; i<str.length(); i++) {
	// 		if(str.charAt(i) == last) {
	// 			count++;
	// 		}
	// 		else {
	// 			mystr.append(last);
	// 			mystr.append(count);
	// 			last = str.charAt(i);
	// 			count = 1;
	// 		}
	// 	}

	// 	mystr.append(last);
	// 	mystr.append(count);
	// 	return mystr.toString();
	// }

	// public static int countCompression(String str) {
	// 	if(str == null || str.isEmpty()) {
	// 		return 0;
	// 	}
	// 	char last = str.charAt(0);
	// 	int size = 0;
	// 	int count = 1;
	// 	for(int i=1; i<str.length(); i++) {
	// 		if(str.charAt(i) == last) {
	// 			count++;
	// 		}
	// 		else {
	// 			last = str.charAt(i);
	// 			size += 1 + String.valueOf(count).length();
	// 			count = 1;
	// 		}
	// 	}
	// 	size += 1 + String.valueOf(count).length();
	// 	return size;
	// }

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