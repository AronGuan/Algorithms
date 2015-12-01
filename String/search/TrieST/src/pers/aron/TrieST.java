package pers.aron;
//���ʲ�����
public class TrieST<Value> {

	private static int R = 256;  //����
	private Node root; //���ʲ������ĸ����
	
	private static class Node{
		private Object val;
		private Node[] next = new Node[R];
	}
	
	public Value get(String key){
		Node x = get(root,key,0);
		if(x== null) return null;
		return (Value)x.val;
	}
	
	private Node get(Node x,String key,int d){
		//������x��Ϊ�������ӵ��ʲ���������key�������ֵ
		if(x == null) return null;
		if(d== key.length()) return x;
		char c= key.charAt(d); //�ҵ���d���ַ�����Ӧ���ӵ��ʲ�����
		return get(x.next[c],key,d+1);
	}
	
	public void put(String key,Value val){
		root = put(root,key,val,0);
	}
	
	private Node put(Node x,String key,Value val,int d){
		//���key��������xΪ�������ӵ��ʲ�����������������������ֵ
		if(x==null) x = new Node();
		if(d == key.length()){
			x.val = val;
			return x;
		}
		char c = key.charAt(d);//�ҵ���d���ַ�����Ӧ���ӵ��ʲ�����
		x.next[c] = put(x.next[c],key,val,d+1);
		return x;
	}
	//�������м�
	public Iterable<String> keys(){
		return keysWithPrefix("");
	}
	//����һ���ַ������������ط��ű��������Ը��ַ�����Ϊǰ׺�ļ�
	public Iterable<String> keysWithPrefix(String pre){
		Queue<String> q = new Queue<String>();
		collect(get(root,pre,0),pre,q);
		return q;
	}
	
	private void collect(Node x,String pre,Queue<String> q){
		if(x == null) return;
		if(x.val != null) q.enqueue(pre);
		for(char c = 0;c < R;c++){
			collect(x.next[c],pre+c,q);
		}
	}
	
	//����һ���ַ������������ط��ű��и��ַ�����ǰ׺����ļ�
	public String longestPrefixOf(String s){
		int length = search(root,s,0,0);
		return s.substring(0,length);
	}
	
	private int search(Node x,String s,int d,int length){
		if(x == null) return length;
		if(x.val != null) length = d;
		if(d == s.length()) return length;
		char c = s.charAt(d);
		return search(x.next[c],s,d+1,length);
	}
	
	
	
	//����һ���ַ������������ط��ű������к͸��ַ���ƥ���ֵ
	public Iterable<String> keysThatMatch(String pat){
		Queue<String> q = new Queue<String>();
		collect(root,"",pat,q);
		return q;
	}
	public void collect(Node x,String pre,String pat,Queue<String> q){
		int d = pre.length();
		if(x == null) return;
		if(d == pat.length()&& x.val != null) q.enqueue(pre);
		if(d == pat.length()) return;
		
		char next = pat.charAt(d);
		for(char c = 0;c < R;c++){
			if(next == '.'||next == c)
				collect(x.next[c],pre+c,pat,q);
		}
	}
	
}