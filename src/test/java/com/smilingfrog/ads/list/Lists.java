package com.smilingfrog.ads.list;

public class Lists {

	public static int[] toArray(List list) {
		int[] newArray = new int[list.getSize()];
		for(int i = 0; i < list.getSize(); i++){
			newArray[i] = (int) list.get(i);
		}
		return newArray;
	}

}
