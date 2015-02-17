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

	public static void main(String args[]) {
		System.out.println(minCoins(15));
	}
}