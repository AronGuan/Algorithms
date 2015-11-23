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
	
	//����v�Ķ���
	public static int degree(Graph G,int v){
		int degree = 0;
		for(int w:G.adj(v)) degree++;
		return degree;
	}
	
	//�������ж����������
	public static int maxDegree(Graph G){
		int max = 0;
		for(int v = 0; v < G.V();v++){
			if(degree(G,v)>max){
				max = degree(G,v);
			}
		}
		return max;
	}
	
	//�������ж����ƽ������
	public static double avgDegree(Graph G){
		return 2 * G.E()/G.V();
	}
	
	//�����Ի��ĸ���
	public static int numberOfSelfLoops(Graph G){
		int count = 0;
		for(int v = 0; v < G.V();v++)
			for(int w:G.adj(v))
				if(v == w) count++;
		return count/2;  //ÿ���߶����ǹ�����	
	}
	//ͼ���ڽӱ���ַ�����ʾ
	public String toString(){
		String s = V + " vertices, " + E + " edges\n";
		for(int v = 0;v < V;v++){
			s += v + ": ";
			for(int w:this.adj(v))
				s +=w + " ";
			s += "\n";
		}
		return s;
	}
}
