import java.util.*;
import java.io.*;

public class SymbolGraph {
	private int e;
	private int v;
	private LinkedList<Integer> adj[];

	private boolean marked[];

	private Stack<Integer> reverseOrder;

	private Hashtable<String, Integer> st;
	private String inv[];

	public SymbolGraph(int v) {
		this.v = v;
		this.e = e;
		adj = (LinkedList<Integer>[]) new LinkedList[v];

		st = new Hashtable<String, Integer>();
		inv = new String[v];

		for(int i=0; i<v; i++) {
			adj[i] = new LinkedList<Integer>();
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
		e++;
	}

	public void dfs() {
		reverseOrder = new Stack<Integer>();
		marked = new boolean[v];

		for(int i=0; i<v; i++) {
			if(!marked[i]) {
				dfs(i);
			}
		}
	}

	public void dfs(int v) {
		marked[v] = true;
		System.out.print(inv[v] + " "); // This will return preorder and Strings

		for(int w : adj(v)) {
			if(!marked[w]) {
				dfs(w);
			}
		}
		reverseOrder.add(v);  // For Topological sort
	}

	public Iterable<Integer> topologicalOrder() {
		return reverseOrder;
	}
	
	// Add String edges
	public void addEdge(String v, String w) {
		if(!st.containsKey(v)) {
			st.put(v, st.size());
			inv[st.get(v)] = v;
		}
		if(!st.containsKey(w)) {
			st.put(w, st.size());
			inv[st.get(w)] = w;
		}

		addEdge(st.get(v), st.get(w));
	}

	public int index(String str) {
		return st.get(str);
	}

	public String name(int v) {
		return inv[v];
	}


	public static void main(String args[]) throws IOException {
		File fr = new File("PracticeInput.txt");
		Scanner in = new Scanner(fr);

		in.nextLine();
		String line;
		while(in.hasNextLine()) {
			System.out.println("hi");
		}
	}
}