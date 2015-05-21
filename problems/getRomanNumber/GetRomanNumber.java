// Convert Arabic numbers into Roman numbers
// http://stackoverflow.com/questions/12967896/converting-integers-to-roman-numerals-java

public class GetRomanNumber {
	public static String getRomanNumber(int n) {
		int arabic[] = {100, 90, 50, 40, 10, 9, 5, 4, 1};

		StringBuilder romanNumber = new StringBuilder();

		for(int i=0; i<arabic.length; i++) {
			int c = n/arabic[i];
			romanNumber.append(getRoman(c, i));
			n = n-(c*arabic[i]);
		}
		return romanNumber.toString();
	}

	public static String getRoman(int c, int index) {
		String roman[] = {"C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
		StringBuilder romanNumber = new StringBuilder();
		for(int i=0; i<c; i++) {
			romanNumber.append(roman[index]);
		}
		return romanNumber.toString();
	}

	public static void main(String args[]) {
		for(int i=1; i<200; i++) {
			System.out.println(i + ": " + getRomanNumber(i));
		}
	}
}