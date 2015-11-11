package pers.aron;

//�Զ����µķ�ʽ
public class Merge extends Sort{

	private static Comparable[] aux;
	
	public static void merge(Comparable[] a,int lo,int mid,int hi){
		//��a[lo...mid]��a[mid+1...hi]�鲢
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
		//������a[lo..hi]����
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
