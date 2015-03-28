// Count the number of 1 bits in an integer

public class CountOneBits {
	public static int countOneBits(int n) {
		int count = 0;
		while(n != 0) {
			int c = n & 1;
			if(c == 1) {
				count++;
			}

			// The unsigned right shift operator ">>>" 
			// shifts a zero into the leftmost position, 
			// while the leftmost position after ">>" depends on sign extension.
			// 001100 >> 1 = 000110
			// 100100 >>> 1 = 110010
			n = n >>> 1;
		}
		return count;
	}

	// Another method but less efficient
	public static int countOneBits2(int n) {
		int count = 0;

		for(int i=0; i<32; i++) {
			int c = (n >>> i) & 1;  // Shift i to the right then mask
			if(c == 1) {
				count++;
			}
		}
		return count;
	}

	public static void main(String args[]) {
		System.out.println(countOneBits(5)); // 101
		System.out.println(countOneBits(1));  // 1
		System.out.println(countOneBits(-5)); // 011
		System.out.println(countOneBits(-1)); // 111

		System.out.println();
		System.out.println(countOneBits2(5)); // 101
		System.out.println(countOneBits2(1));  // 1
		System.out.println(countOneBits2(-5)); // 011
		System.out.println(countOneBits2(-1)); // 111
	}
}