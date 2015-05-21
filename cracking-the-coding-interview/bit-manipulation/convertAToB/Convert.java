// Problem 5.5: Write a function to determine the number 
// of bits required to convert integer A to integer B.
// Page 92. Solution 250

public class Convert {
	public static int convert(int a, int b) {
		int count = 0;
		// Use XOR to check if the two bit are the same
		// c = c&(c-1) will clear the least significant bit in c.
		for(int c=a^b; c!=0; c=c&(c-1)) {
			count++;
		}

		// Easier to read solution
		// while(a != 0) {
		// 	int indexA = a & 1;
		// 	int indexB = b & 1;
		// 	if(indexA != indexB) {
		// 		count ++;
		// 	}

		// 	a = a >> 1;
		// 	b = b >> 1;
		// }
		return count;
	}

	public static void main(String args[]) {
		System.out.println(convert(5, 1));  // 101, 001
		System.out.println(convert(5, 2));  // 101, 010 
	}
}