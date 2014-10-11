package com.tanghao.algo.study.datastructure.linklist;

import java.util.Iterator;

public class Bag<E> implements IMyList<E>, Iterable<E> {

	private Node<E> first;
	private int size;
	private static class Node<E>{
		public Node(E element){
			this.element = element;
		}
		E element;
		Node<E> next;
	}

	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return new BagIterator<E>(first);
	}
	
	private static class BagIterator<E> implements Iterator<E>{
		private Node<E> previousNode;
		private Node<E> currentNode;
		
		public BagIterator(Node<E> first) {
			currentNode = first;
		}
		@Override
		public boolean hasNext() {
			return currentNode != null? true:false;
		}

		@Override
		public E next() {
			if(hasNext() == false) return null;
			previousNode = currentNode;
			currentNode = currentNode.next;
			return previousNode.element;
		}

		@Override
		public void remove() {
			currentNode = currentNode.next;
			if(previousNode!=null){
				previousNode.next = currentNode.next;
			}
		}
	}

	@Override
	public void add(E element) {
		Node<E> oldFirst = first;
		first = new Node<E>(element);
		first.next = oldFirst;
		size++;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmply() {
		return size == 0? true: false;
	}
	
	public String toString(){
		final String ELEMENT_SEPARATOR = ", ";
		StringBuilder sb = new StringBuilder("[");
		Iterator<E> iterator = iterator();
		while (iterator.hasNext()) {
			sb.append(iterator.next());
			if(iterator.hasNext()) sb.append(ELEMENT_SEPARATOR);
		}
		sb.append("]");
		return sb.toString();
	}

	@Override
	public boolean contains(E element) {
		if(element != null){
			Iterator<E> i = iterator();
			while (i.hasNext()) {
				if(i.next().equals(element)){
					return true;
				}
			}
		}
		return false;
	}
}
