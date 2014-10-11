package com.tanghao.algo.study.graphic.view;

import java.awt.Dimension;

import javax.swing.JApplet;

import org.jgrapht.ext.JGraphXAdapter;
import org.jgrapht.graph.DefaultEdge;

import com.mxgraph.layout.mxCircleLayout;
import com.mxgraph.layout.mxFastOrganicLayout;
import com.mxgraph.layout.mxGraphLayout;
import com.mxgraph.layout.mxOrganicLayout;
import com.mxgraph.layout.hierarchical.mxHierarchicalLayout;
import com.mxgraph.swing.mxGraphComponent;

public class JGraphXInitializer extends JApplet{

	/**
	 * Genrated Serial Id
	 */
	private static final long serialVersionUID = 1546729720090165117L;
	private static final Dimension DEFAULT_SIZE = new Dimension(530, 320);
    private JGraphXAdapter<Integer, DefaultEdge> jgxAdapter;

    public JGraphXInitializer(){
    	
    }
    
	public JGraphXInitializer(JGraphXAdapter<Integer, DefaultEdge> adapter) {
		this();
		this.jgxAdapter = adapter;
		initialize();
	}
    
	public void initialize() {
        getContentPane().add(new mxGraphComponent(jgxAdapter));
        resize(DEFAULT_SIZE);
		// positioning via jgraphx layouts
        mxGraphLayout layout = new mxHierarchicalLayout(jgxAdapter);
        layout.execute(jgxAdapter.getDefaultParent());
	}

}
