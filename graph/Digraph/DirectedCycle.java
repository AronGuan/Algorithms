package com.aron.algorithms.graph.Digraph;

import com.aron.algorithms.datastructure.Stack;

/**
 * Created by jack on 2016/10/18.
 */
public class DirectedCycle {
	private boolean[] marked;
	private Stack<Integer> cycle;
	private boolean[] onStack;
	private int[] edgeTo;

	public DirectedCycle(Digraph G){
		marked = new boolean[G.V()];
		onStack = new boolean[G.V()];
		edgeTo = new int[G.V()];
		for (int v = 0; v < G.V();v++){
			if(!marked[v]) dfs(G,v);
		}
	}

	private void dfs(Digraph G,int v){
		marked[v] = true;
		onStack[v] = true;
		for (int w : G.adj(v)){
			if(hasCycle()) return;
			else if(!marked[w]){
				edgeTo[w] = v;
				dfs(G,w);
			}else if(onStack[w]){
				cycle = new Stack<Integer>();
				for(int x = v;x != w; x = edgeTo[x]){
					cycle.push(x);
				}
				cycle.push(w);
				cycle.push(v);
			}
		}
		onStack[v] = false;

	}

	public boolean hasCycle(){
		return cycle != null;
	}

	public Iterable<Integer> cycle(){
		return cycle;
	}

}
