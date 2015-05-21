// Given a string, check if any anagram of it can be a palindrome

import java.util.HashMap;

public class CanBePalindrome {
	public static boolean canBePalindrome(String str) {
		HashMap<Character, Integer> charCount = new HashMap<Character, Integer>();
		// Adding characters and their count into map
		for(int i=0; i<str.length(); i++) {
			char c = str.charAt(i);
			if(!charCount.containsKey(c)) {
				charCount.put(c, 1);
			}
			else {
				int count = charCount.get(c) + 1;
				charCount.put(c, count);
			}
		}

		boolean oddOccur = false;
		for(Character c : charCount.keySet()) {
			int count = charCount.get(c);
			if(count%2 != 0) {
				if(oddOccur) {
					return false;
				}
				else {  // If there is odd count that occurs more than once
					oddOccur = true;
				}
			}
		}

		return true;
	}


	public static void main(String args[]) {
		System.out.println(canBePalindrome("aab"));
		System.out.println(canBePalindrome("aaa"));
		System.out.println(canBePalindrome("racecar"));
		System.out.println(canBePalindrome("a"));
		System.out.println(canBePalindrome("abc"));
		System.out.println(canBePalindrome("aaacbbb"));
	}
}