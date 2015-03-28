import java.util.*;

public class DepthFirstSearch {
	private HashSet<Integer> marked;
	private int maximum;

	public DepthFirstSearch(Graph graph, int i) {
		marked = new HashSet<Integer>();
		maximum = dfs(graph, i, 0);
	}


	public int getMax() {
		return maximum;
	}
	
	public int dfs(Graph graph, int v, int currentDiff) {
		marked.add(v);
		int max = 0;
		for(Integer w : graph.adj(v)) {
			int dif = Math.abs(w-v);
			if(!marked.contains(w) && dif >= currentDiff && v<w) {
				int current = dfs(graph, w, dif);
				if(current >= max) {
					max = current;
				}
			}
		}
		return max + graph.getPoint(v);
	}
}