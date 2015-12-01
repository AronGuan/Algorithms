package pers.aron;

//自顶向下的方式
public class MergeBu extends Sort{

	private static Comparable[] aux;
	
	public static void merge(Comparable[] a,int lo,int mid,int hi){
		//将a[lo...mid]和a[mid+1...hi]归并
		int i = lo,j = mid + 1;
		for(int k = lo; k <= hi; k++){
			aux[k] = a[k];
		}
		for(int k = lo;k <= hi;k++){
			if(i>mid)                    a[k] = aux[j++];
			else if(j > hi)              a[k] = aux[i++];
			else if(less(aux[j],aux[i])) a[k] = aux[j++];
			else                         a[k] = aux[i++];
		}
	}
	
	@Override
	public void sort(Comparable[] a){
		//进行lgN次两两归并
		
		int N = a.length;
		aux = new Comparable[a.length];
		for(int sz = 1; sz < N; sz = sz + sz){
			for(int lo = 0; lo < N - sz;lo += sz + sz){
				merge(a,lo,lo+sz-1,Math.min(lo+sz+sz-1, N-1));
			}
		}
	}
	

	
	public static void main(String[] args){
		Sort selection = new MergeBu();
		generate(10000000);
		printTime(selection);
		isSorted();
	}
}
