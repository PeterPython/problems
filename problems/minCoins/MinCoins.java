// Given coins with values 1, 3, and 5.
// Write a program to compute the minimum number of coins that adds to k.

public class MinCoins {
	public static int minCoins(int k) {
		if(k<=0) {
			return 0;
		}
		else if(k<3) {
			return minCoins(k-1) + 1;
		}
		else if(k<5) {
			return minCoins(k-3) + 1;
		}
		else {
			return minCoins(k-5) + 1;
		}
	}


	public static int minCoinsDP(int a[], int k) {
		int memo[] = new int[k+1];
		return minCoinsDP(a, k, memo);
	} 

	public static int minCoinsDP(int a[], int k, int memo[]) {
		if(k == 0) {
			return 0;
		}
		else if(k < 0) {
			return -1;
		}
		else if(memo[k] != 0) {
			return memo[k];
		}

		int min = Integer.MAX_VALUE;

		for(int i=0; i<a.length; i++) {
			int number = minCoinsDP(a, k-a[i], memo) + 1;

			if(number < min && number > 0) {
				min = number;
			}
		}

		memo[k] = min;
		return min;
	}

	public static void main(String args[]) {
		System.out.println(minCoins(15));

		System.out.println("Using Dynamic Programming:");
		int a[] = {1,3,5};  // Different coin denomination
		System.out.println(minCoinsDP(a, 2));
		System.out.println(minCoinsDP(a, 3));
		System.out.println(minCoinsDP(a, 15));
	}
}