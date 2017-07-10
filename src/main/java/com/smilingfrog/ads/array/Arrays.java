package com.smilingfrog.ads.array;

import com.smilingfrog.ads.array.Arrays.Order;

/**
 * A set of utility static methods to work with arrays
 * @author Sergii Savin
 * @version 1.0
 *	
 */
public class Arrays {

	/** defines order of the array: ASCENDING or DESCENDING */
	public static enum Order {
		ASCENDING, DESCENDING
	};

	/**
	 * checks whether the array is sorted either in an ASCENDING or DESCENDING
	 * order
	 * @return true if the array is sorted
	 * @param array the array to check
	 * @throws  IllegalArgumentException if the argument is null
	 */
	public static boolean isSorted(Comparable[] array) {
		testNull(array);
		int firstIndex = 0;
		int lastIndex = array.length - 1;
		boolean isSortedInAscending = isSorted(array, firstIndex, lastIndex, Order.ASCENDING);
		boolean isSortedInDescending = isSorted(array, firstIndex, lastIndex, Order.DESCENDING);
		return isSortedInAscending || isSortedInDescending;
	}

	private static void testNull(Object array) {
		if (array == null) {
			throw new IllegalArgumentException("argument can not be null");
		}
	}

	/**
	 * checks whether the range in the array with the indexes from 
	 * firstIndex to lastIndex is sorted in the order specified
	 * @return true if the array is sorted in the order specified
	 * @param array the array to check
	 * @param order order to check: either ASCENDING or DESCENDING
	 * @param firstIndex first index in the range within the array
	 * @param lastIndex last index in the range within the array
	 * @throws IllegalArgumentException if the argument is null
	 * 
	 */
	public static boolean isSorted(Comparable[] array, int firstIndex, int lastIndex, Arrays.Order order) {

		testNull(array);
		checkIndexesBounds(array, firstIndex, lastIndex);

		if (order == Order.ASCENDING) {
			for (int i = firstIndex; i < lastIndex; i++) {
				if (array[i].compareTo(array[i + 1]) >= 0)
					return false;
			}
		}
		if (order == Order.DESCENDING) {
			for (int i = firstIndex; i < lastIndex; i++) {
				if (array[i].compareTo(array[i + 1]) <= 0)
					return false;
			}
		}
		return true;
	}

	private static void checkIndexesBounds(Comparable[] array, int firstIndex, int lastIndex) {
		if (firstIndex < 0) {
			throw new IndexOutOfBoundsException("firstIndex " + firstIndex + " is out of bound");
		}
		if(lastIndex >= array.length){
			throw new IndexOutOfBoundsException("lastIndex " + lastIndex + " is out of bound");
		}
	}

	/**
	 * checks whether the array is sorted either in an ASCENDING or DESCENDING order
	 * @return true if the array is sorted in the order specified
	 * @param array the array to check
	 * @param order order to check: either ASCENDING or DESCENDING
	 * @throws IllegalArgumentException if the argument is null
	 * 
	 */
	public static boolean isSorted(Comparable[] array, Order order) {
		testNull(array);
		return isSorted(array, 0, array.length - 1, order);
	}

	/**
	 * Searches the element in the array using sequential search. 
	 * The array does not need to be sorted. Does not change the array.
	 * The element to search can not be null.
	 * Complexity: O(N)
	 * @return index of the first occurrence of the element
	 * in the array. If the element is not in the array returns -1;
	 * @param array the array to check
	 * @param element the element to look for
	 * @throws IllegalArgumentException if either argument is null
	 * 
	 */
	public static int search(Comparable[] array, Comparable element) {
		testNull(array);
		testNull(element);
		int firstIndex = 0;
		int lastIndex = array.length - 1;
		return search(array, firstIndex, lastIndex, element);
	}

	/**
	 * Searches the element in the array using sequential search. 
	 * The element to search can not be null.
	 * The array does not need to be sorted. Does not change the array.
	 * Complexity: O(N)
	 * @return index of the first occurrence of the element
	 * in the array. If the element is not in the array returns -1;
	 * @param array the array to check
	 * @param firstIndex first index of the range to search within the array
	 * @param lastIndex last index of the range within the array 
	 * @param element the element to look for
	 * @throws IllegalArgumentException if either array or element is null
	 * @throws IndexOutOfBoundsException if either firstIndex or lastIndex 
	 * are out of bounds of the array
	 * 
	 */
	public static int search(Comparable[] array, int firstIndex, int lastIndex, Comparable element) {
		testNull(array);
		testNull(element);
		checkIndexesBounds(array, firstIndex, lastIndex);
		for(int i = firstIndex; i<= lastIndex; i++){
			if(array[i].compareTo(element) == 0){
				return i;
			}
		}
		return -1;
	}

	/**
	 * Searches the element in the array using sequential search. 
	 * The element to search can not be null.
	 * The array does not need to be sorted. Does not change the array.
	 * Complexity: O(N)
	 * @return int[] array of indexes of the occurrences of the element
	 * in the array. If the element is not in the array returns int[] array
	 * with only one element int[0] == -1;
	 * @param array the array to check
	 * @param element the element to look for
	 * @throws IllegalArgumentException if either array or element is null
	 * 
	 */
	public static int[] searchAll(Comparable[] array, Comparable element) {
		testNull(array);
		testNull(element);
		int firstIndex = 0;
		int lastIndex = array.length-1;
		return searchAll(array, firstIndex, lastIndex, element);
	}

	/**
	 * Searches the element in the array using sequential search. 
	 * The element to search can not be null.
	 * The array does not need to be sorted. Does not change the array.
	 * Complexity: O(N)
	 * @return int[] array of indexes of the occurrences of the element
	 * in the array. If the element is not in the array returns int[] array
	 * with only one element int[0] == -1;
	 * @param array the array to check
	 * @param firstIndex first index of the range to search within the array
	 * @param lastIndex last index of the range within the array 
	 * @param element the element to look for
	 * @throws IllegalArgumentException if either array or element is null
	 * @throws IndexOutOfBoundsException if either firstIndex or lastIndex 
	 * are out of bounds of the array
	 * 
	 */
	public static int[] searchAll(Comparable[] array, int firstIndex, int lastIndex, Comparable element) {
		testNull(array);
		testNull(element);
		checkIndexesBounds(array, firstIndex, lastIndex);
		int indexesLength = array.length>0 ? array.length : 1;
		int[] indexes = new int[indexesLength]; //!!! Need to use a resizable List here 
		int founIndex = 0;
		boolean isFound = false;
		for(int i = firstIndex; i<= lastIndex; i++){
			if(array[i].compareTo(element) == 0){
				indexes[founIndex++] = i;
				isFound = true;
			}
		}
		if(!isFound){
			indexes[0] = -1;
		}
		return indexes;
	}

}
