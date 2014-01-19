package com.tanghao.algo.study.app.sort.compare;

import com.tanghao.algo.study.common.BinaryTree;
import com.tanghao.algo.study.common.CommonLogics;

public class HeapSorter extends Sorter {
	private BinaryTree tree;
	
	public HeapSorter() {
		
	}
	
	public HeapSorter(int [] array){
		setArray(array);
		tree = new BinaryTree(array);
	}
	@Override
	public void sort() {
		// TODO Auto-generated method stub
		buidMaxHeap();
		getSortedArray();
	}
	
	private void buidMaxHeap(){
		for(int i = array.length/2 -1 ; i >= 0 ; i-- ){
			maxHeapify(i, array.length);
		}
	}
	
	private void getSortedArray(){
		int heapSize = array.length;
		while(heapSize>1){
			CommonLogics.swap(array, heapSize-1, 0);
			heapSize--;
			maxHeapify(0, heapSize);
		}

	}
	
	public BinaryTree getTree() {
		return tree;
	}
	public void setTree(BinaryTree tree) {
		this.tree = tree;
	}
	
	public void setTree(int [] array){
		this.tree = new BinaryTree(array);
	}
	
	private void maxHeapify(int node, int heapSize){
		if(tree.hasLeftChild(node)){
			int largestIndex = heapify(node, heapSize);
			if(largestIndex != node){
				 CommonLogics.swap(array, largestIndex, node);
				 maxHeapify(largestIndex, heapSize);
			}
		}
	}
	
	private int heapify(int node, int heapSize){
		int largestIndex = node;
		if(tree.getLeftIndex(node) < heapSize ){
			if(tree.hasLeftChild(node) && tree.getLeftValue(node) > array[largestIndex]){
				largestIndex = tree.getLeftIndex(node);
			}
	
			if(tree.hasRightChild(node) && tree.getRightIndex(node) < heapSize){
				if(tree.getRightValue(node) >  array[largestIndex]){
					largestIndex = tree.getRightIndex(node);
				}
			}
		}
		
		return largestIndex;

	}
}
