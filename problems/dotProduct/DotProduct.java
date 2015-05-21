import java.util.*;
import java.io.*;

public class DotProduct {
	public static void main(String args[]) throws IOException {
		File file = new File("input.txt");
		Scanner in = new Scanner(file);

		String n[] = in.nextLine().split(" ");

		HashMap<Integer, Integer> vector = new HashMap<Integer, Integer>();
		for(int i=0; i<Integer.parseInt(n[0]); i++) {
			String xy[] = in.nextLine().split(" ");
			int x = Integer.parseInt(xy[0]);
			int y = Integer.parseInt(xy[1]);
			vector.put(x,y);
		}

		int dotProduct = 0;
		for(int i=0; i<Integer.parseInt(n[1]); i++) {
			String xy[] = in.nextLine().split(" ");
			int x = Integer.parseInt(xy[0]);
			int y = Integer.parseInt(xy[1]);
			if(vector.containsKey(x)) {
				dotProduct += (vector.get(x) * y);
			}
		}

		System.out.println(dotProduct);
	}
}