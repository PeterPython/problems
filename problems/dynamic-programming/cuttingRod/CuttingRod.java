// Dynamic Programming Problem
// Cutting a rod. Given a rod of length k and for each length (index of array)
// there is a price (value). 
// Calculate the maximum profit. O(n^2) with DP
// https://www.youtube.com/watch?v=U-09Gs6cbsQ

public class CuttingRod {
	public static int cuttingRod(int a[], int length) {
		int memo[] = new int[a.length];
		return cuttingRod(a, length, memo);
	}

	public static int cuttingRod(int a[], int length, int memo[]) {
		int max = 0;
		if(length == 0) {
			return 0;
		}
		if(length == 1) {
			return a[1];
		}
		if(memo[length] != 0) {
			return memo[length];
		}
		for(int i=1; i<=length; i++) {
			int result = a[i] + cuttingRod(a, length-i, memo);
			if(result > max) {
				max = result;
			}
		}

		memo[length] = max;
		return max;
	}


	// Main
	public static void main(String args[]) {
		int a[] = {0,1,5,8,9,10,17,17,20};
		System.out.println(cuttingRod(a, 2));
		System.out.println(cuttingRod(a, 3));
		System.out.println(cuttingRod(a, 4));
		System.out.println(cuttingRod(a, 8));
	}
}