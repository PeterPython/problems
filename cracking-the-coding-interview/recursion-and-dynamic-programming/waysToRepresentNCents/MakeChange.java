// Problem 9.6: Given an infinite number of quarters (25 cents), 
// dimes (10 cents), nickels (5 cents) and pennies (1 cent), 
// write code to calculate the number of ways of representing n cents.
// Page 110. Solution 328

public class MakeChange {
	public static int makeChange(int n) {
		return makeChange(n, 25);
	}

	public static int makeChange(int n, int denom) {
		int nextDenom = 0;

		if(denom == 25) {
			nextDenom = 10;
		}
		else if(denom == 10) {
			nextDenom = 5;
		}
		else if(denom == 5) {
			nextDenom = 1;
		}
		else if(denom == 1) {
			return 1;
		}

		int ways = 0;
		for(int i=0; i*denom<=n; i++) {
			ways += makeChange(n-i*denom, nextDenom);
		}

		return ways;
	}


	public static void main(String args[]) {
		System.out.println(makeChange(100));
		System.out.println(makeChange(5));
	}
}