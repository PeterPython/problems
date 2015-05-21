// Problem 11.1: You are given two sorted arrays, A and B, where A has a 
// large enough buffer at the end to hold B. Write a method to merge B 
// into A in sorted order.
// Page 121. Solution 360 (Check solution)

public class MergeArrays {
	public static void mergeArrays(int a[], int b[]) {
		int temp;
		int n = a.length - b.length;
		for(int i=0; i<n; i++) {
			if(a[i] > b[0]) {
				temp = a[i];
				a[i] = b[0];
				b[0] = temp;

				int j = 0;
				// Put the element in the right position in b
				while(j<b.length-1 && b[j] > b[j+1]) {
					temp = b[j];
					b[j] = b[j+1];
					b[j+1] = temp;
					j++;
				}
			}
		}

		// Add the rest from array b
		for(int i=n; i<a.length; i++) {
			a[i] = b[i-n];

		}
	}

	// Main
	public static void main(String args[]) {
		int a[] = new int[10];
		a[0] = 1;
		a[1] = 3;
		a[2] = 6;
		a[3] = 12;
		a[4] = 15;

		int b[] = {2,4,5,11,13};

		mergeArrays(a, b);

		for(int i=0; i<a.length; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
	}
}