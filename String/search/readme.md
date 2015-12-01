###总结：
<table>
    <tr>
        <th rowspan="2">算法</th>
        <th colspan="2">处理由大小为R的字母表构造的N个字符串(平均长度为w)</th>
        <th rowspan="2">优点</th>
    </tr>
    <tr>
        <th>未命中查找检查的字符数量</th>
        <th>内存使用</th>
    </tr>
    <tr>
        <th>二叉树查找(BST)</th>
        <th>$c(lgN)^2$</th>
        <th>64N</th>
        <th>适用于随机排列的键</th>
    </tr>
    <tr>
        <th>2-3树查找(红黑树)</th>
        <th>$c(lgN)^2$</th>
        <th>64N</th>
        <th>有性能保证</th>
    </tr>
    <tr>
        <th>线性探测法(并行数组)</th>
        <th>w</th>
        <th>32N~128N</th>
        <th>内置类型，缓存散列值</th>
    </tr>
    <tr>
        <th>字典树查找(R向单词查找树)</th>
        <th>$log_RN$</th>
        <th>(8R+56)N~(8R+56)Nw</th>
        <th>适用于较短的键和较小的字母表</th>
    </tr>
    <tr>
        <th>字典树查找(三向单词查找树)/th>
        <th>$1.39lgN$</th>
        <th>64N~64Nw</th>
        <th>适用于非随机的键</th>
    </tr>
</table> 

