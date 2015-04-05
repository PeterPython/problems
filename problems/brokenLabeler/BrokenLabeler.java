// Write a program that prompts the user for n and the broken number key
// and then print the highest possible number the user can print on the labeler.
// Example: n=83741232, k=2, return highest number = 83741199

public class BrokenLabeler {
	public static int getHighest(int n, int brokenKey) {
		char arrayN[] = (String.valueOf(n)).toCharArray();

		for(int i=0; i<arrayN.length; i++) {
			// if(arrayN[i] == String.valueOf(brokenKey).charAt(0)) {
			if((arrayN[i] - '0') == brokenKey) {
				if(brokenKey >= 1 && brokenKey <= 9) {
					arrayN[i] = (char) (arrayN[i] - 1);
					if(brokenKey == 9) {
						setRestTo(arrayN, i+1, 8);
					}
					else {
						setRestTo(arrayN, i+1, 9);
					}
					break;  // Stop loop
				}
				else if(brokenKey == 0) {
					for(int j=i; j>=0; j--) {
						if(arrayN[j] > '1' || j==0) {
							arrayN[i] = (char) (arrayN[i] - 1);
							setRestTo(arrayN, j+1, 9);
							break;
						} 
					}
				}
			}
		}

		return Integer.parseInt(String.valueOf(arrayN));
	}

	public static void setRestTo(char[] array, int from, int setTo) {
		char to = String.valueOf(setTo).charAt(0);

		if(from >= array.length) {
			return;
		}
		for(int i=from; i<array.length; i++) {
			array[i] = to;
		}
	}


	public static void main(String args[]) {
		System.out.println(getHighest(83741232, 2));
		System.out.println(getHighest(999, 9));
		System.out.println(getHighest(111, 1));
		System.out.println(getHighest(3111, 1));
		System.out.println(getHighest(1100, 1));
	}
}