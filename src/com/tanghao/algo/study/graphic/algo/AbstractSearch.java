package com.tanghao.algo.study.graphic.algo;

import com.tanghao.algo.study.datastructure.linklist.Bag;
import com.tanghao.algo.study.graphic.basic.Graph;

public abstract class AbstractSearch implements Search, Path {
	protected boolean[] marked;
	protected int[] edgeTo;
	protected int count;
	protected final int s;
	
	public AbstractSearch(Graph g, int s) {
		this.s =s;
		marked = new boolean[g.V()];
		edgeTo = new int[g.V()];
	}
	
	
	@Override
	public boolean marked(int v) {
		return marked[v];
	}

	@Override
	public int count() {
		return count;
	}

	@Override
	public boolean hasPathTo(int v) {
		return marked(v);
	}

	@Override
	public Iterable<Integer> pathTo(int v) {
		Bag<Integer> bag = new Bag<Integer>();
		for (int i = v; i != s; i = edgeTo[i]) {
			bag.add(i);
		}
		bag.add(s);
		return bag;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < marked.length; i++) {
			if (marked(i)) {
				sb.append(String.format("%-12s",
						"Path ".concat(Integer.toString(s)).concat(" to ")
								.concat(Integer.toString(i))));
				sb.append(": ");
				for (int v : pathTo(i)) {
					sb.append(v + " ");
				}
				sb.append("\n");
			}
		}
		return sb.toString();
	}

}
