package pers.aron;

public class Insertion extends Sort{

	@Override
	public void sort(Comparable[] a){
		//将a[]按升序排列
		int N = a.length;
		for(int i = 1;i < N;i++){
			//将a[i]插入到a[i-1],a[i-2]...之中
			for(int j = i;j > 0 && less(a[j],a[j-1]);j--){
				exch(a,j,j-1);
			}
		}
	}
	
	public static void main(String[] args){
		Sort selection = new Selection();
		generate(100000);
		printTime(selection);
		isSorted();
	}
}
