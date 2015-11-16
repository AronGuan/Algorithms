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


#KMP子字符串查找算法  
基本事实：在匹配失败时总是能够将j设为某个值以使j不回避  
使用一个数组dfa[][]来记录匹配失败时模式指针应该回退多远(但实质可以理解为处理的状态，当状态数值为模式长度，即为匹配)  
特点，指针i是左向右前进的，一次一个字符，但索引j会在DFA的指导下，在模式字符串中左右移动。  

因此构造DFA
关键在于需要重新扫描文本字符正是则pat.chartAt（1）到pat.charAt(j-1)之间，对于每个可能匹配失败的位置都可以预先找到重启DFA的正确状态。  

假设完全回退之后判断会到状态几，而这个就是X值，代表前面有几个字符是匹配的，把dfa[c][x]赋给dfa[c][j]，在计算DFA的第j个状态总是只需要知道DFA是如何处理前j-1个字符。  

最后关键细节:X的下一个值是dfa[pat.charAt(j)][x]  
特点:和暴力自字符串查找算法功能相同，但适合查找自我重复的模式字符串

```
dfa[pat.charAt(0)][0] = 1;  //第一个匹配成功情况下的值
		for(int X = 0,j = 1;j < M;j++){
			//计算dfa[][j]
			for(int c = 0;c < R;c++)
				dfa[c][j] = dfa[c][X]; //复制匹配失败情况下的值
			dfa[pat.charAt(j)][j] = j + 1; //设置匹配成功情况下的值
			X = dfa[pat.charAt(j)][X];   //更新重启状态
```  
这段代码虽然很短，但是理解起来相当费劲。很多地方让人很费解。