// Sort the countries according to their number

import java.util.*;
import java.io.*;

public class SortRank {
	public static void main(String args[]) throws IOException {
		HashMap<Integer, String> map = new HashMap<Integer, String>();
		File file = new File("input.txt");
		Scanner in = new Scanner(file);

		int n = Integer.parseInt(in.nextLine());
		int a[] = new int[n];
		for(int i=0; i<n; i++) {
			String line[] = in.nextLine().split(" ");
			String country = line[0];
			int rank = Integer.parseInt(line[1]);

			map.put(rank, country);
			a[i] = rank;
		}

		Arrays.sort(a);
		for(int i : a) {
			System.out.println(map.get(i));
		}
	}
}