package pers.aron;

import java.util.Iterator;

public class Bag<Item> implements Iterable<Item>{

	private Node first; //链表的首结点
	private class Node{
		Item item;
		Node next;
	}
	public void add(Item item){
		//和Stack的push()方法完全相同
		Node oldfirst = first;
		first = new Node();
		first.item = item;
		first.next = oldfirst;
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
