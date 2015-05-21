/*
Problem 1.6: Given an image represented by an NxN matrix, where each pixel in the 
image is 4 bytes, write a method to rotate the image by 90 degrees. Canyou do this in place?
Page 176
*/

class MatrixRotation {
	public static void rotateMatrix(int matrix[][]) {
		int last = matrix.length - 1;
		int temp;

		for(int k=0; k<last; k++) {
			for(int i=k; i<last-k; i++) {
				// Create Temporarity variable equals to Top
				temp = matrix[k][i];

				// Top = Left
				matrix[k][i] = matrix[last-i][k];

				// Left = Bottom
				matrix[last-i][k] = matrix[last-k][last-i];

				// Bottom = Right
				matrix[last-k][last-i] = matrix[i][last-k];

				// Right = temp
				matrix[i][last-k] = temp;
			}
		}
	}


	// Main
	public static void main(String args[]) {
		int[][] matrix = {{1,2,3,4}, {5,6,7,8}, {9,10,11,12}, {13,14,15,16}};
		int n = matrix.length;

		System.out.println("Original Matrix: ");
		for(int i=0; i<n; i++) {
			for(int k=0; k<n; k++) {
				System.out.print(matrix[i][k] + " ");
			}
			System.out.println();
		}

		System.out.println("\nMatrix Rotated: ");
		rotateMatrix(matrix);

		for(int i=0; i<n; i++) {
			for(int k=0; k<n; k++) {
				System.out.print(matrix[i][k] + " ");
			}
			System.out.println();
		}
	}
}