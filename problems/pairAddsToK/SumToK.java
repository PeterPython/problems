// Program that counts how many pairs in an array sum to K

import java.util.*;

public class SumToK {
	// Assuming not duplicates
	public static int sumToK(int a[], int k) {
		HashMap<Integer, Boolean> map = new HashMap<Integer, Boolean>();
		int count = 0;

		int n = a.length;
		// Putting array into hashtable
		for(int i=0; i<n; i++) {
			map.put(a[i], true);
		}

		for(int i=0; i<n; i++) {
			int dif = k - a[i];

			// Check if contains dif, AND a[i] is not already checked, AND a[i] and dif are different
			if(map.containsKey(dif) && map.get(a[i]) && a[i] != dif) {
				count++;
			}
			map.put(dif, false);  // Set to false meaning that this has already been checked
		}

		return count;
	}

	// With Duplicates
	public static int countPairs(int a[], int k) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		int count = 0;

		int n = a.length;

		for(int i=0; i<n; i++) {
			if(!map.containsKey(a[i])) {
				map.put(a[i], 1);
			}
			else {
				map.put(a[i], map.get(a[i]) + 1);
			}
		}

		for(int i=0; i<n; i++) {
			int dif = k - a[i];

			if(map.containsKey(dif) && map.get(a[i]) > 0) {
				map.put(dif, map.get(dif) - 1);
				count++;
			}
		}

		return count;
	}


	public static void main(String args[]) {
		int a[] = {1,2,3,4,5};
		System.out.println(sumToK(a, 6));
		System.out.println(countPairs(a, 6));

		int b[] = {2,2,3,3};
		System.out.println(countPairs(b, 5));
	}
}