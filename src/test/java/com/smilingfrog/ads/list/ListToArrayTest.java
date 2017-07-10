package com.smilingfrog.ads.list;

import static org.junit.Assert.*;

import org.junit.Test;

public class ListToArrayTest {

	@Test
	public void givenListOfObjectsThatCanBeCastToIntsReturnTHeArrayOfInts() {
		List<Integer> list = new SinglyLinkedList<>();
		Integer[] initialValues = { 10, 20, 30, 40 };
		fillTheList(list, initialValues);
		int[] array = null;
		array = Lists.toArray(list, array);
		assertArrayEquals(new int[] { 10, 20, 30, 40 }, array);

	}

	private void fillTheList(List<Integer> list, Integer[] initialValues) {
		for (Integer i : initialValues) {
			list.add(i);
		}
	}
}
