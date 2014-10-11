package com.tanghao.algo.study.common.tree;

import org.junit.Test;

public class BinaryTreeTest {

	@Test
	public void test() {
		BinaryTree<Integer> testingTree = new BinaryTree<Integer>(new TreeNode<Integer>(15));
		testingTree.add(10);
		testingTree.add(14);
		testingTree.add(12);
		testingTree.add(5);
		testingTree.add(17);
		testingTree.add(19);
		testingTree.add(24);
		testingTree.add(20);

		System.out.println("Print Original tree...");
		new TreePrinter<>(testingTree).printOnConsole();
		/////
		System.out.println();
		System.out.println("Removed Node 20 ...");
		testingTree.remove(20);
		new TreePrinter<>(testingTree).printOnConsole();
		/////
		System.out.println();
		System.out.println("Removed Node 19 ...");
		testingTree.remove(19);
		new TreePrinter<>(testingTree).printOnConsole();
		/////
		System.out.println();
		System.out.println("Removed Node 10 ...");
		testingTree.remove(10);
		new TreePrinter<>(testingTree).printOnConsole();
	}

}
