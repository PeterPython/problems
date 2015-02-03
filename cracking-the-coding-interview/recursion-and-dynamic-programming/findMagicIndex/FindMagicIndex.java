// Problem 9.3: A magic index in an array A[l...n-l] is defined 
// to be an index such that A[i] = i. Given a sorted array of 
// distinct integers, write a method to find a magic index, 
// if one exists, in array A. 
// Follow up: What if the values are not distinct?
// Page 109. Solution 319

public class FindMagicIndex {
	public static int findMagicIndex(int a[]) {
		return findMagicIndex(a, 0, a.length);
	}

	public static int findMagicIndex(int a[], int start, int end) {
		if(end < start || end < 0 || start >= a.length) {
			return -1;
		}

		int mid = start + (end-start)/2;

		if(a[mid] == mid) {
			return mid;
		}

		if(a[mid] > mid) {
			return findMagicIndex(a, start, mid-1);
		}
		else {
			return findMagicIndex(a, mid+1, end);
		}
	}


	public static void main(String args[]) {
		int a[] = {-40, -20, -1, 1, 2, 3, 5, 7, 9, 12, 14};

		System.out.println(findMagicIndex(a));  // 7
	}
}