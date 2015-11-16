#子字符串查找  
首先先知道最显而易见的方法————暴力子字符串查找算法  
```
    //暴力子字符串查找
	public static int search(String pat,String txt){
		int M = pat.length();  //模式的长度
		int N = txt.length();  //文本的长度  
		for(int i=0;i<=N-M;i++){
			int j;
			for(j=0;j<M;j++){
				if(txt.charAt(i+j) != pat.charAt(j))
					break;				
			}
			if(j == M) return i; //找到匹配
		}
		return N; // 未找到匹配
	}
```  

方式:使用了一个指针i跟踪文本，一个指针j跟踪模式，对于每个i，代码首先将j重置为0,并不断将它增加，直至找到了一个不匹配的字符或是模式结束(i==M)为止，如果在模式字符串结束之前文本字符串就已经结束了(i=N-M+1),那么就没有找到匹配。  


```
	//暴力子字符匹配算法的另一种实现(显示回退)
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
		if(j == M) return i-M; //找到匹配
		else return N;  //未找到匹配
	}
```  
这里是如果i和j指向的字符不匹配，那么需要回退这两个指针的值:将j重新指向模式的开头，将i指向本次匹配的开始位置的下一个字符。