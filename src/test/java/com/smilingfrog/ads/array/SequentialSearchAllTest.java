package com.smilingfrog.ads.array;

import static org.junit.Assert.*;

import org.junit.Test;

public class SequentialSearchAllTest {

	@Test(expected = IllegalArgumentException.class)
	public void givenNullThrowsException() {
		Integer[] array = null;
		int[] indexes = Arrays.searchAll(array, new Integer(5));
	}

	@Test
	public void given0SizeArrayReturnMinus1() {
		Integer[] array = new Integer[0];
		int[] indexes = Arrays.searchAll(array, new Integer(5));
		assertEquals(1, indexes.length);
		assertEquals(-1, indexes[0]);
	}

	@Test(expected = IllegalArgumentException.class)
	public void givenElementToFindIsNullThrowException() {
		Integer[] array = new Integer[0];
		int[] indexes = Arrays.searchAll(array, null);
	}
	
	@Test
	public void givenElementIsPresentReturnIndexes() {
		Integer[] array = new Integer[] { 3, 6, 4, 1, 6, 5 };
		int[] indexes = Arrays.searchAll(array, 6);
		assertEquals(1, indexes[0]);
		assertEquals(4, indexes[1]);
	}
	
	@Test
	public void givenElementIsAbsentReturnMinus1() {
		Integer[] array = new Integer[] { 3, 6, 4, 1, 9, 5 };
		int[] indexes = Arrays.searchAll(array, 0);
		assertEquals(-1, indexes[0]);
	}
	
	@Test(expected=IndexOutOfBoundsException.class)
	public void givenWrongFirstIndexInTheRangeThrowException(){
		Integer[] array = new Integer[] { 3, 6, 8, 1, 6, 5 };
		int[] indexes = Arrays.searchAll(array, -1, 4, 6);
	}
	
	@Test(expected=IndexOutOfBoundsException.class)
	public void givenWrongLastIndexInTheRangeThrowException(){
		Integer[] array = new Integer[] { 3, 6, 8, 1, 6, 5 };
		int[] indexes = Arrays.searchAll(array, 1, 10, 6);
	}

	@Test
	public void givenTheElementIsPresentInTheRangeReturnTheIndexOfTheFirstElementInTheRange(){
		Integer[] array = new Integer[] { 3, 6, 6, 1, 6, 5 };
		int[] indexes = Arrays.searchAll(array, 1, 3, 6);
		assertEquals(1, indexes[0]);
		assertEquals(2, indexes[1]);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void givenRangeAndNullElementThrowException(){
		Integer[] array = new Integer[] { 3, 6, 6, 1, 6, 5 };
		int[] indexes = Arrays.searchAll(array, 1, 3, null);
	}

}
