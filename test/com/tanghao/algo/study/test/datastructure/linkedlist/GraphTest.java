package com.tanghao.algo.study.test.datastructure.linkedlist;

import static org.junit.Assert.assertEquals;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.Scanner;

import org.junit.Before;
import org.junit.Test;

import com.tanghao.algo.study.graphic.basic.Graph;
import com.tanghao.algo.study.graphic.view.GraphDrawer;

public class GraphTest {
	private String filePath;
	private int edge;
	private int vertex;
	@Before
	public void before(){
		filePath = "tinyG.txt";
		filePath = "source/".concat(filePath);
		edge = 13;
		vertex = 13;
	}
	@Test
	public void test() throws IOException {
		Scanner in = new Scanner(new File(filePath));
		Graph graph = new Graph(in);
		assertEquals(graph.V(), vertex);
		assertEquals(graph.E(), edge);
		
		System.out.print(graph.toString());
	}

}
