// Given a string S, find the longest palindromic substring in S.
// http://articles.leetcode.com/2011/11/longest-palindromic-substring-part-i.html

public class LongestPalindrome {
	public static int longestPalindrome(String str) {
		int n = str.length();
		boolean memo[][] = new boolean[n][n];
		int maxLength = 1;

		for(int i=0; i<n; i++) {
			memo[i][i] = true;
		}

		for(int i=0; i<n-1; i++) {
			if(str.charAt(i) == str.charAt(i+1)) {
				memo[i][i+1] = true;
				maxLength = 2;
			}
		}

		for(int l=2; l<n; l++) {
			for(int i=0; i<n-l; i++) {
				if(memo[i+1][l-1+i] && str.charAt(i) == str.charAt(l+i)) {
					memo[i][l+i] = true;
					maxLength = l+1;
				}
			}
		}

		return maxLength;
	}


	public static void main(String args[]) {
		System.out.println(longestPalindrome("ababa"));
		System.out.println(longestPalindrome("ab"));
	}
}