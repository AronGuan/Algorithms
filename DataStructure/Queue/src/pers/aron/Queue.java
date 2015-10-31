package pers.aron;

import java.util.Iterator;


public class Queue<Item> implements Iterable<Item>{

	private Node first;
	private Node last;
	private int N;
	public class Node{
		Item item;
		Node next;
	}
	public boolean isEmpty(){
		return first  == null;
	}
	public int size(){
		return N;
	}
	public void enqueue(Item item){
		//向表尾添加元素
		Node oldfirst = last;
		last = new Node();
		last.item = item;
		last.next = null;
		if(isEmpty()) first = last;
		else oldfirst.next = last;
		N++;
	}
	
	public Item dequeue(){
		//从表头删除元素
		Item item = first.item;
		first = first.next;
		if(isEmpty()) last = null;
		N--;
		return item;
	}
	
	@Override
	public Iterator<Item> iterator() {
		return new ListIterator();
	}
	
	private class ListIterator implements Iterator<Item>{

		private Node current = first;
		@Override
		public boolean hasNext() {
			return current != null;
		}

		@Override
		public Item next() {
			Item item = current.item;
			current = current.next;
			return item;
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException();
		}
		
	}
	
}
