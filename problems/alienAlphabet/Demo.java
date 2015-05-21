// Demo for Topological sort problem

import java.util.*;

public class Demo {
	public static void main(String args[]) {
		Graph graph = new Graph(5);
		// Graph graph2 = new Graph(5);

		// graph2.addEdge(0,1);
		// graph2.addEdge(1,2);
		// graph2.addEdge(2,3);
		// graph2.addEdge(3,4);


		// graph2.addEdge("a","b");
		// graph2.addEdge("b","c");
		// graph2.addEdge("c","d");
		// graph2.addEdge("d","e");
		// graph2.dfs();

		String a[] = {"a", "bc", "bd", "bde", "be"};
		// String a[] = {"a", "bca", "bcd", "cda", "d"};
		Arrays.sort(a);

		for(String s : a) {
			System.out.print(s + ", ");
		}
		System.out.println();

		graph.stringToCharGraph(a);
		graph.dfs();
		Stack<String> st = graph.topologicalOrder();

		while(!st.isEmpty()) {
			System.out.print(st.pop() + " ");
		}
		System.out.println();
	}
}