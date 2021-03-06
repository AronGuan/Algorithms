#单词查找树  
性质  
是由链接的结点所组成的数据结构，这些链接可能为空，也可能指向其他结点，每个结点都只可能有一个指向它的结点，称为父结点(根结点除外)，每个结点都含有R条链接，其中R为字母表的大小。另外，值为空的结点在符号表中没有对应的键，它们的存在是为了简化单词查找树中的查找操作。  

查找  
从根结点开始，首先经过的是键的首字母所对应的链接:在下一个结点中沿着第二个字符所对应的链接继续前进，在第二个结点中沿着第三个字符所对应的链接向前，直到到达键的最后一个字母所指向的结点或是遇到了一条空链接。  
1. 键的尾字符所对应的结点的值非空，命中查找  
2. 键的尾字符所对应的结点中的值为空，未命中查找 
3. 查找结束与一条空链接，未命中查找  

插入  
插入之前要进行一次查找，两种情况  
1. 在到达键的尾字符之前就遇到了一个空链接，需要为键中还未被检查的每个字符创建一个对应的结点并将键的值保存到最后一个字符的结点中。  
2. 在遇到空链接之前就到达了键的尾字符。将该结点的值设为键所对应的值。  


结点的表示  
1. 每个结点都含有R个链接，对应着每个可能出现的字符。  
2. 字符和键均隐式地保存在数据结构中(因为可以通过索引来确认键)  

1. 查找所有键(keys()和keysWithPrefix()方法)  
通过递归方法collect()来完成这个任务，维护了一个字符串用来保存从根结点出发的路径上的一系列字符，第一个参数就是该结点，方法的第一个参数就是该结点，第二个参数则是和该结点相关联的字符串(从根结点到该结点的路径上的所有字符)。  
方式：在访问一个结点时，如果它的值非空，就将和它相关联的字符串加入队列中，然后(递归地)访问它的链接数组所指向的所有可能的字符结点。  
keys()方法:可以以空字符串作为参数调用keyWithPrefix()方法。
keysWithPrefix()：先调用get()找出给定前缀所对应的单词查找树(如果不存在则返回null),在使用collect()方法完成任务。  

2. 通配符匹配  
如果模式中含有通配符，就需要递归调用处理所有的链接，否则就只需要处理模式中指定字符的链接即可。  

3. 最长前缀  
记录查找路径上所找到的最长键的长度(将它作为递归方法的参数在遇到值非空的结点时更新它)，在被查找的字符串或遇到空链接时结束。  

删除操作  
找到键所对应的结点并将它的值设为空，如果该结点含有一个非空的链接指向某个子结点，那么就需要从数据结构中删除这个结点，如果删去它使得它的父结点的所有链接均为空，就需要继续删除它的父节点。  

特点：单词查找树的链表结构和键的插入或删除顺序无关:对于任意给定的一组键，其单词查找树都是唯一的。  
性能:查找一个键或是插入一个键时，访问数组的次数最多的键的长度加1。  

缺点: 空间消耗大  
键较短时，链接总数接近于RN。  
键较长时，链接总数接近于RNw。

