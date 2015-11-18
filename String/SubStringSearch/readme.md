#总结  

<table>
    <tr>
        <th rowspan="2">算法</th>
        <th colspan="2">操作次数</th>
        <th rowspan="2">在文本中回退</th>
        <th rowspan="2">正确性</th>
        <th rowspan="2">额外的空间需求</th>
    </tr>
    <tr>
        <th>最坏情况</th>
        <th>一般情况</th>
    </tr>
    <tr>
        <th>暴力算法</th>
        <th>MN</th>
        <th>1.1N</th>
        <th>是</th>
        <th>是</th>
        <th>1</th>
    </tr>
    <tr>
        <th>Knuth-Morris-pratt算法</th>
        <th>2N</th>
        <th>1.1N</th>
        <th>否</th>
        <th>是</th>
        <th>MR</th>
    </tr>
    <tr>
        <th>Boyer-Moore算法</th>
        <th>MN</th>
        <th>N/M</th>
        <th>是</th>
        <th>是</th>
        <th>R</th>
    </tr>
    <tr>
        <th>Rabin-Karp算法(蒙特卡洛算法)</th>
        <th>7N</th>
        <th>7N</th>
        <th>否</th>
        <th>是(概率保证)</th>
        <th>1</th>
    </tr>
    <tr>
        <th rowspan="2">Rabin-Karp算法(拉斯维加斯算法)</th>
        <th>7N</th>
        <th>7N</th>
        <th>是</th>
        <th>是</th>
        <th>1</th>
    </tr>
</table> 
