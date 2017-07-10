package com.smilingfrog.ads.list;

import java.util.ConcurrentModificationException;
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
			
			Node savedFirstElement = firstElement;
			Node savedLastElement = lastElement;
			Node currentNode = firstElement;
			
			@Override
			public boolean hasNext() {
				checkForConcurrentModification();
				if(currentNode != null){
					return true;
				}
				return false;
			}

			private void checkForConcurrentModification() {
				if(savedFirstElement!=firstElement || 
						savedLastElement != lastElement){
					throw new ConcurrentModificationException();
				}
			}

			@Override
			public T next() {
				checkForConcurrentModification();
				T value = currentNode.value;
				currentNode = currentNode.next;
				return value;
			}
			
		};
	}

}
