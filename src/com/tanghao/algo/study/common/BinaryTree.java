package com.tanghao.algo.study.common;

public class BinaryTree {
	private int [] array;
	
	public BinaryTree(){
		
	}
	public BinaryTree(int [] array){
		this.setArray(array);
	}
	
	public int getParentIndex(int index){
		if(index == 0){
			throw new IllegalArgumentException("No parent for the root index");
		}else{
			return (index -1)/2;
		}
	}
	
	public int getParentValue(int index){
			return array[getParentIndex(index)];
	}
	
	public boolean hasLeftChild(int index){
		if(index*2 + 1 < array.length){
			return true;
		}else{
			return false;
		}
	}
	
	public boolean hasRightChild(int index){
		if(index*2 + 2 < array.length){
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
		if(leftIndex < array.length){
			return leftIndex;
		}else{
			throw new IllegalArgumentException("leftIndexOutOfArrayLength");
		}
	}
	public int getLeftValue(int index){
		return array[getLeftIndex(index)];
	}
	
	public int getRightIndex(int index){
		int rightIndex = index*2 + 2; 
		if(rightIndex < array.length){
			return rightIndex;
		}else{
			throw new IllegalArgumentException("RightIndexOutOfArrayLength");
		}
	}
	public int getRightValue(int index){
		return array[getRightIndex(index)];
	}
	
	public int [] getArray() {
		return array;
	}
	public void setArray(int [] array) {
		this.array = array;
	}
}
