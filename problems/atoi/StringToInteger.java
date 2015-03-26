// Implement atoi to convert a string to an integer.
// http://www.programcreek.com/2012/12/leetcode-string-to-integer-atoi/

public class StringToInteger {
	public static int atoi(String str) {
		if(str == null || str.length() == 0) {
			return 0;
		}

		str = str.trim();

		char sign = '+';
		int i = 0;
		if(str.charAt(0) == '-' || str.charAt(0) == '+') {
			sign = str.charAt(0);
			i++;
		}

		double number = 0;

		while(i < str.length() && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
			number = number * 10 + (str.charAt(i) - '0');
			i++;
		}

		if(sign == '-') {
			number = -number;
		}

		if(number >= Integer.MAX_VALUE) {
			return Integer.MAX_VALUE;
		}
		else if(number <= Integer.MIN_VALUE) {
			return Integer.MIN_VALUE;
		}

		return (int) number;
	}

	public static void main(String args[]) {
		System.out.println(atoi("123"));
		System.out.println(atoi("0"));
		System.out.println(atoi("-0"));
		System.out.println(atoi("-123"));	
	}
}