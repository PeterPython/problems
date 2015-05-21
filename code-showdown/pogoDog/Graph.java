import java.util.*;

public class Graph {
	private int e;
	public HashMap<Integer, LinkedList<Integer>> adj;
	private HashMap<Integer, Integer> targetPoint;

	public Graph() {
		adj = new HashMap<Integer, LinkedList<Integer>>();
		targetPoint = new HashMap<Integer, Integer>();
	}

	public Iterable<Integer> adj(int v) {
		return adj.get(v);
	}

	public int getPoint(int v) {
		return targetPoint.get(v);
	}

	public void addEdge(int v1, int t1, int v2, int t2) {
		if(!adj.containsKey(v1)) {
			LinkedList<Integer> list = new LinkedList<Integer>();
			adj.put(v1, list);
			list.add(v2);
		}
		else {
			LinkedList<Integer> list = adj.get(v1);
			list.add(v2);
		}

		if(!adj.containsKey(v2)) {
			LinkedList<Integer> list = new LinkedList<Integer>();
			adj.put(v2, list);
		}

		targetPoint.put(v1, t1);
		targetPoint.put(v2, t2);
	}
}