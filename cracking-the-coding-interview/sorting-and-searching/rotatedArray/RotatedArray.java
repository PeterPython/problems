// Problem 11.3: Given a sorted array of n integers that has been 
// rotated an unknown number of times, write code to find an element 
// in the array. Youmay assume that the array was originally sorted 
// in increasing order.
// Page 121. Solution 362

public class RotatedArray {
	public static int searchInRotatedArray(int a[], int target, int left, int right) {
		int mid = left+(right-left)/2;

		if(a[mid] == target) {
			return mid;
		}

		if(a[mid] > a[left]) {
			if(target < a[mid] && target >= a[left]) {
				return searchInRotatedArray(a, target, left, mid-1);
			}
			else {
				return searchInRotatedArray(a, target, mid+1, right);
			}
		}
		else if(a[mid] < a[left]) {
			if(target > a[mid] && target <= a[right]) {
				return searchInRotatedArray(a, target, mid+1, right);
			}
			else {
				return searchInRotatedArray(a, target, left, mid-1);
			}
		}
		else if(a[mid] == a[left]) {
			if(a[mid] != a[right]) {
				return searchInRotatedArray(a, target, mid+1, right);
			}
			else {
				int result = searchInRotatedArray(a, target, mid+1, right);
				if(result == -1) {
					return searchInRotatedArray(a, target, left, mid-1);
				}
				else {
					return result;
				}
			}
		}

		return -1;
	}

	public static int searchInRotatedArray(int a[], int target) {
		return searchInRotatedArray(a, target, 0, a.length-1);
	}

	public static void main(String args[]) {
		int a[] = {10, 15, 20, 0, 5};

		System.out.println(searchInRotatedArray(a, 15));
	}
}