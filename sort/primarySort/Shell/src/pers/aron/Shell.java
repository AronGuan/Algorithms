package pers.aron;

public class Shell extends Sort{

	@Override
	public void sort(Comparable[] a){
		//��a[]����������
		int N = a.length;
		int h = 1;
		while(h < N/3) h = 3 * h + 1;//1,4,13,40,121,364,1093
		while(h >= 1){
			//�������Ϊh����
			for(int i = h; i < N;i++){
				//��a[i]���뵽a[i-h],a[i-2*h],a[i-3*h]...֮��
				for(int j = i;j >= h && less(a[j],a[j-h]);j-=h){
					exch(a,j,j-h);
				}
			}
			h = h/3;
		}
	}
	
	public static void main(String[] args){
		Sort selection = new Shell();
		generate(1000000);
		printTime(selection);
		isSorted();
	}
}
