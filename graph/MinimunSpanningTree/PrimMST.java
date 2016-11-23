package com.aron.algorithms.graph.MinimunSpanningTree;

import com.aron.algorithms.datastructure.Queue;
import com.aron.algorithms.graph.ShortestPath.IndexMinPQ;
import com.aron.algorithms.graph.ShortestPath.NoSuchElementException;

/**
 * Created by jack on 2016/10/30.
 */
public class PrimMST {
	private Edge[] edgeTo;
	private double[] destTo;
	private boolean[] marked;
	private IndexMinPQ<Double> pq;

	public PrimMST(EdgeWeightedGraph G) throws NoSuchElementException {
		edgeTo = new Edge[G.V()];
		destTo = new double[G.V()];
		marked = new boolean[G.V()];
		pq = new IndexMinPQ<Double>(G.V());

		for(int v = 0;v < G.V();v++){
			destTo[v] = Double.POSITIVE_INFINITY;
		}
		destTo[0] = 0.0;
		pq.insert(0,0.0);
		while (!pq.isEmpty()){
			visit(G,pq.delMin());
		}
	}

	public void visit(EdgeWeightedGraph G,int v) throws NoSuchElementException {
		marked[v] = true;
		for (Edge e : G.adj(v)){
			int w = e.other(v);
			if(marked[w]) continue;
			if(destTo[w] > e.weight()){
				destTo[w] = e.weight();
				edgeTo[w] = e;
				if(pq.contains(w)) pq.change(w,destTo[w]);
				else pq.insert(w,destTo[w]);
			}
		}
	}

	public Iterable<Edge> edges() {
		Queue<Edge> mst = new Queue<Edge>();
		for (int v = 0; v < edgeTo.length; v++) {
			Edge e = edgeTo[v];
			if (e != null) {
				mst.enqueue(e);
			}
		}
		return mst;
	}

}
