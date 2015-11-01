package pers.aron;

import java.util.Arrays;

public class MaxPQ<key extends Comparable<key>>{

	private key[] pq; //基于堆的完全二叉树
	private int N = 0;  //存储于pa[1...N]中,pq[0]没有使用
	
	public MaxPQ(int maxN){
		pq = (key[])new Comparable[maxN+1];
	}
	
	public boolean isEmpty(){
		return N == 0;
	}
	
	public int size(){
		return N;
	}
	
	public boolean less(int i,int j){
		return pq[i].compareTo(pq[j]) < 0;
	}
	
	public void exch(int i,int j){
		key t = pq[i];
		pq[i] = pq[j];
		pq[j] = t;
	}
	
	private void sink(int k){
		while(2*k <= N){
			int j = 2 * k;
			if(j < N && less(j,j+1)) j++;
			if(!less(k,j)) break;
			exch(k,j);
			k = j;
		}
	}
	
	private void swim(int k){
		while(k > 1 && less(k/2,k)){
			exch(k/2,k);
			k = k/2;
		}
	}
	
	public void insert(key v){
		pq[++N] = v;
		swim(N);
	}
	
	public key delMax(){
		key max = pq[1]; //从根节点得到最大元素
		exch(1,N--);  //将其和最后一个结点交换
		pq[N+1] = null;
		sink(1);
		return max;
	}
	
	
}
