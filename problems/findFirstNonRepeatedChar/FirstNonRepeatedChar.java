// Find the first non-repeated Character in a String

import java.util.HashMap;

public class FirstNonRepeatedChar {
	public static char findFirstChar(String str) {
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		for(int i=0; i<str.length(); i++) {
			if(!map.containsKey(str.charAt(i))) {
				map.put(str.charAt(i), 1);
			}
			else {
				map.put(str.charAt(i), map.get(str.charAt(i)) + 1);
			}
		}

		for(int i=0; i<str.length(); i++) {
			if(map.get(str.charAt(i)) == 1) {
				return str.charAt(i);
			}
		}

		return 0;
	}


	// Main
	public static void main(String args[]) {
		String str = "hola como estas hola";
		System.out.println(str);

		System.out.println(findFirstChar(str));
	}
}