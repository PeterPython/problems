// Problem 5.1: How would you go about computing the parity of a very large number of 64-bit nonnegative integers. Page 173
// The parity of a sequence of bits is 1 if the number of 1s in the sequence is odd; 
// otherwise, it is O. Parity checks are used to detect single bit errors in data storage and communication.
// Example: 11101 => 111010. 11001 => 110011

public class Parity {

	// Get even parity
	public static short getEvenParity(long x) {
		short result = 0;
		while(x != 0) {
			result ^= (x & 1);
			x >>>= 1;
		}
		return result;
	}

	public static void main(String args[]) {
		long x = 81; // 1010001;
		System.out.println(getEvenParity(x));

		int y = 105; // 1101001;
		System.out.println(getEvenParity(y));
	}
}