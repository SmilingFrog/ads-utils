package com.smilingfrog.ads.array;

import static org.junit.Assert.*;

import org.junit.Test;

public class SequentialSearchTest {

	@Test(expected = IllegalArgumentException.class)
	public void givenNullThrowsException() {
		Integer[] array = null;
		Arrays.search(array, new Integer(5));
	}

	@Test
	public void given0SizeArrayReturnMinus1() {
		Integer[] array = new Integer[0];
		int index = Arrays.search(array, new Integer(5));
		assertEquals(-1, index);
	}

	@Test(expected = IllegalArgumentException.class)
	public void givenElementToFindIsNullThrowException() {
		Integer[] array = new Integer[0];
		int index = Arrays.search(array, null);
	}

	@Test
	public void givenElementIsPresentReturnIndex() {
		Integer[] array = new Integer[] { 3, 6, 4, 1, 9, 5 };
		int index = Arrays.search(array, 4);
		assertEquals(2, index);
		index = Arrays.search(array, 3);
		assertEquals(0, index);
		index = Arrays.search(array, 5);
		assertEquals(5, index);
	}
	
	@Test
	public void givenElementIsAbsentReturnMinus1() {
		Integer[] array = new Integer[] { 3, 6, 4, 1, 9, 5 };
		int index = Arrays.search(array, 0);
		assertEquals(-1, index);
		index = Arrays.search(array, 10);
		assertEquals(-1, index);
	}
	
	@Test
	public void givenSeveralElementsArePresentReturnTheIndexOfTheFirstElement(){
		Integer[] array = new Integer[] { 3, 6, 8, 1, 6, 5 };
		int index = Arrays.search(array, 6);
		assertEquals(1, index);
	}
	
	@Test(expected=IndexOutOfBoundsException.class)
	public void givenWrongFirstIndexInTheRangeThrowException(){
		Integer[] array = new Integer[] { 3, 6, 8, 1, 6, 5 };
		int index = Arrays.search(array, -1, 4, 6);
		assertEquals(1, index);
	}
	
	@Test(expected=IndexOutOfBoundsException.class)
	public void givenWrongLastIndexInTheRangeThrowException(){
		Integer[] array = new Integer[] { 3, 6, 8, 1, 6, 5 };
		int index = Arrays.search(array, 1, 10, 6);
		assertEquals(1, index);
	}
	
	@Test
	public void givenTheElementIsPresentInTheRangeReturnTheIndexOfTheFirstElementInTheRange(){
		Integer[] array = new Integer[] { 3, 6, 6, 1, 6, 5 };
		int index = Arrays.search(array, 1, 3, 6);
		assertEquals(1, index);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void givenRangeAndNullElementThrowException(){
		Integer[] array = new Integer[] { 3, 6, 6, 1, 6, 5 };
		int index = Arrays.search(array, 1, 3, null);
	}

}
