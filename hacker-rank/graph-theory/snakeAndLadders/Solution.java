// Snakes and Ladders: The Quickest Way Up
// https://www.hackerrank.com/challenges/the-quickest-way-up

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
	public static boolean marked[];
	public static int edgeTo[];
	public static LinkedList<Integer> adj[];
	public static int count;

	// Build the graph
	public static void createGraph() {
		adj = (LinkedList<Integer>[]) new LinkedList[101];
		for(int i=0; i<=100; i++) {
			adj[i] = new LinkedList<Integer>();
		}

		// Make node point to the next six nodes because you can control de die
		for(int i=1; i<=100; i++) {
			if(i<=94) {
				for(int j=1; j<=6; j++) {
					addEdge(i, i+j);
				}
			}
			else {
				for(int k=i+1; k<=100; k++) {
					addEdge(i, k);
				}
			}
		}
		
		marked = new boolean[101];
		edgeTo = new int[101];
	}
	
	// Breadth First Search
	public static void bfs() {
		LinkedList<Integer> queue = new LinkedList<Integer>();
		queue.add(1);
		marked[1] = true;
		
		while(!queue.isEmpty()) {
			int v = queue.remove();
			
			for(int w : adj[v]) {
				if(!marked[w]) {
					edgeTo[w] = v;
					marked[w] = true;
					queue.add(w);
				}
			}
		}
	}
	
	// Count how many steps are needed to reach a 100
	public static int countSteps() {
		count = 0;
		for(int x=100; x!=1; x=edgeTo[x]) {
			count++;
		}
		return count-1;
	}
	
	// Add edge to the graph
	public static void addEdge(int v, int w) {
		adj[v].add(w);
	}
	

	// Main
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		in.nextLine();
		for(int i=0; i<t; i++) {
			createGraph();
			in.nextLine();
			for(int j=0; j<2; j++) {
				String strArray[] = in.nextLine().split(" ");
				for(int k=0; k<strArray.length; k++) {
					String vertexArray[] = strArray[k].split(",");
					addEdge(Integer.parseInt(vertexArray[0]), Integer.parseInt(vertexArray[1]));
				}
			}
			bfs();
			System.out.println(countSteps());
		}
	}
}