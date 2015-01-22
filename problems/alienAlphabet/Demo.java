// Demo for Topological sort problem

import java.util.*;

public class Demo {
	public static void main(String args[]) {
		Graph graph = new Graph();

		// String a[] = {"a", "bc", "bd", "bde", "be"};

		// graph.stringToCharGraph(a);
		graph.addEdge("hi", "bye");
		graph.dfs();
		// for(String st : graph.getOrder(a)) {
		// 	System.out.print(st + " ");
		// }


	}
}