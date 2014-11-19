// Given an array of integers (positive/zero/negative) write a function that 
// calculates the maximum positive sum of any continuous subarray of the input array

class MaxSubArray {
	public static int getMaxSum(int a[]) {
		int k = 0;
		int max = 0;

		for(int i=0; i<a.length; i++) {
			if(k+a[i] <= 0) {
				k = 0;
			} else {
				k+=a[i];
				if(k>max) {
					max = k;
				}
			}
		}
		return max;
	}

	// Main
	public static void main(String args[]) {
		int a[] = {1,2,3,4};
		System.out.print(getMaxSum(a));
		System.out.println();

		int a1[] = {2,3,-1,-3};
		System.out.print(getMaxSum(a1));
		System.out.println();

		int a2[] = {-1,5,100,-1000};
		System.out.print(getMaxSum(a2));
		System.out.println();

		int a3[] = {-1,-2,-3,-4};
		System.out.print(getMaxSum(a3));
		System.out.println();

		int a4[] = {1000,20000,-1,300000};
		System.out.print(getMaxSum(a4));
		System.out.println();
	}
}