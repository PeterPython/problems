// Remove all the vowels in a string

import java.util.*;

public class RemoveVowels {
	public static String removeVowels(String str) {
		HashSet<Character> hash = new HashSet<Character>();
		hash.add('a');
		hash.add('e');
		hash.add('i');
		hash.add('o');
		hash.add('u');

		char letter[] = str.toCharArray();
		StringBuilder builder = new StringBuilder();

		for(char i : letter) {
			if(!hash.contains(i)) {
				builder.append(i);
			}
		}

		return builder.toString();
	}


	public static void main(String[] args) {
		String str = "alejo";
		System.out.println(removeVowels(str));
	}
}