package pers.aron;

public class Insertion{
	public static Comparable[] a;
	
	public static boolean less(String v,String w,int d){
		return v.substring(d).compareTo(w.substring(d)) < 0;
	}
	
	public static void exch(String[] a,int i,int j){
		String t = a[i];
		a[i] = a[j];
		a[j] = t;
	}
	
	public static void sort(String[] a,int lo,int hi,int d){
		//对前d个字符排序，从a[lo]到a[hi]
		for(int i = lo;i <= hi;i++){
			for(int j=i;j>lo&&less(a[j],a[j-1],d);j--){
				exch(a,j,j-1);
			}
		}
	
	}
	
}
