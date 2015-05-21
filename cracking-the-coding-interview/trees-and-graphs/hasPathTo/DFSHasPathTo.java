// Problem 4.2: Given a directed graph, design an algorithm 
// to find out whether there is a route between two nodes.
// Page 86. Solution 221

public class DFSHasPathTo {
	private boolean marked[];

	public DFSHasPathTo(Graph graph, int source) {
		marked = new boolean[graph.getV()];
		dfs(graph, source);
	}

	private void dfs(Graph graph, int source) {
		marked[source] = true;
		for(int w : graph.adj(source)) {
			if(!marked[w]) {
				dfs(graph, w);
			}
		}
	}

	public boolean hasPathTo(int v) {
		return marked[v];
	}
}