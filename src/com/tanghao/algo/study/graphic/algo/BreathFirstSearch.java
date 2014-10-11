package com.tanghao.algo.study.graphic.algo;

import java.util.LinkedList;
import java.util.Queue;

import com.tanghao.algo.study.graphic.basic.Graph;

public class BreathFirstSearch extends AbstractSearch {
	public BreathFirstSearch(Graph g, int s) {
		super(g ,s);
		Queue<Integer> buffer = new LinkedList<Integer>();
		bfs(g, s, buffer);
	}

	private void bfs(Graph g, int s, Queue<Integer> buffer) {
		buffer.add(s);
		while (buffer.isEmpty() == false) {
			int v = buffer.poll();
			for (int w : g.adj(v)) {
				if (marked(w) == false) {
					buffer.add(w);
					edgeTo[w] = v;
					marked[w] = true;
					count++;
				}
			}
		}	
	}
}
