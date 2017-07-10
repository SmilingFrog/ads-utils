package com.smilingfrog.ads.list;

import java.util.Iterator;

public class SinglyLinkedList<T> implements List<T> {

	int size = 0;
	Node firstElement;
	Node lastElement;
	
	private class Node {
		T value;
		Node next;
	}

	public SinglyLinkedList() {
		firstElement = lastElement;
	}
	
	@Override
	public int getSize() {
		return size;
	}

	@Override
	public void add(T element) {
		Node newElement = lastElement;
		lastElement = new Node();
		lastElement.value = element;
		if(size == 0){
			firstElement = lastElement;
		}else{			
			newElement.next = lastElement;
		}
		size++;
	}

	@Override
	public T get(int index) {
		Node foundNode = firstElement;
		for (int i = 0; i < index; i++) {
			foundNode = foundNode.next;
		}
		return foundNode.value;
	}

	@Override
	public Iterator<T> iterator() {
		return new Iterator<T>(){
			
			int savedSize = size;
			Node currentNode = firstElement;
			
			@Override
			public boolean hasNext() {
				if(currentNode != null){
					return true;
				}
				return false;
			}

			@Override
			public T next() {
				T value = currentNode.value;
				currentNode = currentNode.next;
				return value;
			}
			
		};
	}

}
