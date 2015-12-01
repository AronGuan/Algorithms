#高位优先的字符串排序(MSD)  
通用的字符串排序(字符串不一样)  
思路:用键索引计数法将所有字符串按照首字母排序，然后(递归地)在将每个首字母所对应的子数组排序(在子数组中，忽略首字母，因为每一类中的所有字符串的首字母都是相同的)  

toChar()来将字符索引转化为数组索引，末尾返回-1，所以产生R+1个不同的值(那多的一个是为末尾)，并且索引计数法本来需要额外一个位置，所以  
```
int[] count = new int[R+2];  //计算频率
		for(int i = lo;i <= hi;i++)
			count[charAt(a[i],d)+2]++;
```  
注意点：  
小型子数组对于高位优先的字符串排序的性能至关重要，所以在长度小于等于10时切换到插入排序。  

性能:N到NW之间(N:字符串个数，W:字符串平均长度)

最坏的情况:键可能存在较长的公共部分，或者部分键的取值范围有限。  
为了解决这个问题-------接下来就是三向字符串快速排序。