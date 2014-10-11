package com.tanghao.algo.study.test.graph.algo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;

import com.sun.istack.internal.logging.Logger;
import com.tanghao.algo.study.graphic.basic.Graph;

public class GraphTestHelper {
	private static Logger logger = Logger.getLogger(GraphTestHelper.class.getName(), GraphTestHelper.class);
	Graph buildGraphFromFile(String path){
		Scanner in = null;
		Graph graph = null;
		try {
			in = new Scanner(new File(path));
			graph = new Graph(in);
		} catch (FileNotFoundException e) {
			logger.log(Level.SEVERE, e.toString(), e);
		} catch (IOException e) {
			logger.log(Level.SEVERE, e.toString(), e);
		}
		return graph;
	}
}
