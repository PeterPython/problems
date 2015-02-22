// Find kth greatest element in an array using Quick Select
// Page 345 (Algorithms by Robert Sedgewick)

public class FindKthGreatest {
	public static int findKthGreatest(int a[], int k) {
		int lo = 0;
		int hi = a.length-1;
		int pivot;
		int target = a.length - k;  // Target is from the end to first because we are looking for max

		while(hi > lo) {
			pivot = partition(a, lo, hi);

			if(pivot == target) {
				return a[target];
			}
			else if(pivot > target) {
				hi = pivot-1;
			}
			else {
				lo = pivot+1;
			}
		}
		return a[target];
	}

	// Partition similar from QuickSort
	public static int partition(int a[], int lo, int hi) {
		int l = lo;
		int h = hi;
		int temp;
		int pivot = a[lo + (hi-lo)/2];

		while(h>=l) {
			while(a[l] < pivot && l<hi) {
				l++;
			}
			while(a[h] > pivot && h>lo) {
				h--;
			}

			if(h>=l) {
				temp = a[l];
				a[l] = a[h];
				a[h] = temp;

				l++; h--;
			}
		}

		// It actually does not matter if you return l or h;
		// But we have to make sure that they are in the range between lo-hi
		// We cannot return pivot because we don't know its index and it might have moved
		if(l<=hi) {
			return l;
		}
		else {
			return h;
		}
	}


	// Main
	public static void main(String args[]) {
		int a[] = {5,3,2,6,1,4};
		System.out.println(findKthGreatest(a, 1));
		System.out.println(findKthGreatest(a, 2));
		System.out.println(findKthGreatest(a, 3));
		System.out.println(findKthGreatest(a, 4));
		System.out.println(findKthGreatest(a, 5));
		System.out.println(findKthGreatest(a, 6));
	}
}