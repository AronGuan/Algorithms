package com.aron.algorithms.graph.ShortestPath;

import com.aron.algorithms.datastructure.Bag;

/**
 * Created by jack on 2016/10/30.
 */
public class EdgeWeightedDigraph {
	private int V;
	private int E;
	private Bag<DirectedEdge>[] adj;

	public EdgeWeightedDigraph(int v){
		this.V = v;
		adj = new Bag[V];
		for(int i = 0;i < V;i++){
			adj[i] = new Bag<DirectedEdge>();
		}
	}

	public void addEdge(DirectedEdge e){
		adj[e.from()].add(e);
		E++;
	}

	public Bag<DirectedEdge> adj(int v){
		return adj[v];
	}

	public int V(){
		return V;
	}

	public int E(){
		return E;
	}

	public Bag<DirectedEdge> edges(){
		Bag<DirectedEdge> bag = new Bag<DirectedEdge>();
		for(int v = 0;v < V;v++){
			for(DirectedEdge e : adj[v]){
				bag.add(e);
			}
		}
		return bag;
	}

}
