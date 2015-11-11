package pers.aron;

public class Quick3string {

	private static void exch(String[] a,int i,int j){
		String t = a[i];
		a[i] = a[j];
		a[j] = t;
	}
	private static int charAt(String s,int d){
		if(d < s.length())
			return s.charAt(d);
		else return -1;
	}
	
	private static void sort(String[] a,int lo,int hi,int d){
		if(hi <= lo) return;
		int lt = lo,gt = hi;
		int v = charAt(a[lo],d);
		int i = lo + 1;
		while(i <= gt){
			int t = charAt(a[i],d);
			if (t < v) exch(a,lt++,i++);
			else if(t > v) exch(a,i,gt--);
			else i++;
		}
		//首字母小于切分字符的字符串子数组
		sort(a,lo,lt-1,d); 
		//首字母等于切分字符的字符串的子数组(排序时忽略它们的首字母)
		if(v >= 0) sort(a,lt,gt,d+1); 
		//首字母大于切分字符的字符串的子数组
		sort(a,gt+1,hi,d);
	}
}
