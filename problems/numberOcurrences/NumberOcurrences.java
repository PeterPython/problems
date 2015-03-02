// Given a sorted array arr[] and a number x, write a function 
// that counts the occurrences of x in arr[].
// Expected time complexity is O(Logn)
// http://www.geeksforgeeks.org/count-number-of-occurrences-in-a-sorted-array/

public class NumberOcurrences {
	public static int numberOcurrences(int a[], int k) {
		int first = firstIndex(a, k, 0, a.length-1);
		int last = lastIndex(a, k, 0, a.length-1);

		return last-first+1;
	}

	// Finds the first index of k
	public static int firstIndex(int a[], int k, int lo, int hi) {
		int mid = lo+(hi-lo)/2;

		while(hi >= lo) {
			if((mid==0 || k>a[mid-1]) && k==a[mid]) {
				return mid;
			}
			else if(k > a[mid]) {
				return firstIndex(a, k, mid+1, hi);
			}
			else {  // k <= a[mid]
				return firstIndex(a, k, lo, mid-1);
			}
		}
		return -1;
	}

	// Finds the last index of k
	public static int lastIndex(int a[], int k, int lo, int hi) {
		int mid = lo+(hi-lo)/2;

		while(hi >= lo) {
			if((mid == a.length-1 || k<a[mid+1]) && k==a[mid]) {
				return mid;
			}
			else if(k < a[mid]) {
				return lastIndex(a, k, lo, mid-1);
			}
			else {  // k >= a[mid]
				return lastIndex(a, k, mid+1, hi);
			}
		}
		return -1;
	}


	// Main
	public static void main(String args[]) {
		int a[] = {1,2,3,4,4,4,4,5,6,7,7,7,8};
		System.out.println(numberOcurrences(a, 4));
		System.out.println(numberOcurrences(a, 7));
	}
}