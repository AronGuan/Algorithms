package com.aron.algorithms.graph.MinimunSpanningTree;

import com.aron.algorithms.datastructure.Queue;

/**
 * Created by jack on 2016/10/24.
 */
public class LazyPrimMST {
	private boolean[] marked;
	private Queue<Edge> mst;
	private MinxPQ<Edge> pq;

	public LazyPrimMST(EdgeWeightedGraph G){
		marked = new boolean[G.V()];
		mst = new Queue<Edge>();
		pq = new MinxPQ<Edge>(G.V());

		visit(G,0);
		while (!pq.isEmpty()){
			Edge edge = pq.delMin();
			int v = edge.either();
			int w = edge.other(v);
			if(marked[v]&&marked[w]) continue;
			mst.enqueue(edge);
			if(!marked[v]) visit(G,v);
			if(!marked[w]) visit(G,w);
		}
	}

	public Iterable<Edge> edges(){
		return mst;
	}

	public double weight(){
		double weight = 0.0;
		for(Edge edge:mst){
			weight += edge.weight();
		}
		return weight;
	}

	private void visit(EdgeWeightedGraph G,int v){
		marked[v] = true;
		for (Edge edge : G.adj(v)){
			if(!marked[edge.other(v)]) pq.insert(edge);
		}
	}
}
