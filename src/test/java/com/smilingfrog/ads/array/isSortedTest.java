package com.smilingfrog.ads.array;

import static org.junit.Assert.*;

import org.junit.Test;

import com.smilingfrog.ads.array.Arrays.Order;

public class isSortedTest {

	@Test(expected = IllegalArgumentException.class)
	public void givenNullFirrstOverloadThrowsException() {
		Integer[] array = null;
		Arrays.isSorted(array);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void givenNullSecondOverloadThrowsException() {
		Integer[] array = null;
		Arrays.isSorted(array, Order.ASCENDING);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void givenNullThirdOverloadThrowsException() {
		Integer[] array = null;
		Arrays.isSorted(array, 0, 1, Order.ASCENDING);
	}

	@Test
	public void given0SizeArrayReturnTrue() {
		Integer[] array = new Integer[0];
		assertTrue(Arrays.isSorted(array));
	}
	
	@Test
	public void given1ElementArrayReturnTrue() {
		Integer[] array = new Integer[] { 3 };
		assertTrue(Arrays.isSorted(array));
	}

	@Test
	public void given2ElementsSortedInAscendingOrderArrayReturnTrue() {
		Integer[] array = new Integer[] { 3, 7 };
		assertTrue(Arrays.isSorted(array));
	}

	@Test
	public void given2ElementsSortedInDescendingOrderReturnTrue() {
		Integer[] array = new Integer[] { 3, 1 };
		assertTrue(Arrays.isSorted(array));
	}

	@Test
	public void given3ElementsSortedInAscendingOrderReturnTrue() {
		Integer[] array = new Integer[] { 3, 6, 9 };
		assertTrue(Arrays.isSorted(array));
	}

	@Test
	public void given3ElementsSortedInDescendingOrderReturnTrue() {
		Integer[] array = new Integer[] { 9, 5, 2 };
		assertTrue(Arrays.isSorted(array));
	}

	@Test
	public void given3ElementsNotSortedReturnFalse() {
		Integer[] array = new Integer[] { 9, 10, 2 };
		assertFalse(Arrays.isSorted(array));
	}

	@Test
	public void givenInAscOrderTestForAscOrderIsTrue() {
		Integer[] array = new Integer[] { 9, 10, 20 };
		assertTrue(Arrays.isSorted(array, Order.ASCENDING));
	}

	@Test
	public void givenNotInAscOrderTestForAscOrderIsFalse() {
		Integer[] array = new Integer[] { 9, 10, 2 };
		assertFalse(Arrays.isSorted(array, Order.ASCENDING));
		array = new Integer[] { 10, 7, 2 };
		assertFalse(Arrays.isSorted(array, Order.ASCENDING));
	}

	@Test
	public void givenInDescOrderTestForDescOrderIsTrue() {
		Integer[] array = new Integer[] { 9, 6, 2 };
		assertTrue(Arrays.isSorted(array, Order.DESCENDING));
	}

	@Test
	public void givenNotInDescOrderTestForDescOrderIsFalse() {
		Integer[] array = new Integer[] { 9, 10, 20 };
		assertFalse(Arrays.isSorted(array, Order.DESCENDING));
		array = new Integer[] { 10, 7, 8 };
		assertFalse(Arrays.isSorted(array, Order.DESCENDING));
	}

	@Test
	public void givenSortedInAscendingOrderRangeReturnTrue() {
		Integer[] array = new Integer[] { 9, 10, 20};
		int firstIndex = 1;
		int lastIndex = 2;
		assertTrue(Arrays.isSorted(array, firstIndex, lastIndex, Order.ASCENDING));
	}
	
	@Test
	public void givenTheSameFirstAndLastIndexReturnTrue(){
		Integer[] array = new Integer[] { 9, 10, 20};
		int firstIndex = 1;
		int lastIndex = 1;
		assertTrue(Arrays.isSorted(array, firstIndex, lastIndex, Order.ASCENDING));
	}
	
	@Test
	public void givenSortedInDescendingOrderRangeReturnTrue() {
		Integer[] array = new Integer[] { 90, 10, 2};
		int firstIndex = 0;
		int lastIndex = 1;
		assertTrue(Arrays.isSorted(array, firstIndex, lastIndex, Order.DESCENDING));
		firstIndex = 1;
		lastIndex = 2;
		assertTrue(Arrays.isSorted(array, firstIndex, lastIndex, Order.DESCENDING));
	}
	
	@Test(expected=IndexOutOfBoundsException.class)
	public void givenFirstIndexIsOutOfRangeThrowException(){
		Integer[] array = new Integer[] { 9, 10, 20};
		int firstIndex = -1;
		int lastIndex = 2;
		assertTrue(Arrays.isSorted(array, firstIndex, lastIndex, Order.ASCENDING));
	}
	
	@Test(expected=IndexOutOfBoundsException.class)
	public void givenLastIndexIsOutOfRangeThrowException(){
		Integer[] array = new Integer[] { 9, 10, 20};
		int firstIndex = 1;
		int lastIndex = 3;
		assertTrue(Arrays.isSorted(array, firstIndex, lastIndex, Order.ASCENDING));
	}
	
}
