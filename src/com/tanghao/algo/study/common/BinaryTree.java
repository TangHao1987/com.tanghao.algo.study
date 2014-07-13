package com.tanghao.algo.study.common;

import java.util.LinkedList;

public class BinaryTree {
	private LinkedList<Integer> array;
	
	public BinaryTree(){
		
	}
	public BinaryTree(int [] array){
		this.array = new LinkedList<Integer>();
		for(int i : array){
			this.array.add(i);	
		}
	}
	
	public int getParentIndex(int index){
		if(index == 0){
			throw new IllegalArgumentException("No parent for the root index");
		}else{
			return (index -1)/2;
		}
	}
	
	public int getParentValue(int index){
			return array.get(getParentIndex(index));
	}
	
	public boolean hasLeftChild(int index){
		if(index*2 + 1 < array.size()){
			return true;
		}else{
			return false;
		}
	}
	
	public boolean hasRightChild(int index){
		if(index*2 + 2 < array.size()){
			return true;
		}else{
			return false;
		}
	}
	
	public boolean hasRoot(int index){
		if(index != 0){
			return true;
		}else{
			return false;
		}
	}
	
	public int getLeftIndex(int index){
		int leftIndex = index*2 + 1; 
		if(leftIndex < array.size()){
			return leftIndex;
		}else{
			throw new IllegalArgumentException("leftIndexOutOfArrayLength");
		}
	}
	public int getLeftValue(int index){
		return array.get(getLeftIndex(index));
	}
	
	public int getRightIndex(int index){
		int rightIndex = index*2 + 2; 
		if(rightIndex < array.size()){
			return rightIndex;
		}else{
			throw new IllegalArgumentException("RightIndexOutOfArrayLength");
		}
	}
	public int getRightValue(int index){
		return array.get(getRightIndex(index));
	}
	

}
