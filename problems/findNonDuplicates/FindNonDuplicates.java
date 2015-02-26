// Given an array that contains elements with exactly one duplicate 
// for each element, except for two elements return which elements
// do not have duplicates.
// Example 2,3,2,4,5,6,5,4. Answer 3, 6

public class FindNonDuplicates {
	public static void findNonDuplicates(int a[]) {
		int xor = 0;
		for(int i=0; i<a.length; i++) {
			xor ^= a[i];  // This will remove all the duplicates and leave the XOR of the two elements
		}

		// This XOR means that the bits that are 1, they are different for both numbers
		// Least significant bit that is set (1) in XOR result
		// We need the LSB to filter out one of the no duplicates
		int lsb = xor & -xor;  // Clears all but the lowest bit of xor
		int x = 0;
		int y = 0;

		for(int i=0; i<a.length; i++) {
		// This will filter out one of the elements because one will be 0 and the other one non 0
			if((lsb & a[i]) != 0) {
				x ^= a[i];
			}
		}

		y = xor ^ x;

		System.out.println(x + " " + y);
	}


	// Main
	public static void main(String args[]) {
		int a[] = {2,3,2,4,5,6,5,4};
		findNonDuplicates(a);
	}
}