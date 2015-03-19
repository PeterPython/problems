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


	// Another Solution
	public static int longestIncreasing(int a[]) {
		int[] memo = new int[a.length];
		int totalMax = 0;

		for(int i=0; i<a.length; i++) {
			memo[i] = 1;  // Initialize all memo to 1
		}

		for(int i=a.length-1; i>=0; i--) {
			int maxCount = 0;
			for(int j=i; j<a.length; j++) {
				if(a[i] < a[j] && memo[j] > maxCount) {
					maxCount = memo[j];
				}
			}
			memo[i] += maxCount;

			// Get maximum
			if(memo[i] > totalMax) {
				totalMax = memo[i];
			}
		}

		return totalMax;
	}

	// Main
	public static void main(String args[]) {
		int a[] = {4,5,1,2,3,6,7};  // 5
		int b[] = {2,3,8,4,5,10,6,7};  // 6
		int c[] = {4,5,1,5,3,4};   // 3
		int d[] = {1};  // 1
		int e[] = {2,1};  // 1

		System.out.println(longestIncreasingSubsequence(a));
		System.out.println(longestIncreasingSubsequence(b));
		System.out.println(longestIncreasingSubsequence(c));

		System.out.println(longestIncreasing(a));
		System.out.println(longestIncreasing(b));
		System.out.println(longestIncreasing(c));
		System.out.println(longestIncreasing(d));
		System.out.println(longestIncreasing(e));

	}
}