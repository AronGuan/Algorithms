package com.aron.algorithms.graph.Digraph;

/**
 * Created by jack on 2016/10/21.
 */
public class Topological {

	private Iterable<Integer> order;

	public Topological(Digraph G){
		DirectedCycle cycle = new DirectedCycle(G);
		if(!cycle.hasCycle()){
			DepthFirstOrder dfs = new DepthFirstOrder(G);
			order = dfs.reversePost();
		}
	}

	public Iterable<Integer> order(){
		return order;
	}

	public boolean isToPo(){
		return order != null;
	}
}
