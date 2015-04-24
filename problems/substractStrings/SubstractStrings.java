// Program to substrack two strings

public class SubstractStrings {
	public static String substractStrings(String x, String y) {
		// 125, 19
		String result = "";

		for(int i=0; i<y.length(); i++) {
			int a = x.charAt(x.length()-i) - '0';
			int b = y.charAt(y.length()-i) - '0';

			int dif = a-b;
			if(dif < 0) {
				
			}
		}

		return result;
	}

	public static void main(String args[]) {
		String x = "1234";
		int a = x.charAt(0) - '0';
		System.out.println(a);
	}
}