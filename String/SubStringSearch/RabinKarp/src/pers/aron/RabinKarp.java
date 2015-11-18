package pers.aron;

public class RabinKarp {

	private String pat; //ģʽ�ַ���(����˹ά��˹�㷨��Ҫ)
	private long patHash; //ģʽ�ַ�����ɢ��ֵ
	private int M;  //ģʽ�ַ����ĳ���
	private long Q = Long.MAX_VALUE; //һ���ܴ������(������ʱ������������Ժ�����)
	private int R = 256; //��ĸ��Ĵ�С
	private long RM; //R^(M-1)%Q
	
	public RabinKarp(String pat){
		this.pat = pat; //����ģʽ�ַ���(����˹ά��˹�㷨��Ҫ)
		this.M = pat.length();
		RM = 1;
		for(int i = 1;i <= M-1;i++)  //����R^(M-1)%Q
			RM = (R*RM)%Q;          //���ڼ�ȥ��һ������ʱ�ļ���
		patHash = hash(pat,M);
	}
	
	public boolean check(int i){ //���ؿ����㷨
		return true;        //������˹ά��˹�㷨������㷨��txt(i..i-M+1)��ƥ��
	}
	//Horner���������ڳ�������������ɢ��ֵ
	private long hash(String key,int M){
		//����key[0..M-1]��ɢ��ֵ
		long h = 0;
		for(int j = 0;j < M;j++)
			h = (R*h + key.charAt(j))%Q;
		return h;
	}
	
	public int search(String txt){
		//���ı��в�����ȵ�ɢ��ֵ
		int N = txt.length();
		long txtHash = hash(txt,M);
		if(patHash == txtHash&&check(0)) return 0; //һ��ʼ��ƥ��ɹ�
		for(int i = M; i < N;i++){
			//��ȥ��һ�����֣��������һ�����֣��ٴμ��ƥ��
			txtHash = (txtHash + Q -RM * txt.charAt(i-M)%Q)%Q;
			txtHash = (txtHash*R + txt.charAt(i)) % Q;
			if(patHash == txtHash)
				if(check(i - M + 1)) return i - M + 1; //�ҵ�ƥ��
		}
		return N;         //δ�ҵ�ƥ��
	}
}
