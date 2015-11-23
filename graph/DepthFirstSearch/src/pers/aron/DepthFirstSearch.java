package pers.aron;

//深度优先搜索
public class DepthFirstSearch {

	private boolean[] marded;
	private int count;
	
	public DepthFirstSearch(Graph G,int s){
		marded = new boolean[G.V()];
		dfs(G,s);
	}
	
	private void dfs(Graph G,int v){
		marded[v] = true;
		count++;
		for(int w:G.adj(v))
			if(!marded[w]) dfs(G,w);
	}
	
	public boolean marked(int w){
		return marded[w];
	}
	
	public int count(){
		return count;
	}
	
}
