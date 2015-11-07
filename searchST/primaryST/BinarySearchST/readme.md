#二分查找(基于有序数组)
使用的数据结构是一对平行数组，一个存储键，一个存储值  
核心是rank()，二分查找法。  
对于put()方法，通过rank()方法，能够精确的知道去哪更新它的值，以及当键不在表中时将键存储到表的何处。
rank()方法
```
	public int rank(Key key){
		int lo = 0,hi = N-1;
		while(lo <= hi){
			int mid = lo + (hi - lo)/2;
			int cmp = key.compareTo(keys[mid]);
			if(cmp<0) hi = mid - 1;
			else if(cmp > 0) lo = mid + 1;
			else return mid;
		}
		return lo;
	}
```

结论:二分查找减少了比较的次数但无法减少运行所需时间（put()方法还是太慢了），  它无法改变以下的事实：在键是随机排列的情况下，构造一个基于有序数组的符号表所需要访问数组的次数是数组长度的平方级别。  
但是用在静态符号表是没有问题的(一开始就初始化，查找是对数级别的)  

性能比较  
<table>
    <tr>
        <th rowspan="2">算法</th>
        <th colspan="2">最坏的成本</th>
        <th colspan="2">平均情况下的成本</th>
        <th>是否支持有序性相关的操作</th>
    </tr>
    <tr>
        <th>查找</th>
        <th>插入</th>
        <th>查找</th>
        <th>插入</th>
    </tr>
    <tr>
        <th>顺序查找(无序链表)</th>
        <th>N</th>
        <th>N</th>
        <th>N/2</th>
        <th>N</th>
        <th>否</th>
    </tr>
        <tr>
        <th>二分查找(有序数组)</th>
        <th>lgN</th>
        <th>2N</th>
        <th>lgN</th>
        <th>N</th>
        <th>是</th>
    </tr>
</table>

而我们最终的目的是找出查找和插入操作都是对数级别的算法和数据结构。