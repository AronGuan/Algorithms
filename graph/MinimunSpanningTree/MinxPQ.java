package com.aron.algorithms.graph.MinimunSpanningTree;

/**
 * Created by jack on 2016/9/13.
 */
public class MinxPQ<Key extends Comparable<Key>> {

	private Key[]  pq;
	private int N;

	public MinxPQ(int N){
		pq = (Key[])new Comparable[N + 1];
	}

	public boolean isEmpty(){
		return N == 0;
	}

	public void insert(Key k){
		pq[++N] = k;
		swin(N);
	}

	public Key delMin(){
		Key k = pq[1];
		exch(1,N--);
		pq[N + 1] = null;
		sink(1);
		return k;
	}

	private boolean less(int i,int j ){
		return  pq[i].compareTo(pq[j]) > 0;
	}

	private void exch(int i,int j){
		Key t = pq[i];
		pq[i] = pq[j];
		pq[j] = t;
	}

	private void swin(int k){
		while(k > 1 && less(k/2,k)){
			exch(k/2,k);
			k = k/2;
		}
	}

	private void sink(int k){
		while(2 * k <= N){
			int j = 2 * k;
			if(j < N && less(j,j+1)) j++;
			if(!less(k,j)) break;
			exch(j,k);
			k = j;
		}
	}


}
