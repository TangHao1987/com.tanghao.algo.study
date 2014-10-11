package com.tanghao.algo.study.graphic.algo;

import com.tanghao.algo.study.graphic.basic.Graph;

public class DepthFirstSearch extends AbstractSearch {
	public DepthFirstSearch(Graph g, int s) {
		super(g, s);
		dfs(g, s);
	}

	private void dfs(Graph g, int s) {
		for (int v : g.adj(s)) {
			if (marked(v) == false) {
				marked[v] = true;
				edgeTo[v] = s;
				count++;
				dfs(g, v);
			}
		}
	}
}
