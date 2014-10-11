package com.tanghao.algo.study.datastructure.linklist;

public interface IMyList<E> extends Iterable<E> {
	void add(E add);
	int size();
	boolean contains(E element);
	boolean isEmply();
}