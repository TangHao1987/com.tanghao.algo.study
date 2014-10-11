package com.tanghao.algo.study.graphic.basic;

import java.util.Iterator;


public interface IGraph{
	int V();
	int E();
	void addEdge(int v, int w);
	Iterator<Integer> adj(int v);
} 
