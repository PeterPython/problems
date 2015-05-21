/* 
Problem 1.7: Write an algorithm such that if an element in an MxN matrix is 0, 
its entire row and column are set to 0.
Page 180
*/

class SetMatrixZero {
	public static void setMatrixZero(int matrix[][]) {
		int n = matrix.length;
		int m = matrix[0].length;

		boolean rows[] = new boolean[n];
		boolean columns[] = new boolean[m];

		// Check if rows and columns contains zero
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(matrix[i][j] == 0) {
					rows[i] = true;
					columns[j] = true;
				}
			}
		}

		// Set rows to zero
		for(int i=0; i<n; i++) {
			if(rows[i] == true) {
				for(int j=0; j<m; j++) {
					matrix[i][j] = 0;
				}
			}			
		}

		// Set columns to zero
		for(int j=0; j<m; j++) {
			if(columns[j] == true) {
				for(int i=0; i<n; i++) {
					matrix[i][j] = 0;
				}
			}			
		}
	}


	// Main
	public static void main(String args[]) {
		int matrix[][] = {{1,2,3,0},{1,0,4,0},{1,2,3,4},{1,2,3,4},{1,0,2,4}};
		int n = matrix.length;
		int m = matrix[0].length;

		System.out.println("Original Matrix: ");
		for(int i=0; i<n; i++) {
			for(int k=0; k<m; k++) {
				System.out.print(matrix[i][k] + " ");
			}
			System.out.println();
		}

		System.out.println("\nMatrix Zerified: ");
		setMatrixZero(matrix);

		for(int i=0; i<n; i++) {
			for(int k=0; k<m; k++) {
				System.out.print(matrix[i][k] + " ");
			}
			System.out.println();
		}
	}
}