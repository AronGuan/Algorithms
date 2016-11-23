package com.aron.algorithms.graph;

import com.aron.algorithms.datastructure.Stack;

/**
 * Created by jack on 2016/10/15.
 */
public class DepthFirstPaths {
	private boolean[] marked;
	private int[] edge;
	private int s;

	public DepthFirstPaths(Graph G,int s){
		marked = new boolean[G.V];
		edge = new int[G.V];
		this.s = s;
		dfs(G,s);
	}

	private void dfs(Graph G,int v){
		marked[v] = true;
		for (int w : G.adj(v)) {
			if (!marked[w]) {
				edge[w] = v;
				dfs(G, w);

			}
		}
	}

	public boolean hasPathTo(int v){
		return marked[v];
	}

	public Iterable<Integer> PathTo(int v){
		if(!hasPathTo(v)) return null;
		Stack<Integer> stack = new Stack<Integer>();
		for (int x = v; x != s;x = edge[x]){
			stack.push(x);
		}
		stack.push(s);
		return stack;
	}


}
