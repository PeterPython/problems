// Program that counts how many pairs in an array sum to K

import java.util.*;

public class SumToK {
	public static int sumToK(int a[], int k) {
		HashMap<Integer, Boolean> map = new HashMap<Integer, Boolean>();
		int n = a.length;
		int count = 0;

		// Putting array into hashtable
		for(int i=0; i<n; i++) {
			map.put(a[i], true);
		}

		for(int i=0; i<n; i++) {
			int dif = k - a[i];
			if(map.containsKey(dif) && map.get(a[i]) && a[i] != dif) {
				count++;
			}
			map.put(dif, false);  // Set to false meaning that this has already been checked
		}

		return count;
	}

	public static void main(String args[]) {
		int a[] = {1,2,3,4,5};
		System.out.println(sumToK(a, 6));
	}
}