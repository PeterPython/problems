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
	private Hashtable<String, LinkedList<String>> adj;

	private HashSet marked;
	private Stack<String> reversePost;  // Vertices in reverse postorder

	public Graph() {
		this.v = 0;
		this.e = 0;
		adj = new Hashtable<String, LinkedList<String>>();
	}

	public void addEdge(String v, String w) {
		LinkedList<String> ll;
		if(!adj.containsKey(v)) {
			ll = new LinkedList<String>();
			ll.add(w);
			adj.put(v, ll);

			LinkedList<String> ll2 = new LinkedList<String>();	
			adj.put(w, ll2);
		}
		else {
			ll = adj.get(v);
			ll.add(w);
		}
		e++;
	}

	public Iterable<String> adj(int v) {
		return adj.get(v);
	}

	public int getV() {
		return v;
	}

	public int getE() {
		return e;
	}


	// Depth First Search
	public void dfs() {
		marked = new HashSet();
		Set<String> keys = adj.keySet();
		for(String v : keys) {
			if(!marked.contains(v)) {
				dfs(v);			
			}
		}
	}

	public void dfs(String v) {
		marked.add(v);

		for(String w : adj.get(v)) {
			if(!marked.contains(w)) {
				dfs(w);
			}
		}
		reversePost.add(v);  // Add to Stack after recursive call
	}

	public Iterable<String> topologicalOrder() {
		return reversePost;
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

	public Iterable<String> getOrder(String a[]) {
		stringToCharGraph(a);
		dfs();
		return topologicalOrder();
	}
}