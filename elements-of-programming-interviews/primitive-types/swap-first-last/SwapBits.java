/*
Problem 5.2: A 64-bit integer can be viewed as an array of 64 bits, 
with the bit at index 0 corresponding to the least significant bit,
and the bit at index 63 corresponding to the most significant bit. 
Implement codethat tnJces as input a 64-bit integerx 
and swaps the bits at indices i and j.
Page 174
*/

public class SwapBits {
	public static long swapBits(long x, int i, int j) {
		if(((x >> i) & 1) != ((x >> j) & 1)) {  // Check if both bits are the same
			x ^= (1L<<i) | (1L<<j);   // OR 0000000001 to the bit position then XOR to x
		}
		return x;
	}

	public static void main(String args[]) {
		long x = 2;
		System.out.println(swapBits(x, 0, 1));
	}
}