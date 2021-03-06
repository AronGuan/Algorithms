LSD:低位优先的字符串排序  
MSD:高位优先的字符串排序  
Quick3string:三向切分的快速排序

###总结：
<table>
    <tr>
        <th>算法</th>
        <th>是否稳定</th>
        <th>是否为原地排序</th>
        <th>运行时间</th>
        <th>额外空间</th>
        <th>优势领域</th>
    </tr>
    <tr>
        <th>字符串的插入排序</th>
        <th>是</th>
        <th>是</th>
        <th>N到$N^2$</th>
        <th>1</th>
        <th>小数组或是已经有序的数组</th>
    </tr>
    <tr>
        <th>快速排序</th>
        <th>否</th>
        <th>是</th>
        <th>$NlogN$</th>
        <th>lgN</th>
        <th>通用排序算法，特别适合用于空间不足的情况</th>
    </tr>
    <tr>
        <th>归并排序</th>
        <th>是</th>
        <th>否</th>
        <th>NlogN</th>
        <th>N</th>
        <th>稳定的通用排序算法</th>
    </tr>
    <tr>
        <th>三向快速排序</th>
        <th>否</th>
        <th>是</th>
        <th>介于N和NlogN之间</th>
        <th>lgN</th>
        <th>大量重复键</th>
    </tr>
    <tr>
        <th>低位优先的字符串排序</th>
        <th>是</th>
        <th>否</th>
        <th>NW</th>
        <th>N</th>
        <th>较短的定长字符串</th>
    </tr>
    <tr>
        <th>高位优先的字符串排序</th>
        <th>是</th>
        <th>否</th>
        <th>N到NW之间</th>
        <th>N+WR</th>
        <th>随机字符串</th>
    </tr>
    <tr>
        <th>三向字符串快速排序</th>
        <th>否</th>
        <th>是</th>
        <th>N到NW之间</th>
        <th>W+logN</th>
        <th>通用排序算法，特别适合用于含有较长公共前缀的字符串</th>
    </tr>
</table> 






