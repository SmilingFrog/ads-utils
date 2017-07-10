package com.smilingfrog.ads.list;

import static org.junit.Assert.*;

import org.junit.Test;

public class SinglyLinkedListTest {

	@Test
	public void canCreateSinglyLinkedList() {
		List<Integer> list = new SinglyLinkedList<>();
		assertNotNull(list);
	}

	@Test
	public void givenNewLinkedListItsSizeIs0() {
		List<Integer> list = new SinglyLinkedList<>();
		assertEquals(0, list.getSize());
	}

	@Test
	public void canAddAndGetOneElement() {
		List<Integer> list = new SinglyLinkedList<>();
		list.add(new Integer(5));
		assertEquals(1, list.getSize());
		int extractedElement = list.get(0);
		assertEquals(5, extractedElement);
	}

	@Test
	public void canAddAndGetTwoElements() {
		List<Integer> list = new SinglyLinkedList<>();
		list.add(new Integer(5));
		assertEquals(1, list.getSize());
		int extractedElement = list.get(0);
		assertEquals(5, extractedElement);
		assertEquals(1, list.getSize());
		list.add(new Integer(10));
		assertEquals(2, list.getSize());
		extractedElement = list.get(1);
		assertEquals(10, extractedElement);
	}

	@Test
	public void canAddAndGet3Elements() {
		List<Integer> list = new SinglyLinkedList<>();
		list.add(new Integer(5));
		assertEquals(1, list.getSize());
		int extractedElement = list.get(0);
		assertEquals(5, extractedElement);
		assertEquals(1, list.getSize());
		list.add(new Integer(10));
		assertEquals(2, list.getSize());
		extractedElement = list.get(1);
		assertEquals(10, extractedElement);
		list.add(new Integer(100));
		assertEquals(3, list.getSize());
		extractedElement = list.get(2);
		assertEquals(100, extractedElement);
	}

	@Test
	public void canIterateThroughTheList() {
		List<Integer> list = new SinglyLinkedList<>();
		Integer[] initialValues = { 10, 20, 30 };
		fillTheList(list, initialValues);
		Integer[] valuesInTheList = new Integer[list.getSize()];
		for(int i = 0; i<list.getSize();i++){
			valuesInTheList[i] = list.get(i);
		}
		assertArrayEquals(initialValues, valuesInTheList);
	}

	private void fillTheList(List<Integer> list, Integer[] initialValues) {
		for(Integer i : initialValues){
			list.add(i);
		}
	}

}
