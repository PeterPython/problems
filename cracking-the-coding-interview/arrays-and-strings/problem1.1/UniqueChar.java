// Problem 1.1: Implement an algorithm to determine if a string has all unique characters. 
// What if you cannot use additional data structures?
// Page 172

class UniqueChar {
	public static boolean hasUnique(String st) {
		boolean boolArray[] = new boolean[256];
		int k;

		if(st.length() > 256) {
			return false;
		}

		for(int i=0; i<st.length(); i++) {
			k = st.charAt(i);
			if(boolArray[k] != true) {
				boolArray[k] = true;
			} else {
				return false;
			}
		}

		return true;
	}


	// Main
	public static void main(String args[]) {
		String st = "hola";
		System.out.println("Does '" + st + "' has unique characters?: " + hasUnique(st));

		System.out.println();

		st = "programming";
		System.out.println("Does '" + st + "' has unique characters?: " + hasUnique(st));
	}
}