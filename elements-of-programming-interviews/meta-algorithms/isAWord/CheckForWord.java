// Problem 15.12: Given a dictionary and a string s, design 
// an efficient algorithm that checks whether s is the 
// concatenation of a sequence of dictionary words. If such a 
// concatenation exists, your algorithm should output it.
// Page 121. Solution 351

import java.util.*;

public class CheckForWord {
	public static LinkedList<String> checkForWord(String str, HashSet<String> dictionary) {
		int t[] = new int[str.length()];
		for(int i=0; i<str.length(); i++) {
			if(dictionary.contains(str.substring(0, i+1))) {
				t[i] = i+1;
				System.out.println(i+1);
			} 
			// i=6, j=2
			//i=9, j=6

			for(int j=0; j<i && t[i]==0; j++) {
				if(t[j] != 0 && dictionary.contains(str.substring(j+1, i))) {
					t[j] = i-j;
					System.out.println(i-j);
				}
			}
		}

		LinkedList<String> ret = new LinkedList<String>();
		// if(t.length > 0) {
		// 	int idx = str.length() -1;
		// 	while(idx >= 0) {
		// 		ret.add(str.substring(idx - t[idx] + 1, t[idx]));
		// 		idx -= t[idx];
		// 	}
		// }

		return ret;
	}


	public static void main(String args[]) {
		HashSet<String> dictionary = new HashSet();
		dictionary.add("bed");
		dictionary.add("bath");
		dictionary.add("and");
		dictionary.add("beyond");
		dictionary.add("bat");
		dictionary.add("hand");

		LinkedList<String> list;
		list = checkForWord("bedbathandbeyond", dictionary);
	}
}