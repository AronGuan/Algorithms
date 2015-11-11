package pers.aron;
//三向字符串快速排序
public class Quick3way extends Sort{

	@Override
	public void sort(Comparable[] a){
		sort(a,0,a.length - 1);
	}
	
	private void sort(Comparable[] a,int lo,int hi){
		if(hi <= lo) return;
		int lt = lo,i = lo+1,gt = hi;
		Comparable v = a[lo];
		while(i <= gt){
			int cmp = a[i].compareTo(v);
			if(cmp < 0) exch(a,lt++,i++);
			else if(cmp > 0) exch(a,i,gt--);
			else i++;
		}//现在a[lo..lt-1]<v=a[lt..gt]<a[gt+1..hi]成立
		sort(a,lo,lt-1);
		sort(a,gt+1,hi);
	}
}
