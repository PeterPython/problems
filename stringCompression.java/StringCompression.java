import java.util.*;
import java.io.*;

public class StringCompression {

	public static String compression(String str) {
		int c = 1;
		String s = "";

		for(int i=0; i<str.length(); i++) {
			if(i == str.length()-1) {
				if(c != 1) {
					s += c + "" + str.charAt(i);
					break;				
				}
				else {
					s += str.charAt(i);
					break;
				}
			}
			else if(str.charAt(i) == str.charAt(i+1)) {
				c++;
			}
			else {
				if(c != 1){
					s += c;
					s += str.charAt(i);
					c = 1;
				}
				else {
					s += str.charAt(i);
					c = 1;
				}
			}
		}

		return s;
	}


	// Main
	public static void main(String args[]) throws IOException {
		File fr = new File("PracticeInput.txt");
		Scanner in = new Scanner(fr);
		int t = in.nextInt();
		System.out.println(t);
		in.nextLine();

		for(int i=0; i<t; i++) {
			String str = in.nextLine();
			System.out.println(compression(str));
		}
	}
}