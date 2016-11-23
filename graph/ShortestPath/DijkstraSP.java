package com.aron.algorithms.graph.ShortestPath;

import com.aron.algorithms.datastructure.Stack;

/**
 * Created by jack on 2016/10/30.
 */
public class DijkstraSP {
	private DirectedEdge[] edgeTo;
	private double[] destTo;
	private IndexMinPQ<Double> pq;

	public DijkstraSP(EdgeWeightedDigraph G,int s) throws NoSuchElementException {
		edgeTo = new DirectedEdge[G.V()];
		destTo = new double[G.V()];
		pq = new IndexMinPQ<Double>(G.V());
		for (int v = 0;v < G.V();v++){
			destTo[v] = Double.POSITIVE_INFINITY;
		}
		destTo[s] = 0.0;
		pq.insert(s,0.0);
		while (!pq.isEmpty()){
			relax(G,pq.delMin());
		}
	}

	public void relax(EdgeWeightedDigraph G,int v) throws NoSuchElementException {
		for(DirectedEdge e : G.adj(v)){
			int w = e.to();
			if(destTo[w] > destTo[v] + e.weight()){
				destTo[w] = destTo[v] + e.weight();
				edgeTo[w] = e;
				if(pq.contains(w)) pq.change(w,destTo[w]);
				else pq.insert(w,destTo[w]);
			}
		}
	}

	public double destTo(int v){
		return destTo[v];
	}

	public boolean hasPathTo(int v){
		return destTo[v] < Double.POSITIVE_INFINITY;
	}

	public Iterable<DirectedEdge> pathTo(int v){
		if(hasPathTo(v)) return null;
		Stack<DirectedEdge> path = new Stack<DirectedEdge>();
		for(DirectedEdge e = edgeTo[v]; e != null;e = edgeTo[e.from()]){
			path.push(e);
		}
		return path;
	}
}
