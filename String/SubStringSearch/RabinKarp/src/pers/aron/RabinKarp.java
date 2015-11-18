package pers.aron;

public class RabinKarp {

	private String pat; //模式字符串(仅拉斯维加斯算法需要)
	private long patHash; //模式字符串的散列值
	private int M;  //模式字符串的长度
	private long Q = Long.MAX_VALUE; //一个很大的素数(这里暂时用这个来处理，以后来补)
	private int R = 256; //字母表的大小
	private long RM; //R^(M-1)%Q
	
	public RabinKarp(String pat){
		this.pat = pat; //保存模式字符串(仅拉斯维加斯算法需要)
		this.M = pat.length();
		RM = 1;
		for(int i = 1;i <= M-1;i++)  //计算R^(M-1)%Q
			RM = (R*RM)%Q;          //用于减去第一个数字时的计算
		patHash = hash(pat,M);
	}
	
	public boolean check(int i){ //蒙特卡洛算法
		return true;        //对于拉斯维加斯算法，检查算法与txt(i..i-M+1)的匹配
	}
	//Horner方法，用于除留余数法计算散列值
	private long hash(String key,int M){
		//计算key[0..M-1]的散列值
		long h = 0;
		for(int j = 0;j < M;j++)
			h = (R*h + key.charAt(j))%Q;
		return h;
	}
	
	public int search(String txt){
		//在文本中查找相等的散列值
		int N = txt.length();
		long txtHash = hash(txt,M);
		if(patHash == txtHash&&check(0)) return 0; //一开始就匹配成功
		for(int i = M; i < N;i++){
			//减去第一个数字，加上最后一个数字，再次检查匹配
			txtHash = (txtHash + Q -RM * txt.charAt(i-M)%Q)%Q;
			txtHash = (txtHash*R + txt.charAt(i)) % Q;
			if(patHash == txtHash)
				if(check(i - M + 1)) return i - M + 1; //找到匹配
		}
		return N;         //未找到匹配
	}
}
