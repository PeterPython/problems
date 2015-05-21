/*
Problem 1.4: Write a method to replace all spaces in a string with'%20'. 
You may assume that the string has sufficient space at the end of the string to hold the 
additional characters, and that you are given the "true" length of the string. 
(Note: if implementing in Java, please use a character array so that you can perform this operation in place.)
EXAMPLE
Input: "Mr John Smith " 
Output: "Mr%20Dohn%20Smith"
Page 175
*/

class ReplaceSpace {
	public static String replaceString1(String str) {
		return str.replaceAll("\\s", "%20");
	}

	public static String replaceString2(String str) {
		String replaced = "";

		for(int i=0; i<str.length(); i++) {
			if(str.charAt(i) != ' ') {
				replaced += str.charAt(i);
			} else {
				replaced += "%20";
			}
		}
		return replaced;
	}

	public static String replaceString3(String str) {
		char a[] = new char[str.length()];

		for(int i=0, k=0; k<str.length(); i++, k++) {
			if(str.charAt(i) != ' ') {
				a[k] = str.charAt(i);
			} else {
				a[k++] = '%';
				a[k++] = '2';
				a[k] = '0';
			}
		}

		String replaced = new String(a);

		return replaced;
	}

	public static void main(String args[]) {
		String str = "Mr John Smith       ";
		System.out.println(str);
		System.out.println(replaceString1(str));
		System.out.println(replaceString2(str));
		System.out.println(replaceString3(str));
		System.out.println();
	}
}