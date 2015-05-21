import java.util.*;
import java.io.*;

public class PogoDog {
	public static void main(String args[]) throws IOException {
		
		File file = new File("input.txt");  // Name of the file to read;
		Scanner in = new Scanner(file);  // Read a file
		int test = Integer.parseInt(in.nextLine());

		for(int i=0; i<test; i++) {
			int n = Integer.parseInt(in.nextLine());
			HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
			for(int j=0; j<n; j++) {
				String line = in.nextLine();
				String elements[] = line.split(" ");  // Separating elements by comma
				map.put(Integer.parseInt(elements[0]), Integer.parseInt(elements[1]));
			}

			Graph graph = new Graph();

			for(Integer inte : map.keySet()) {
				for(Integer j : map.keySet()) {
					if(inte < j) {
						graph.addEdge(inte, map.get(inte), j, map.get(j));
					}
				}
			}

			int max = 0;
			int current = 0;
			for(Integer key : map.keySet()) {
				DepthFirstSearch dfs = new DepthFirstSearch(graph, key);
				current = dfs.getMax();
				if(max < current) {
					max = current;
				}
			}
			System.out.println(max);
		}
	}

}