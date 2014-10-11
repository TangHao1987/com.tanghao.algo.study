package com.tanghao.algo.study.common.tree;

public class BinaryTree<T extends Comparable<T>> extends Tree<T> {

	protected BinaryTree(TreeNode<T> root) {
		super(root);
		// TODO Auto-generated constructor stub
	}

	public void add(T value) {
		if(value == null){
			return;
		}
		addOnNode(getRoot(), value);
	}
	
	private void addOnNode(TreeNode<T> node, T value){
		T nodeValue = node.getValue();
		if(nodeValue.compareTo(value) <= 0){
			if(node.getRightChild() == null){
				TreeNode<T> newNode = new TreeNode<T>(value);
				newNode.setParent(node);
				node.setRightChild(newNode);
			}else{
				TreeNode<T> rightNode = node.getRightChild();
				addOnNode(rightNode,value);
			}
		}else{
			if(node.getLeftChild() == null){
				TreeNode<T> newNode = new TreeNode<T>(value);
				newNode.setParent(node);
				node.setLeftChild(newNode);
			}else{
				TreeNode<T> leftNode = node.getLeftChild();
				addOnNode(leftNode,value);
			}
		}	
	}
	
	public boolean remove(T value){
		TreeNode<T> node = getNode(getRoot(), value);
		return remove(node);
	}
	
	private TreeNode<T> getNode(TreeNode<T> subNode,  T value){
		if(subNode.getValue().equals(value)){
			return subNode;
		}
		if(subNode.getLeftChild()!=null){
			TreeNode<T> node = getNode(subNode.getLeftChild(), value);
			if(node != null){
				return node;
			}
		}
		
		if(subNode.getRightChild()!=null){
			TreeNode<T> node = getNode(subNode.getRightChild(), value);
			if(node != null){
				return node;
			}
		}
		return null;
	}

	public boolean remove(TreeNode<T> node) {
		if (node.getLeftChild() == null
				&& node.getRightChild() == null && node.getParent() == null) {
			throw new IllegalStateException(
					"node is not able to be remove as it's last element in the trees");
		}else if(node.getLeftChild() == null && node.getRightChild() == null){
			TreeNode<T> parentNode = node.getParent();
			if(parentNode.getLeftChild() != null && parentNode.getLeftChild().equals(node)){
				parentNode.setLeftChild(null);
			}else{
				parentNode.setRightChild(null);
			}
			node.setParent(null);
		} else if (node.getRightChild() == null) {
			TreeNode<T> newNode = node.getLeftChild();
			transplant(node, newNode);
		} else if (node.getLeftChild() == null) {
			TreeNode<T> newNode = node.getRightChild();
			transplant(node, newNode);
		} else {
			TreeNode<T> rightChild = node.getRightChild();
			TreeNode<T> rightMinimal = findMinimal(rightChild);
			TreeNode<T> leftChild = node.getLeftChild();

			leftChild.setParent(rightMinimal);
			rightMinimal.setLeftChild(leftChild);
			transplant(node, rightChild);
		}
		return true;
	}

	public TreeNode<T> findMinimal(TreeNode<T> node) {
		if (node == null) {
			return null;
		}
		TreeNode<T> currentNode = node;
		while (currentNode.getLeftChild() != null) {
			currentNode = currentNode.getLeftChild();
		}
		return currentNode;
	}

}
