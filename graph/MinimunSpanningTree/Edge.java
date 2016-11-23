package com.aron.algorithms.graph.MinimunSpanningTree;

/**
 * Created by jack on 2016/10/23.
 */
public class Edge implements Comparable<Edge> {
	private int v;
	private int w;
	private double weight;

	public Edge(int v,int w,int weight){
		this.v = v;
		this.w = w;
		this.weight = weight;
	}

	public int either(){
		return v;
	}

	public int other(int x){
		if(x == v) return w;
		else if(x == w) return v;
		else throw new RuntimeException();
	}

	public double weight(){
		return weight;
	}

	public int compareTo(Edge edge) {
		if(this.weight < edge.weight) return -1;
		else if(this.weight > edge.weight) return 1;
		return 0;
	}
}
