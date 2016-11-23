package com.aron.algorithms.graph;

import com.aron.algorithms.datastructure.Bag;

/**
 * Created by jack on 2016/10/13.
 */
public class Graph {
	public int V;
	public int E;
	private Bag<Integer>[] adj;

	public Graph(int V){
		this.V = V;
		adj = new Bag[V];
		for(int i = 0;i < V;i++){
			adj[i] = new Bag<Integer>();
		}
	}

	public void addEdge(int v,int w){
		adj[v].add(w);
		adj[w].add(v);
		E++;
	}

	public int V(){
		return V;
	}

	public Iterable<Integer> adj(int v){
		return adj[v];
	}

	public String toString(){
		String s = "V: " + V + " "+ "E: " + E + "\n";
		for(int v = 0;v < V;v++){
			s += v + ": ";
			for (int w : adj[v]){
				s += w + " ";
			}
			s += "\n";
		}
		return s;
	}
}
