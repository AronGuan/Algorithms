package pers.aron;

public class Selection extends Sort{

	@Override
	public void sort(Comparable[] a){
		//��a[]����������
		int N = a.length;
		for(int i =0; i < N;i++){
			//��a[i]��a[i+1..N]����С��Ԫ�ؽ���
			int min = i;
			for(int j = i + 1;j < N;j++){
				if(less(a[j],a[min])) min = j;
			}
			exch(a,i,min);
		}
	}
	
	public static void main(String[] args){
		Sort selection = new Selection();
		generate(1000);
		printTime(selection);
		isSorted();
	}
}
