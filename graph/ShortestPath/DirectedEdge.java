package com.aron.algorithms.graph.ShortestPath;

/**
 * Created by jack on 2016/10/30.
 */
public class DirectedEdge {
	private int v;
	private int w;
	private double weight;

	public DirectedEdge(int v,int w,int weight){
		this.v = v;
		this.w = w;
		this.weight = weight;
	}

	public int from(){
		return v;
	}

	public int to(){
		return w;
	}

	public double weight(){
		return weight;
	}
}
