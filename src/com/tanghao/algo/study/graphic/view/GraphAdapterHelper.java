package com.tanghao.algo.study.graphic.view;

import java.util.Iterator;

import org.jgrapht.UndirectedGraph;
import org.jgrapht.graph.DefaultEdge;

import com.tanghao.algo.study.graphic.basic.IGraph;

public class GraphAdapterHelper{
	public void convertToUndirectGraph(UndirectedGraph<Integer, DefaultEdge> undirectGraph, IGraph graph){
		for (int v = 0; v < graph.V(); v++) {
			if(!undirectGraph.containsVertex(v)) undirectGraph.addVertex(v);
			Iterator<Integer> graphIterator = graph.adjIterator(v);
			while (graphIterator.hasNext()) {
				int nextVertex = graphIterator.next();
				if(!undirectGraph.containsVertex(nextVertex)) 	undirectGraph.addVertex(nextVertex);
				if(!undirectGraph.containsEdge(v, nextVertex)) 	undirectGraph.addEdge(v, nextVertex);
			}
		}
	}
}
