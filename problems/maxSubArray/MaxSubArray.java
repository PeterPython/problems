// Given an array of integers (positive/zero/negative) write a function that 
// calculates the maximum positive sum of any continuous subarray of the input array

class MaxSubArray {
	public static int getMaxSum(int a[]) {
		int max = Integer.MIN_VALUE;
		int currentSum = 0;

		for(int i=0; i<a.length; i++) {
			currentSum += a[i];

			if(currentSum > max) {
				max = currentSum;
			}
			if(currentSum <= 0) {
				currentSum = 0;
			}
		}
		return max;
	}


	public static int[] getMaxSubArray(int a[]) {
		int max = Integer.MIN_VALUE;
		int currentSum = 0;
		int currentStart = 0;
		int maxStart = 0;
		int maxEnd = 0;
		int n = a.length;

		for(int i=0; i<n; i++) {
			currentSum += a[i];

			if(currentSum > max) {
				max = currentSum;
				maxStart = currentStart;
				maxEnd = i;
			}
			if(currentSum <= 0) {
				currentSum = 0;
				currentStart = i+1;
			}
		}

		// Until here

		System.out.println("Start: " + maxStart + ", End: " + maxEnd);
		String str = "";

		int maxSubArray[] = new int[maxEnd - maxStart + 1];
		int index = 0;
		for(int i=maxStart; i<=maxEnd; i++) {
			maxSubArray[index] = a[i];
			index++;
			str += " " + a[i];
		}
		System.out.println(str);
		return maxSubArray;
	}


	// Main
	public static void main(String args[]) {
		int a[] = {1,2,3,4};  // 10
		System.out.println(getMaxSum(a));
		getMaxSubArray(a);
		System.out.println();

		int a1[] = {2,3,-1,-3};  // 5
		System.out.println(getMaxSum(a1));
		getMaxSubArray(a1);
		System.out.println();

		int a2[] = {-1,5,100,-1000};  // 105
		System.out.println(getMaxSum(a2));
		getMaxSubArray(a2);
		System.out.println();

		int a3[] = {-5,-1,-2,-3,-4};  // -1
		System.out.println(getMaxSum(a3));
		getMaxSubArray(a3);
		System.out.println();

		int a4[] = {1000,20000,-1,300000};  // 320999
		System.out.println(getMaxSum(a4));
		getMaxSubArray(a4);
		System.out.println();

		int a5[] = {-1,3,-5,4,6,-1,2,-7,13,-3}; 
		System.out.println(getMaxSum(a5));
		getMaxSubArray(a5);
		System.out.println();

		int a6[] = {0}; 
		System.out.println(getMaxSum(a6));
		getMaxSubArray(a6);
		System.out.println();
	}
}