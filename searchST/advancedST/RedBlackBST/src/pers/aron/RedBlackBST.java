package pers.aron;

public class RedBlackBST<Key extends Comparable<Key>,Value> {

	private Node root;
	private static final boolean RED = true;
	private static final boolean BLACK = false;
	private class Node{
		Key key; //键
		Value val; //相关联的值
		Node left,right; //左右子树
		int N;  //这颗子树种的结点总数
		boolean color;  //由其父结点指向它的链接的角色
			
		Node(Key key,Value val,int N,boolean color){
			this.key = key;
			this.val = val;
			this.N = N;
			this.color = color;
		}
	}
	
	private boolean isRed(Node x){
		if(x == null) return false;
		return x.color == RED;
	}
	
    private	Node rotateLeft(Node h){
		Node x = h.right;
		h.right = x.left;
		x.left = h;
		x.color = h.color;
		h.color = RED;
		x.N = h.N;
		h.N = 1 + size(h.left) + size(h.right);
		return x;
	}
	
	private Node rotateRight(Node h){
		Node x = h.left;
		h.left = x.right;
		x.right = h;
		x.color = h.color;
		h.color = RED;
		x.N = h.N;
		h.N = 1 + size(h.left) + size(h.right);
		return x;
	}
	
	private void flipColors(Node h){
		h.color = RED;
		h.left.color = BLACK;
		h.right.color = BLACK;
	}
	
	public int size(){
		return size(root);
	}
	
	private int size(Node x){
		if(x == null) return 0;
		else return x.N;
	}
	
	public Value get(Key key){
		return get(root,key);
	}
	
	private Value get(Node x,Key key){
		//在以x为根节点的子树中查找并返回key所对应的值
		//如果找不到则返回null
		if(x == null) return null;
		int cmp = key.compareTo(x.key);
		if(cmp < 0) return get(x.left,key);
		else if(cmp > 0) return get(x.right,key);
		else return x.val;
	}
	
	public void put(Key key,Value val){
		//查找key,找到则更新它的值，否则为它创建一个新的结点
		root = put(root,key,val);
		root.color = BLACK;
	}
	
	private Node put(Node h,Key key,Value val){
		if(h == null) //标准的插入操作，和父结点用红链接相连
			return new Node(key,val,1,RED);
		int cmp = key.compareTo(h.key);
		if(cmp < 0) h.left = put(h.left,key,val);
		else if(cmp > 0) h.right = put(h.right,key,val);
		else h.val = val;
		
		if(isRed(h.right)&&!isRed(h.left)) h = rotateLeft(h);
		if(isRed(h.left)&&isRed(h.left.left)) h = rotateRight(h);
		if(isRed(h.left)&& isRed(h.right)) flipColors(h);
		
		h.N = size(h.left) + size(h.right) + 1;
		return h;
	}
	
	//有序性相关的方法与删除操作
	public Key min(){
		return min(root).key;
	}
	private Node min(Node x){
		if(x.left == null) return x;
		return min(x.left);
	}
	public Key max(){
		return max(root).key;
	}
	private Node max(Node x){
		if(x.right == null) return x;
		return max(x.right);
	}
	
	public Key floor(Key key){
		Node x = floor(root,key);
		if(x == null) return null;
		return x.key;
	}
	
	private Node floor(Node x,Key key){
		if(x == null) return null;
		int cmp = key.compareTo(x.key);
		if(cmp == 0) return x;
		if(cmp < 0) return floor(x.left,key);
		Node t = floor(x.right,key);
		if(t != null) return t;
		else return x;
	}
	
	//选择和排名
	public Key select(int k){
		return select(root,k).key;
	}
	
	private Node select(Node x,int k){
		//返回排名为k的结点
		if(x == null) return null;
		int t = size(x.left);
		if (t>k) return select(x.left,k);
		else if(t < k) return select(x.right,k-t-1);
		else return x;
	}
	
	public int rank(Key key){
		return rank(key,root);
	}
	private int rank(Key key,Node x){
		//返回以x为根结点的子树中小于x.key的键的数量
		if(x == null) return 0;
		int cmp = key.compareTo(x.key);
		if(cmp < 0) return rank(key,x.left);
		else if(cmp > 0) return 1 + size(x.left) + rank(key,x.right);
		else return size(x.left);
	}
	

	//范围查找
	public Iterable<Key> keys(){
		return keys(min(),max());
	}
	
	public Iterable<Key> keys(Key lo,Key hi){
		Queue<Key> queue = new Queue<Key>();
		keys(root,queue,lo,hi);
		return queue;
	}
	private void keys(Node x,Queue<Key> queue,Key lo,Key hi){
		if(x == null) return;
		int cmplo = lo.compareTo(x.key);
		int cmphi = hi.compareTo(x.key);
		if(cmplo < 0) keys(x.left,queue,lo,hi);
		if(cmplo <= 0 && cmphi >= 0) queue.enqueue(x.key);
		if(cmphi > 0) keys(x.right,queue,lo,hi);
	}
	
}
