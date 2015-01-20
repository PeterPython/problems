// Demo for Problem 4.2: Given a directed graph, design an algorithm 
// to find out whether there is a route between two nodes.
// Page 86. Solution 221

public class Demo {
	public static void main(String args[]) {
		Graph graph = new Graph(8);

		graph.addEdge(0, 1);
		graph.addEdge(1, 2);
		graph.addEdge(1, 3);
		graph.addEdge(1, 4);
		graph.addEdge(2, 5);
		graph.addEdge(2, 6);
		graph.addEdge(6, 7);
		graph.addEdge(7, 2);


		DFSHasPathTo dfs = new DFSHasPathTo(graph, 0);

		System.out.println(dfs.hasPathTo(3));
	}
}