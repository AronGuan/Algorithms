package com.aron.algorithms.graph.Digraph;

import com.aron.algorithms.datastructure.Bag;

/**
 * Created by jack on 2016/10/17.
 */
public class Digraph {
	private Bag<Integer>[] adj;
	private int V;
	private int E;

	public Digraph(int V){
		this.V = V;
		adj = new Bag[V];
		for (int i = 0;i < V;i++){
			adj[i] = new Bag<Integer>();
		}
	}

	public void addEdge(int v,int w){
		adj[v].add(w);
		E++;
	}

	public Iterable<Integer> adj(int v){
		return adj[v];
	}

	public Digraph reverse(){
		Digraph digraph = new Digraph(V);
		for (int i = 0;i < V;i++){
			for (int w : adj[i]){
				digraph.addEdge(w,i);
			}
		}
		return digraph;
	}

	public int V(){
		return V;
	}

	public int E(){
		return E;
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
