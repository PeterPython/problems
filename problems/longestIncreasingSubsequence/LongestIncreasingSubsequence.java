// Find the length of the longest increasing subsequence of an array
// The subsequence does not have to be consecutive
// O(n^2)

public class LongestIncreasingSubsequence {
	public static int longestIncreasingSubsequence(int a[]) {
		int max = 0;
		int memo[] = new int[a.length];

		for(int i=0; i<a.length; i++) {
			memo[i] = 1;
		}

		for(int i=a.length-1; i>=0; i--) {
			int temp = memo[i];
			int maxTemp = temp;
			for(int j=i+1; j<a.length; j++) {
				if(a[i] < a[j] && temp < memo[i]+memo[j]) {
					temp = memo[i] + memo[j];
				}
				if(temp > maxTemp) {
					maxTemp = temp;
				}
				if(temp > max) {
					max = temp;
				}
			}
			memo[i] = maxTemp;
		}

		return max;
	}


	// Main
	public static void main(String args[]) {
		int a[] = {4,5,1,2,3,6,7};  // 5
		System.out.println(longestIncreasingSubsequence(a));

		int b[] = {2,3,8,4,5,10,6,7};  // 6
		System.out.println(longestIncreasingSubsequence(b));
	}
}