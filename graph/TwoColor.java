package com.aron.algorithms.graph;

/**
 * Created by jack on 2016/11/19.
 */
public class TwoColor {
	private boolean[] marked;
	private boolean[] color;
	private boolean isTwoColorable = true;

	private TwoColor(Graph G){
		marked = new boolean[G.V()];
		color = new boolean[G.V()];
		for(int s = 0;s < G.V();s++){
			dfs(G,s);
		}
	}

	private void dfs(Graph G,int v){
		marked[v] = true;
		for(int w : G.adj(v)){
			if(!marked[w]){
				color[w] = !color[v];
				dfs(G,w);
			}else if(marked[w] == marked[v]){
				isTwoColorable = false;
			}

		}
	}

	public boolean isTwoColor(){
		return isTwoColorable;
	}
}
