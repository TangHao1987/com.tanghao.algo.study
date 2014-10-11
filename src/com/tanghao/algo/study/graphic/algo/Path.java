package com.tanghao.algo.study.graphic.algo;

public interface Path {
	boolean hasPathTo(int v);
	Iterable<Integer> pathTo(int v);
}
