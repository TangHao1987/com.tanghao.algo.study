package com.tanghao.algo.study.graphic.view;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.JFrame;

import org.jgrapht.ext.JGraphXAdapter;
import org.jgrapht.graph.DefaultEdge;

import com.tanghao.algo.study.graphic.basic.Graph;

public class JGraphXDrawer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String filePath = "tinyG.txt";
		filePath = "source/".concat(filePath);
		Scanner in = null;
		try {
			in = new Scanner(new File(filePath));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Graph graph = null;
		try {
			graph = new Graph(in);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 // create a visualization using JGraph, via an adapter
			JGraphXAdapter<Integer, DefaultEdge> jgxAdapter = new JGraphXAdapter<Integer, DefaultEdge>(new SimpleUndirectedGraphAdapter(graph));
		       JGraphXInitializer applet = new JGraphXInitializer(jgxAdapter);
		        JFrame frame = new JFrame();
		        frame.getContentPane().add(applet);
		        frame.setTitle("Draw as JGraph");
		        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		        frame.pack();
		        frame.setVisible(true);
	}

}
