package com.smilingfrog.ads.list;

public interface List<T> extends Iterable<T>{

	int getSize();

	void add(T element);

	T get(int index);

	void add(int index, T element);

	T remove(int index);

}
