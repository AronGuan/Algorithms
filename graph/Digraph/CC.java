package com.aron.algorithms.graph.Digraph;

/**
 * Created by jack on 2016/10/21.
 */
public class CC {

	private boolean[] marked;
	private int[] id;
	private int count;

	public CC(Digraph G){
		marked = new boolean[G.V()];
		id = new int[G.V()];
		DepthFirstOrder order = new DepthFirstOrder(G.reverse());
		for (int s : order.reversePost()){
			if (!marked[s]){
				dfs(G,s);
				count++;
			}
		}
	}

	private void dfs(Digraph G,int v){
		marked[v] = true;
		id[v] = count;
		for (int w : G.adj(v)){
			if(!marked[v]){
				dfs(G,w);
			}
		}
	}

	public boolean connected(int v,int w){
		return id[v] == id[w];
	}

	public int id(int v){
		return id[v];
	}

	public int count(){
		return count;
	}
}
