package com.aron.algorithms.graph.Digraph;

/**
 * Created by jack on 2016/11/19.
 */
public class DirectedDFS {
	private boolean[] marked;

	public DirectedDFS(Digraph G,int v){
		marked = new boolean[v];
		dfs(G,v);
	}

	public void dfs(Digraph G,int v){
		marked[v] = true;
		for(int w : G.adj(v)){
			if(!marked[w]){
				dfs(G,w);
			}
		}
	}

	public boolean marked(int v){
		return marked[v];
	}
}
