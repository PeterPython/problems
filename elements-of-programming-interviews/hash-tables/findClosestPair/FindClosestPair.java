// Problem 12.3:  Let s be an array of strings. Write a function which 
// finds a closest pair of equal entries. For example, if 
// s = ["All", "work", "and", "no", "play", "makes", "for", "no", 
// "work", "no", "fun", "and", "no", "results"], then the second 
// and third occurrences of "no" is the closest pair.
// Page 94. Solution 277

import java.util.HashMap;

public class FindClosestPair {
	public static int[] findClosestPair(String a[]) {
		int min = Integer.MAX_VALUE;
		int closest[] = new int[2];  // This will save the two index of the closest elements
		HashMap<String, Integer> map = new HashMap<String, Integer>();

		for(int i=0; i<a.length; i++) {
			if(!map.containsKey(a[i])) {
				map.put(a[i], i);
			}
			else {
				int prev = map.get(a[i]);
				if((i - prev) < min) {
					min = i - prev;
					closest[0] = prev;
					closest[1] = i;
				}
				map.put(a[i], i);
			}
		}

		return closest;
	}


	// Main
	public static void main(String args[]) {
		String a[] = {"All", "work", "and", "no", "play", 
		"makes", "for", "no", "work", "no", "fun", "and", "no", "results"};

		int closest[] = findClosestPair(a);  // 7 9 "no"

		for(int i : closest) {
			System.out.print(i + " ");
		}
		System.out.println();
	}
}