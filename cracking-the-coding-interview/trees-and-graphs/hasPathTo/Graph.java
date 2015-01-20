// Problem 4.2: Given a directed graph, design an algorithm 
// to find out whether there is a route between two nodes.
// Page 86. Solution 221

public class Graph {
	private int e;
	private int v;
	private Bag<Integer> adj[];

	public Graph(int v) {
		this.v = v;
		this.e = 0;
		adj = (Bag<Integer>[]) new Bag[v];

		for(int i=0; i<v; i++) {
			adj[i] = new Bag<Integer>();
		}
	}

	public int getE() {
		return e;
	}

	public int getV() {
		return v;
	}

	public Iterable<Integer> adj(int v) {
		return adj[v];
	}

	public void addEdge(int v, int w) {
		adj[v].add(w);
		// adj[w].add(v);
		e++;
	}
}