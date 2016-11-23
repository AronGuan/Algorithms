package com.aron.algorithms.graph.MinimunSpanningTree;

import com.aron.algorithms.datastructure.Bag;

/**
 * Created by jack on 2016/10/23.
 */
public class EdgeWeightedGraph {
	private Bag<Edge>[] adj;
	private int V;
	private int E;

	public EdgeWeightedGraph(int v){
		this.V = v;
		adj = new Bag[V];
		for (int i = 0;i < v;i++){
			adj[i] = new Bag<Edge>();
		}
	}

	public int V(){
		return V;
	}

	public int E(){
		return E;
	}

	public void add(Edge edge){
		int v = edge.either();
		int w = edge.other(v);
		adj[v].add(edge);
		adj[w].add(edge);
		E++;
	}

	public Iterable<Edge> adj(int v){
		return adj[v];
	}

	public Iterable<Edge> edges(){
		Bag<Edge> bag = new Bag<Edge>();
		for(int v = 0;v < V;v++){
			for (Edge edge : adj(v)){
				if(edge.other(v) > v) bag.add(edge);
			}
		}
		return bag;
	}
}
