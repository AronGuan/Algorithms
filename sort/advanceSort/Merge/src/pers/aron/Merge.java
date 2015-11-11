package pers.aron;

//自顶向下的方式
public class Merge extends Sort{

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
		aux = new Comparable[a.length];
		sort(a,0,a.length - 1);
	}
	
	private static void sort(Comparable[] a,int lo,int hi){
		//将数组a[lo..hi]排序
		if(hi <= lo) return;
		int mid = lo + (hi - lo)/2;
		sort(a,lo,mid);
		sort(a,mid + 1, hi);
		merge(a,lo,mid,hi);
	}
	
	public static void main(String[] args){
		Sort selection = new Merge();
		generate(10000000);
		printTime(selection);
		isSorted();
	}
}
