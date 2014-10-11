package com.tanghao.algo.study.graphic.view;

import java.util.Iterator;

import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleGraph;

import com.tanghao.algo.study.graphic.basic.IGraph;

/**
 * this class convert the Graph object created following Algorithm 4th edition
 * to be a printable graphic by using JGraphT library.
 * 
 * this class is a common adapter class
 * 
 * @author Hao
 *
 */
public class SimpleUndirectedGraphAdapter extends SimpleGraph<Integer, DefaultEdge> {

	/**
	 * Generated Serial ID
	 */
	private static final long serialVersionUID = -526478560710619167L;
	
	private GraphAdapterHelper helper = new GraphAdapterHelper();

	public SimpleUndirectedGraphAdapter(Class<? extends DefaultEdge> edgeClass) {
		super(edgeClass);
	}

	public SimpleUndirectedGraphAdapter(IGraph graph) {
		super(DefaultEdge.class);
		helper.convertToUndirectGraph(this, graph);
	}
}
