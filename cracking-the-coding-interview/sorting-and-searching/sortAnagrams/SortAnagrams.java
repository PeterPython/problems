// Problem 11.2: Write a method to sort an array of strings 
// so that all the anagrams are next to each other. O(n log(n))
// Page 121. Solution 361

import java.util.*;

public class SortAnagrams {
	public static void sortAnagrams(String a[]) {
		Arrays.sort(a, new AnagramComparator());
	}

	// This is a more efficient of sorting the array because we don't
	// really need to sort it completely but only put the anagrams together
	public static String[] sortAnagrams2(String a[]) {
		HashMap<String, LinkedList<String>> map = new HashMap();

		for(int i=0; i<a.length; i++) {
			String s = AnagramComparator.sortString(a[i]);
			if(!map.containsKey(s)) {
				map.put(s, new LinkedList<String>());
			}
			LinkedList<String> list = map.get(s);
			list.add(a[i]);
		}

		// Add HashMap to an array
		String sorted[] = new String[a.length];
		int i = 0;
		for(String key : map.keySet()) {
			LinkedList<String> list = map.get(key);
			for(String s : list) {
				sorted[i] = s;
				i++;
			}
		}

		return sorted;
	}


	// Main
	public static void main(String args[]) {
		String a[] = {"olah", "haoc", "abc", "eia", "bca", "aei", "hola", "chao"};

		sortAnagrams(a);

		for(String s : a) {
			System.out.println(s + " ");
		}
		System.out.println();

		String b[] = {"olah", "haoc", "abc", "eia", "bca", "aei", "hola", "chao"};

		b = sortAnagrams2(b);

		for(String s : b) {
			System.out.println(s + " ");
		}
	}
}