// Problem 11.2: Write a method to sort an array of strings 
// so that all the anagrams are next to each other.
// Page 121. Solution 361

import java.util.*;

public class AnagramComparator implements Comparator<String> {
	public static String sortString(String str) {
		char ar[] = str.toCharArray();
		Arrays.sort(ar);
		return new String(ar);
	}

	public int compare(String str1, String str2) {
		return sortString(str1).compareTo(sortString(str2));
	}
}