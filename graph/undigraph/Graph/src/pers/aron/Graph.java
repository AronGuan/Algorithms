package pers.aron;

public class Graph {

	private final int V;  //������Ŀ
	private int E; //�ߵ���Ŀ
	private Bag<Integer>[] adj;  //�ڽӱ�
	
	public Graph(int V){
		this.V = V;
		this.E = 0;
		adj = (Bag<Integer>[]) new Bag[V];  //�����ڽӱ�
		for(int v = 0; v < V; v++){  		//�����������ʼ��Ϊ��
			adj[v] = new Bag<Integer>(); 
		}
	}
	
	public Graph(In in){  //In
		this(in.readInt());  //��ȡV����ͼ��ʼ��
		int E = in.readInt();  //��ȡE
		for(int i = 0;i < E;i++){
			//���һ����
			int v = in.readInt();  //��ȡһ������
			int w = in.readInt(); //��ȡ��һ������
			addEdge(v,w);
		}
	}
	
	public int V(){
		return V;
	}
	public int E(){
		return E;
	}
	
	public void addEdge(int v,int w){
		adj[v].add(w);
		adj[w].add(v);
		E++;
	}
	public Iterable<Integer> adj(int v){
		return adj[v];
	}
}
