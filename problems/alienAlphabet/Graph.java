/*
https://www.ocf.berkeley.edu/~kelu/interviews/questions.html
Given a list of words in an alien language. If you know the 
list is sorted in alphabetical order then how do you determine 
the alphabetical order of the letters? For example, from the 
following list of English words we can determine the letter "t" 
must come after "b". And "c" is before "z". 
list: cab cat zebra 
*/

import java.util.*;

public class Graph {
	private int e;
	private int v;
	private LinkedList<Integer> adj[];

	private boolean marked[];

	private Stack<String> reverseOrder;

	private Hashtable<String, Integer> st;
	private String inv[];

	public Graph(int v) {
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
		marked = new boolean[v];
		reverseOrder = new Stack<String>();

		for(int i=0; i<v; i++) {
			if(!marked[i]) {
				dfs(i);
			}
		}
	}

	public void dfs(int v) {
		marked[v] = true;

		for(int w : adj(v)) {
			if(!marked[w]) {
				dfs(w);
			}
		}
		reverseOrder.push(name(v));  // To get topological order
	}


	// addEdge for String vertex
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

	public String name(int v) {
		return inv[v];
	}


	// Return topological order of string
	public Stack<String> topologicalOrder() {
		return reverseOrder;
	}

	// Break down array of Strings into a graph of characters
	public void stringToCharGraph(String a[]) {
		int size = a.length;

		for(int i=0; i<size-1; i++) {
			String st1 = a[i];
			String st2 = a[i+1];

			if(st1.equals(st2)) { // If strings are the same skip
				continue;
			}
			if(st1.charAt(0) == st2.charAt(0)) {
				for(int j=0; j<(Math.min(st1.length(), st2.length())); j++) {
					if(st1.charAt(j) != st2.charAt(j)) {
						addEdge(String.valueOf(st1.charAt(j)), String.valueOf(st2.charAt(j)));
						break;
					}
				}
			}
			else {
				addEdge(String.valueOf(st1.charAt(0)), String.valueOf(st2.charAt(0)));
			}
		}
	}
}