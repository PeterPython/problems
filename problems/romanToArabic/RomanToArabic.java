// Converting Roman numbers to Arabic
// http://stackoverflow.com/questions/9073150/converting-roman-numerals-to-decimal

public class RomanToArabic {
	public static int romanToArabic(String str) {
		if(str == null || str.length() == 0) {
			return 0;
		}

		int value = 0;
		int currentSum = 0;
		for(int i=str.length()-1; i>=0; i--) {  // Read from right to left
			char c = str.charAt(i);
			 switch(c) {
			 	case('I'):
			 		currentSum = getCurrentSum(currentSum, 1, value);
			 		value = 1;  // Store to use in the next iteration as previous value
			 		break;

			 	case('V'):
			 		currentSum = getCurrentSum(currentSum, 5, value);
			 		value = 5;
			 		break;

			 	case('X'):
			 		currentSum = getCurrentSum(currentSum, 10, value);
			 		value = 10;
			 		break;

			 	case('L'):
			 		currentSum = getCurrentSum(currentSum, 50, value);
			 		value = 50;
			 		break;

			 	case('C'):
			 		currentSum = getCurrentSum(currentSum, 100, value);
			 		value = 100;
			 		break;
			 }
		}

		return currentSum;
	}


	public static int getCurrentSum(int currentSum, int charValue, int prevValue) {
		if(charValue < prevValue) {   // If the current value is less than the previous value
			currentSum = currentSum - charValue;
		}
		else {
			currentSum = currentSum + charValue;
		}
		return currentSum;
	}


	// Main
	public static void main(String args[]) {
		System.out.println(romanToArabic("I"));  // 1
		System.out.println(romanToArabic("IV"));  // 4
		System.out.println(romanToArabic("V"));  // 5
		System.out.println(romanToArabic("XC"));  // 90
		System.out.println(romanToArabic("CL"));  // 150
		System.out.println(romanToArabic("CLVII"));  // 157
		System.out.println(romanToArabic("CLIX"));  // 159
	}
}