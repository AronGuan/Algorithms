package pers.aron;

//�Զ����µķ�ʽ
public class Quick extends Sort{

	public int partition(Comparable[] a,int lo,int hi){
		//�������з�Ϊa[lo...i-1],a[i],a[i+1..hi]
		int i = lo, j = hi + 1;
		Comparable v = a[lo];  //�з�Ԫ��
		while(true){
			//ɨ�����ң����ɨ���Ƿ����������Ԫ��
			while(less(a[++i],v)) if(i == hi) break;
			while(less(v,a[--j])) if(j == lo) break;
			if(i >= j) break;
			exch(a,i,j);
		}
		exch(a,lo,j);  //��v=a[j	]������ȷ��λ��
		return j;    //a[lo...j-1]<=a[j]<=a[j+1...hi]���
	}
	
	public void sort(Comparable[] a){
		sort(a,0,a.length - 1);
	}
	
	private void sort(Comparable[] a,int lo,int hi){
		if(hi <= lo) return;
		int j = partition(a,lo,hi);//�з�
		sort(a,lo,j-1); //����벿��a[lo...j-1]����
		sort(a,j+1,hi); //���Ұ벿��a[j+1...hi]����
	}
	
	public static void main(String[] args){
		Sort quick = new Quick();
		generate(10000000);
		printTime(quick);
		isSorted();
	}
}
