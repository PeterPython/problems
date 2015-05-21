// Solution for https://www.hackerrank.com/challenges/even-tree

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    public static LinkedList<Integer> adj[];
    public static boolean marked[];
    public static int countForests = 0;
    public static int v;
    public static int e;
    
    public static void createGraph() {
        // Initializing adj
        
        adj = (LinkedList<Integer>[]) new LinkedList[v+1]; 
        for(int i=0; i<=v; i++) {
            adj[i] = new LinkedList<Integer>();
        }
        marked = new boolean[adj.length+1];
    }
    
    public static int dfs(int v) {
        marked[v] = true;
        int count = 1;
        for(int w : adj[v]) {
            if(!marked[w]) {
                count += dfs(w);
            }
        }
        // If count is even
        if(count%2 == 0) {
            countForests++;
            count = 0;
        }
        return count;
    }
    
    
    // Add edges
    public static void addEdge(int v, int w) {
        adj[v].add(w);
        adj[w].add(v);
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        v = in.nextInt();
        e = in.nextInt();
        
        createGraph();
        
        // Adding edges
        for(int i=0; i<e; i++) {
            int inputV1 = in.nextInt();
            int inputV2 = in.nextInt();
            addEdge(inputV1, inputV2);
        }
        
        dfs(1);
        System.out.println(countForests-1);
    }
}