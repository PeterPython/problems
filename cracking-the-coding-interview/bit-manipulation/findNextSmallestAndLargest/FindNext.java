// Problem 5.3: Given a positive integer, print the next smallest
// and the next largest number that have the same number of 1 bits 
// in their binary representation.
// Page 92. Solution 244

// This solution is wrong
public class FindNext {
	public static int findNextSmallest(int i) {
		int index;
		int next;
		int p1 = 0;
		int p2 = 0;
		for(int j=0; j<32; j++) {
			index = i & (1<<j);
			if(index == 0) {
				p1 = j;
				next = i & (1<<(j+1));

				if(next == 1) {
					p2 = j+1;
					break;
				}
			}
		}

		int mask1 = 1 << p1;
		i |= mask1;

		int mask2 = ~(1 << p2);
		i &= mask2;

		return i; 
	}


	public static void main(String args[]) {
		System.out.println(findNextSmallest(5));  // 101 -> 011
	}
}