package com.aron.algorithms.graph;

import com.aron.algorithms.datastructure.Queue;
import com.aron.algorithms.datastructure.Stack;

/**
 * Created by jack on 2016/10/16.
 */
public class BreadFirstPaths {
	private boolean[] marked;
	private int[] edgeTo;
	private int s;

	public BreadFirstPaths(Graph G,int s){
		this.s = s;
		marked = new boolean[G.V];
		edgeTo = new int[G.V];
		bfs(G,s);
	}

	public void bfs(Graph G,int s){
		Queue<Integer> queue = new Queue<Integer>();
		marked[s] = true;
		queue.enqueue(s);
		while (!queue.isEmpty()){
			int v = queue.dequeue();
			for (int w : G.adj(v)){
				if(!marked[w]){
					marked[w] = true;
					edgeTo[w] = v;
					queue.enqueue(w);
				}
			}
		}
	}

	public boolean hasPathTo(int v){
		return marked[v];
	}

	public Iterable<Integer> pathTo(int v){
		Stack<Integer> path = new Stack<Integer>();
		for (int x = v;x != s;x = edgeTo[x]){
			path.push(x);
		}
		path.push(s);
		return path;
	}
}
