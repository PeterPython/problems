// Print all the well ordered numbers of length n
// A well ordered numbered is a number that 
// increases the digits from left to right. e.g: 258. 2>5>8

public class WellOrdered {
	public static void wellOrdered(int n) {
		wellOrdered("", n, 0);
	}

	public static void wellOrdered(String str, int n, int start) {
		if(str.length() == n) {
			System.out.println(str);
			return;
		}

		// When you start at a number that does not have enough 
		// incresing numbers to fill the string
		if(10-start < n-str.length()) {
			return;
		}

		for(int i=start; i<=9; i++) {
			wellOrdered(str + String.valueOf(i), n, i+1);
		}
	}

	// Main
	public static void main(String args[]) {
		wellOrdered(2);
		System.out.println();
		wellOrdered(3);
	}
}