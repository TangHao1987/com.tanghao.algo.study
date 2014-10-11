package com.tanghao.algo.study.common.tree;

public class TreeNode<T extends Comparable<T>> {
	public static final int NULL_INDEX = -1;
	private T value;
	private int index;
	private TreeNode<T> leftChild;
	private TreeNode<T> rightChild;
	private TreeNode<T> parent;
	
	public TreeNode(T value) {
		super();
		this.value = value; 
		this.index = IndexGenerator.generateIndex();
		this.parent = null;
		this.leftChild = null;
		this.rightChild = null;
	}
	public T getValue() {
		return value;
	}
	public void setValue(T value) {
		this.value = value;
	}
	
	public TreeNode<T> getLeftChild() {
		return leftChild;
	}
	public void setLeftChild(TreeNode<T> leftChild) {
		this.leftChild = leftChild;
	}

	public TreeNode<T> getRightChild() {
		return rightChild;
	}
	public void setRightChild(TreeNode<T> rightChild) {
		this.rightChild = rightChild;
	}

	public int getIndex() {
		return index;
	}

	public TreeNode<T> getParent() {
		return parent;
	}
	
	public void setParent(TreeNode<T> parent) {
		this.parent = parent;
	}
	
	@Override
	public boolean equals(Object o){
		if(o instanceof TreeNode){
			@SuppressWarnings("rawtypes")
			TreeNode node = (TreeNode)o;
			if(node.getIndex() == this.index){
				return true;
			}
		}
		return false;
		
	}
	
	@Override
	public int hashCode(){
		return index*31;
	}



	private static class IndexGenerator{
		private static int index = 0;
		static int generateIndex(){
			return index ++;
		}
	}
	
	public String toString(){
		StringBuffer sb = new StringBuffer("");
		sb.append("{");
		sb.append("Index: ").append(index).append(", ");
		sb.append("Parent: ").append(parent).append(", ");
		sb.append("LeftChild: ").append(leftChild).append(", ");
		sb.append("RightChild: ").append(rightChild).append(", ");
		sb.append("}");
		return sb.toString();
	}
}
