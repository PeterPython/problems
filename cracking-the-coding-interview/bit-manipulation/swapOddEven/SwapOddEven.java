// Problem 5.6: Write a program to swap odd and even bits in an integer
// with as few instructions as possible (e.g., bit 0 and 
// bit 1 are swapped, bit 2 and bit 3 are swapped, and soon).
// Page 92. Solution 251

public class SwapOddEven {
	public static int swapOddEven(int i) {
		return ((i & 0xaaaaaaaa) >> 1) | ((i & 0x55555555) << 1);
	}


	// Main
	public static void main(String args[]) {
		System.out.println(swapOddEven(5));  // 101 -> 1010 (10)
		System.out.println(swapOddEven(10));
		System.out.println(swapOddEven(7));  // 0111 -> 1011 (11)	
	}
}