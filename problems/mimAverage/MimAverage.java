// Get the mim average of a subarray. Min length of subarray is 2

public class MimAverage {
	public static void main(String args[]) {
		int a[] = {1, 3, 1, 2, 4, 1, 6, 8};

		System.out.println("With two loops O(n^2): ");
		System.out.println(getMinAverage(a));

		System.out.println("\nWith one loop O(n): ");
		System.out.println(getMinAvg(a));
	}

	// This is O(n)
	public static String getMinAvg(int a[]) {
		double sum = 0;
		double avg;
		double min = Double.POSITIVE_INFINITY;
		String str, minStr = "";

		for(int i=0; i<a.length-1; i++) {
				sum = a[i] + a[i+1];
				avg = sum / 2;
				str = i + ", " + (i+1) + ", ";

			if(i < a.length-2) {
				sum += a[i+2];
				if(avg > sum/3) {
					avg = sum/3;
					str += (i+2) + " ";
				}

			}

			if(avg < min) {
				min = avg;
				minStr = str + ". Average = " + min;
			}
		}

		minStr = "Minimum average is the sum of indexs: " + minStr;
		return minStr;
	}


	// This is O(n^2)
	public static String getMinAverage(int a[]) {
		double sum = 0;
		double count;
		double average;
		String index = "";
		double min = Double.POSITIVE_INFINITY;
		String minString = "";
		String str = "";

		for(int i=0; i<a.length-1; i++) {
			index = "";
			count = 2;
			sum = a[i] + a[i+1];
			average = sum / count++;
			index = i + ", " + (i+1) + ", "; 
			str = index + " = " + sum + ", Average = " + average;
			System.out.println(str);
			if(average < min) {
				min = average;
				minString = "\nMinimum average is the sum of indexs: " + str;
			}
			for(int k=i+2; k<a.length; k++) {
				sum += a[k];
				average = sum / count++;
				index+= k + ", "; 
				str = index + " = " + sum + ", Average = " + average;
				System.out.println(str);
				if(average < min) {
					min = average;
					minString = "\nMin average is the sum of indexs: " + str;
				}
			}
		}

		return minString;
	}
}