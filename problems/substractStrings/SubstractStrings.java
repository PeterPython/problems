// Program to substrack two strings
// TODO: Edge cases

public class SubstractStrings {
	// Assuming x > y
	public static String substractStrings(String x, String y) {
		String result = "";
		int lend = 0;

		int i = 0;

		for(i=0; i<y.length(); i++) {
			int a = x.charAt(x.length()-i-1) - '0';
			int b = y.charAt(y.length()-i-1) - '0';
			int dif = a-b;

			if(a == 0 && lend == 1) {   // Check if a was already 0 and had to borrow
				a = 10;
				lend = 1;
				dif = a-b-lend;
			}
			else if(dif < 0) {
				a = a + 10;
				dif = a-b-lend;
				lend = 1;
			}
			else {
				dif = a-b-lend;
				lend = 0;
			}
			result = dif + result;
		}

		// The rest of the string
		for(int j=i; j<x.length(); j++) {
			int a = x.charAt(x.length()-j-1) - '0';
			if(a == 0 && lend == 1) {   // Check if a was already 0 and had to borrow
				a = 10;
				lend = 1;
				a = a-lend;
			} else if(lend == 1) {
				a = a-lend;
				lend = 0;
			}

			result = a + result;
		}

		return result;
	}


	public static void main(String args[]) {
		System.out.println(substractStrings("125", "19"));  // 106
		System.out.println(substractStrings("15", "2"));  // 13
		System.out.println(substractStrings("100", "15"));  // 85
		System.out.println(substractStrings("1000", "15"));  // 985
	}
}