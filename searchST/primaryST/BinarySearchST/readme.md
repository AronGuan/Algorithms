#���ֲ���(������������)
ʹ�õ����ݽṹ��һ��ƽ�����飬һ���洢����һ���洢ֵ  
������rank()�����ֲ��ҷ���  
����put()������ͨ��rank()�������ܹ���ȷ��֪��ȥ�ĸ�������ֵ���Լ��������ڱ���ʱ�����洢�����ĺδ���
rank()����
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

����:���ֲ��Ҽ����˱ȽϵĴ������޷�������������ʱ�䣨put()��������̫���ˣ���  ���޷��ı����µ���ʵ���ڼ���������е�����£�����һ��������������ķ��ű�����Ҫ��������Ĵ��������鳤�ȵ�ƽ������  
�������ھ�̬���ű���û�������(һ��ʼ�ͳ�ʼ���������Ƕ��������)  

���ܱȽ�  
<table>
    <tr>
        <th rowspan="2">�㷨</th>
        <th colspan="2">��ĳɱ�</th>
        <th colspan="2">ƽ������µĳɱ�</th>
        <th>�Ƿ�֧����������صĲ���</th>
    </tr>
    <tr>
        <th>����</th>
        <th>����</th>
        <th>����</th>
        <th>����</th>
    </tr>
    <tr>
        <th>˳�����(��������)</th>
        <th>N</th>
        <th>N</th>
        <th>N/2</th>
        <th>N</th>
        <th>��</th>
    </tr>
        <tr>
        <th>���ֲ���(��������)</th>
        <th>lgN</th>
        <th>2N</th>
        <th>lgN</th>
        <th>N</th>
        <th>��</th>
    </tr>
</table>

���������յ�Ŀ�����ҳ����ҺͲ���������Ƕ���������㷨�����ݽṹ��