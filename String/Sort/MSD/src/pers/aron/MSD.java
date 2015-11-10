package pers.aron;
//��λ���ȵ��ַ�������
public class MSD {
	private static int R = 256;  //����(�������Ϊ�����ַ��ĸ���)
	private static final int M =15;  //С������л���ֵ
	private static String[] aux;  //���ݷ���ĸ�������
	private static int charAt(String s,int d){
		if(d < s.length())
			return s.charAt(d);
		else
			return -1;
	}
	
	public static void sort(String[] a){
		int N = a.length;
		aux = new String[N];
		sort(a,0,N-1,0);
	}
	
	private static void sort(String[] a,int lo,int hi,int d){
		//�Ե�d���ַ�Ϊ����a[lo]��a[hi]����
		if(hi <= lo + M){
			Insertion.sort(a,lo,hi,d);
			return;
		}
		
		int[] count = new int[R+2];  //����Ƶ��
		for(int i = lo;i <= hi;i++)
			count[charAt(a[i],d)+2]++;
		
		for(int r = 0;r < R+1;r++){  //��Ƶ��ת��Ϊ����
			count[r+1] += count[r];
		}
		
		for(int i=lo;i <= hi;i++){  //���ݷ���
			aux[count[charAt(a[i],d)+1]++]=a[i];
		}
		
		for(int i = lo;i <= hi; i++){  //��д
			a[i] = aux[i-lo];
		}
		
		//�ݹ����ÿ���ַ�Ϊ����������
		for(int r = 0;r < R;r++){
			sort(a,lo+count[r],lo+count[r+1] - 1,d+1);
		}
	}
}
