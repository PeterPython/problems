// Find the length of the longest increasing subsequence of an array
// The subsequence does not have to be consecutive
// O(n^2)

public class LongestIncreasingSubsequence {
	public static int longestIncreasingSubsequence(int a[]) {
		int maxCount = 1;
		int count = 1;
		int prev = 0;

		// This is so we can skip the ones that we already analized in a previos loop
		boolean skip[] = new boolean[a.length];

		for(int i=0; i<a.length; i++) {
			prev = a[i];
			if(!skip[0]) {
				for(int j=i; j<a.length; j++) {
					if(a[j] > prev) {
						count++;
						prev = a[j];
						skip[j] = true;
						if(count > maxCount) {
							maxCount = count;
						}
					}
				}		
			}
			count = 1;  // Reset
		}

		return maxCount;
	}


	// Main
	public static void main(String args[]) {
		int a[] = {4,5,1,2,3,6,7};
		System.out.println(longestIncreasingSubsequence(a));
	}
}