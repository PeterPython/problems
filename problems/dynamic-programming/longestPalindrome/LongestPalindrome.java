// Given a string S, find the longest palindromic substring in S.
// http://articles.leetcode.com/2011/11/longest-palindromic-substring-part-i.html

public class LongestPalindrome {
	// Using Dynamic Programming. O(n^2) for time and space complexity
	public static int longestPalindromeDP(String str) {
		int n = str.length();

		// Memo[i][j] where i is the starting character, j is the last character
		boolean memo[][] = new boolean[n][n];
		int maxLength = 1;
		int start = 0;
		int end = 0;

		// One character is considered a palindrome
		for(int i=0; i<n; i++) {
			memo[i][i] = true;
		}

		// Checking if two consecutives characters are palindrome
		for(int i=0; i<n-1; i++) {
			if(str.charAt(i) == str.charAt(i+1)) {
				memo[i][i+1] = true;
				maxLength = 2;
				start = i;
				end = i+1;
			}
		}

		// If a palindrome is surrounded by two same characters then it is a palindrome
		for(int l=2; l<n; l++) {  // Length of substring
			for(int i=0; i<n-l; i++) {  // Check all substrings of length l
				if(memo[i+1][l-1+i] && str.charAt(i) == str.charAt(l+i)) {
					memo[i][l+i] = true;
					maxLength = l+1;
					start = i;
					end = l+i;
				}
			}
		}

		System.out.println(str.substring(start, end+1));
		return maxLength;
	}


	// O(n^2) with no extra memory space
	public static String longestPalindrome(String str) {
		String longest = "";
		for(int i=0; i<str.length()-1; i++) {
			String s1 = expandAroundCenter(str, i, i);  // Expand around a character
			if(s1.length() > longest.length()) {
				longest = s1;
			}

			String s2 = expandAroundCenter(str, i, i+1);  // Expand between two characters
			if(s2.length() > longest.length()) {
				longest = s2;
			}
		}

		return longest;
	}

	// Helper method to expand around one chaacter to find longest palindrome
	public static String expandAroundCenter(String str, int l, int r) {
		while(l >= 0 && r < str.length() && str.charAt(l) == str.charAt(r)) {
			l--;
			r++;
		}

		return str.substring(l+1, r);
	}


	public static void main(String args[]) {
		System.out.println(longestPalindromeDP("ababa"));
		System.out.println(longestPalindromeDP("ab"));

		System.out.println();
		System.out.println(longestPalindrome("ababa"));
		System.out.println(longestPalindrome("ab"));
	}
}