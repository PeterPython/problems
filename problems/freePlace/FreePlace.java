import java.util.*;

public class FreePlace {
	public static LinkedList<String> freePlace(int[][] grid) {
		HashMap<Integer, LinkedList<String>> map = new HashMap<Integer, LinkedList<String>>();
		int max = 0;

		for(int i=0; i<grid.length; i++) {
			for(int j=0; j<grid.length; j++) {
				int count = 0;
				if(grid[i][j] == 0) {
					for(int l=j-1; l>=0; l--) {  // Go to left
						if(grid[i][l] == 2) {
							count++;
							break;
						}
						else if(grid[i][l] == 1) {
							break;
						}
					}

					for(int r=j+1; r<grid.length; r++) {  // Go to right
						if(grid[i][r] == 2) {
							count++;
							break;
						}
						else if(grid[i][r] == 1) {
							break;
						}
					}

					for(int t=j-1; t>=0; t--) {  // Go to top
						if(grid[t][j] == 2) {
							count++;
							break;
						}
						else if(grid[t][j] == 1) {
							break;
						}
					}

					for(int b=j+1; b<grid.length; b++) {  // Go to bottom
						if(grid[b][j] == 2) {
							count++;
							break;
						}
						else if(grid[b][j] == 1) {
							break;
						}
					}
				}

				if(count > max) {
					max = count;
				}

				LinkedList<String> list;

				if(!map.containsKey(count)) {
					list = new LinkedList<String>();
					map.put(count, list);
				}
				else {
					list = map.get(count);
					list.add(i + ", " + j);
				}
			}
		}

		return map.get(max);
	}
}