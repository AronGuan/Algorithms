#���ַ�������  
������֪�����Զ��׼��ķ������������������ַ��������㷨  
```
    //�������ַ�������
	public static int search(String pat,String txt){
		int M = pat.length();  //ģʽ�ĳ���
		int N = txt.length();  //�ı��ĳ���  
		for(int i=0;i<=N-M;i++){
			int j;
			for(j=0;j<M;j++){
				if(txt.charAt(i+j) != pat.charAt(j))
					break;				
			}
			if(j == M) return i; //�ҵ�ƥ��
		}
		return N; // δ�ҵ�ƥ��
	}
```  

��ʽ:ʹ����һ��ָ��i�����ı���һ��ָ��j����ģʽ������ÿ��i���������Ƚ�j����Ϊ0,�����Ͻ������ӣ�ֱ���ҵ���һ����ƥ����ַ�����ģʽ����(i==M)Ϊֹ�������ģʽ�ַ�������֮ǰ�ı��ַ������Ѿ�������(i=N-M+1),��ô��û���ҵ�ƥ�䡣  


```
	//�������ַ�ƥ���㷨����һ��ʵ��(��ʾ����)
	public static int search(String pat,String txt){
		int j,M = pat.length();
		int i,N = txt.length();
		for(i = 0,j = 0;i < N&&j < M;i++){
			if(txt.charAt(i) == pat.charAt(j)) j++;
			else{
				i -=j;
				j = 0;
			}
		}
		if(j == M) return i-M; //�ҵ�ƥ��
		else return N;  //δ�ҵ�ƥ��
	}
```  
���������i��jָ����ַ���ƥ�䣬��ô��Ҫ����������ָ���ֵ:��j����ָ��ģʽ�Ŀ�ͷ����iָ�򱾴�ƥ��Ŀ�ʼλ�õ���һ���ַ���