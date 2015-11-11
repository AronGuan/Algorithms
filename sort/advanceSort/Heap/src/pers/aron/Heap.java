package pers.aron;

import java.util.Random;

public class Heap extends Sort{

	public boolean less(int i,int j){
		return a[i].compareTo(a[j]) < 0;
	}
	
	@Override
	public void generate(int number){
		Random random = new Random(7);
		a = new Integer[number+1];
		for(int i = 1;i<number+1;i++){
			a[i] = random.nextInt();
		}
	}
	
	private void sink(Comparable[] a,int k,int N){
		while(2*k <= N){
			int j = 2 * k;
			if(j < N && less(j,j+1)) j++;
			if(!less(k,j)) break;
			exch(a,k,j);
			k = j;
		}
	}

	
	@Override
	public void sort(Comparable[] a){
		int N = a.length - 1;
		for(int k = N/2;k >= 1;k--){
			sink(a,k,N);
		}
		while(N > 1){
			exch(a,1,N--);
			sink(a,1,N);
		}
	}
	
	public static void main(String[] args){
		Sort heap = new Heap();
		heap.generate(10000000);
		printTime(heap);
		isSorted();
	}
}
