/*
Problem 5.1:
You are given two 32-bit numbers, N and M, and two bit positions, i and j. 
Write a method to insert M into N such that M starts at bit j and ends at bit i. 
You can assume that the bits j through i have enough space to fit all of M. 
That is, if M = 10011, you can assume that there are at least 5 bits between j and i. 
You would not,for example, have j = 3 and i = 2, because M could not fully fit between bit 3 and bit 2.
Example:
Input: N=10000000000, M=10011, i=2, j=6 
Output: N = 10001001100
Page 91. Solution 242
*/

public class BitsInsertion {
	public static int bitsInsertion(int n, int m, int i, int j) {
		int mask = ~0;  // Sequence of all 1s
		int clearRight = mask << (j+1);  // 1s before position j, then 0s. left = 11100000
		int clearLeft = (1<<i)-1;  // 1s after position i. right = 00000011
		mask = clearLeft | clearRight;  // OR. mask = 11100011
		n &= mask; // Clear bits of n from i to j
		m <<= i;  // Shift m
		n |= m;  // Merge n and m

		return n;
	}

	public static void main(String args[]) {
		int n = 1024;  // 10000000000
		int m = 19; // 10011

		System.out.print(bitsInsertion(n, m, 2, 6));
		System.out.println();  // 10001001100
	}
}