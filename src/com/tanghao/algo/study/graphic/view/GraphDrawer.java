package com.tanghao.algo.study.graphic.view;

import com.tanghao.algo.study.graphic.basic.IGraph;

public class GraphDrawer {
	private static GraphDrawer uniqueInstance;
	public static GraphDrawer getInstance(){
		if(uniqueInstance == null) {
			uniqueInstance = new GraphDrawer();
		}
		return uniqueInstance;
	}
	
	private GraphDrawer() {
		super();
	}
	
	public void drawSimpleUndirectedGraph(IGraph graph){
		System.out.println(new SimpleUndirectedGraphAdapter(graph));
	}
	
	public void drawJxUndirectedGraph(IGraph graph){
	
	}
}
