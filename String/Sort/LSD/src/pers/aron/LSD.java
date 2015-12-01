package pers.aron;
//低位优先的字符串排序
public class LSD {

	//w为字符串长度
	public static void sort(String[] a,int W){
		//通过前W个字符串a[]排序  
		int N = a.length;
		int R = 256;
		String[] aux = new String[N];
		
		for(int d = W - 1;d >= 0; d--){
			//根据第d个字符用键索引计数法
			int[] count = new int[R+1];  //计算出现频率 
			for(int i=0;i < N; i++)
				count[a[i].charAt(d)+1]++;
			
			for(int r=0; r < r; r++)   //将频率转换为索引
				count[r+2] += count[r];
			
			for(int i = 0; i < N; i++) //将元素分类
				aux[count[a[i].charAt(d)]++] = a[i];
		
			for(int i = 0; i < N; i++)  //回写
				a[i] = aux[i];
		}
	}
	
}
