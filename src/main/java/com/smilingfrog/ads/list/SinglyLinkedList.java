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

	@Override
	public int getSize() {
		return size;
	}

	@Override
	public void add(T element) {
		Node newElement = lastElement;
		lastElement = new Node();
		lastElement.value = element;
		if (size == 0) {
			firstElement = lastElement;
		} else {
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
		return new Iterator<T>() {

			Node savedFirstElement = firstElement;
			Node savedLastElement = lastElement;
			Node currentNode = firstElement;

			@Override
			public boolean hasNext() {
				checkForConcurrentModification();
				if (currentNode != null) {
					return true;
				}
				return false;
			}

			private void checkForConcurrentModification() {
				if (savedFirstElement != firstElement || savedLastElement != lastElement) {
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

	@Override
	public void add(int index, T element) {
		
		checkLowerBound(index);
		
		if (index == 0) {
			Node newElement = new Node();
			newElement.next = firstElement;
			newElement.value = element;
			firstElement = newElement;
			if (size == 0) {
				lastElement = firstElement;
			}
			size++;
		} else {
			checkUpperBound(index);
			Node nodeBeforeIndex = firstElement;
			for (int i = 0; i < index - 1; i++) {
				nodeBeforeIndex = nodeBeforeIndex.next;
			}
			Node newElement = new Node();
			newElement.next = nodeBeforeIndex.next;
			newElement.value = element;
			nodeBeforeIndex.next = newElement;
			size++;
		}
	}

	@Override
	public T remove(int index) {
		
		checkLowerBound(index);
		checkUpperBound(index);
		
		Node removed = null;
		if(index == 0){
			if(lastElement == firstElement){
				removed = firstElement;
				firstElement = null;
			}else{
				removed = firstElement;
				firstElement = firstElement.next;
			}
			size--;
		}else{
			Node nodeBeforeIndex = firstElement;
			for (int i = 0; i < index - 1; i++) {
				nodeBeforeIndex = nodeBeforeIndex.next;
			}
			removed = nodeBeforeIndex.next;
			if(removed == lastElement){
				lastElement = nodeBeforeIndex;
			}
			nodeBeforeIndex.next = removed.next;
			size--;
		}
		return removed.value;
	}

	private void checkLowerBound(int index) {
		if(index < 0){
			throw new IndexOutOfBoundsException("index  " + index + " is out of bounds");
		}
	}
	private void checkUpperBound(int index) {
		if(index >= size){
			throw new IndexOutOfBoundsException("index  " + index + " is out of bounds");
		}
	}

}
