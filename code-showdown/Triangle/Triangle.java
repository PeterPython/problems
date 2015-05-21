import java.util.*;
import java.io.*;

public class Triangle {

	public static int triangle(int line, int index, int matrix[][], int memo[][], int nLines) {
		int current = matrix[line][index];
		if(line == nLines) {
			return current;
		}

		if(memo[line][index] == -1) {
			memo[line][index] = triangle(line+1, index, matrix, memo, nLines) + current;
		}

		if(memo[line][index+1] == -1) {
			memo[line][index+1] = triangle(line+1, index+1, matrix, memo, nLines) + current;
		}

		return Math.max(memo[line][index], memo[line][index+1]);
	}

	public static void main(String args[]) throws IOException {
		File file = new File("input2.txt");  // Name of the file to read;
		Scanner in = new Scanner(file);  // Read a file
		int n = Integer.parseInt(in.nextLine());
		System.out.println(n);
		int total = 0;

		int matrix[][] = new int[n][n];
		int memo[][] = new int[n][n];

		int index = 0;
		while(in.hasNextLine()) {  // read each line
			String line = in.nextLine();
			String elements[] = line.split(" ");  // Separating elements by comma

			int j = 0;
			for(String str : elements) {
				matrix[index][j] = Integer.parseInt(str);
				j++;
			}
	
			index++;
		}


		for(int i=0;i<n; i++) {
			for(int j=0; j<n; j++) {
				memo[i][j] = -1;
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}

		System.out.println( triangle(0, 0, matrix, memo, n-1));
	}
}