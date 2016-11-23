package com.aron.algorithms.graph;

/**
 * Created by jack on 2016/10/14.
 */
public class DepthFirstSearch {
	private boolean[] marked;
	private int count;

	public DepthFirstSearch(Graph G,int s){
		marked = new boolean[G.V];
		dfs(G,s);
	}

	public void dfs(Graph G,int s){
		marked[s] = true;
		count++;
		for (int v : G.adj(s)){
			if (!marked[v]){
				dfs(G,v);
			}
		}
	}

	public boolean marked(int v){
		return marked[v];
	}

	public int count(){
		return count;
	}
}
