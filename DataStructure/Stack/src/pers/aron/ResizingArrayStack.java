package pers.aron;

import java.util.Iterator;

//下压栈(能够动态调整数组大小的实现)
@SuppressWarnings("unchecked")
public class ResizingArrayStack<Item> implements Iterable<Item>{

	private Item[] a = (Item[])new Object[1]; //栈元素
	
	private int N = 0; //元素数量
	
	public boolean isEmpty(){
		return  N == 0;
	}
	
	public int size(){
		return N;
	}
	
	private void resize(int max){
		Item[] temp = (Item[])new Object[max];
		for(int i = 0; i< N;i++){
			temp[i]  = a[i];
			a = temp;
		}
	}
	
	public void push(Item item){
		if(N == a.length) resize(2 * a.length);
		a[N++] = item;
	}
	
	public Item pop(){
		Item item = a[--N];
		a[N] = null;
		if(N > 0 && N == a.length/4) resize(a.length/2);
		return item;
	}

	
	@Override
	public Iterator<Item> iterator() {
		return new ReverseArrayIterator();
	}
	
	private class ReverseArrayIterator implements Iterator<Item>{
		//支持先进先出的迭代
		private int i = 0;

		@Override
		public boolean hasNext() {
			return i > 0;
		}

		@Override
		public Item next() {
			return a[--i];
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException();
		}
		
		
	}

}
