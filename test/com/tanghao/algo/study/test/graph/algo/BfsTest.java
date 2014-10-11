package com.tanghao.algo.study.test.graph.algo;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.tanghao.algo.study.graphic.algo.BreathFirstSearch;
import com.tanghao.algo.study.graphic.algo.DepthFirstSearch;
import com.tanghao.algo.study.graphic.algo.Search;
import com.tanghao.algo.study.graphic.basic.Graph;

public class BfsTest {
	GraphTestHelper testHelper = new GraphTestHelper();
	@Test
	public void test() {
		String filePath = "tinyG.txt";
		filePath = "source/".concat(filePath);
		Graph testGraph = testHelper.buildGraphFromFile(filePath);
		Search search0 = new BreathFirstSearch(testGraph,  0);
		boolean [] marked0 = {true,true,true,true,true,true,true,false,false,false,false,false,false};
		int count0 = 7;
		for(int i=0; i< testGraph.V(); i++){
			assertEquals(marked0[i], search0.marked(i));
		}
		assertEquals(count0, search0.count());
		System.out.println(search0.toString());
		Search search7 = new BreathFirstSearch(testGraph,  7);
		boolean [] marked7 = {false,false,false,false,false,false,false,true,true,false,false,false,false};
		int count7 = 2;
		for(int i=0; i< testGraph.V(); i++){
			assertEquals(marked7[i], search7.marked(i));
		}
		assertEquals(count7, search7.count());
		System.out.println(search7.toString());
		Search search9 = new BreathFirstSearch(testGraph,  9);
		boolean [] marked9 = {false,false,false,false,false,false,false,false,false,true,true,true,true};
		int count9 = 4;
		for(int i=0; i< testGraph.V(); i++){
			assertEquals(marked9[i], search9.marked(i));
		}
		assertEquals(count9, search9.count());
		System.out.println(search9.toString());
	}
}
