#散列表  
##前言  
使用散列表查找算法分为两步  
1. 是用散列函数将被查找的键转化为数组的一个索引  
2. 处理碰撞冲突的过程  

散列表是算法在时间和空间上做出权衡的经典例子。  

1. 第一个问题是散列表函数的计算,将键转化为数组的索引  
对于数组，将默认的hashCOde()方法和除留余数结合起来产生一个0到M-1的整数  
```
	private int hash(Key key){
		return (key.hashCode()&0x7fffffff)%M;
	}
```
M取素数，来充分利用原散列值得所有位  

对于自定义的类型  
```
	private final String who;
	private final Date when;
	private final double amount;
	
	public int hashCode(){
		int hash = 17;
		hash = 31 * hash + who.hashCode();
		hash = 31 * hash + when.hashCode();
		hash = 31 * hash + ((Double)amount).hashCode();
		return hash;
	}
```  
对于java中的String,Integer,Double,File和URL对象的hashCode()都可以均等分配到数组索引当中  

2. 第二步,碰撞处理，处理两个或多个键的散列值相同的情况  
(1) 基于拉链法的散列表
(2) 基于线性探测的符号表  


##基于拉链法的散列表  
思路:将大小为M的数组中的每个元素指向一条链表，链表中的每个结点都存储了散列值为该元素的索引的键值对。   

查找:  
首先根据散列值找到对应的链表，然后沿着链表顺序查找相应的键。  

性质:在一张含有M条链表和N个键的散列表中，未命中查找和插入操作所需要的比较次数为N/M。

