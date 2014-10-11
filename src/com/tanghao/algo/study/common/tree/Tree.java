package com.tanghao.algo.study.common.tree;


public abstract class Tree<T extends Comparable<T>>{
	public final static int PREFIX_MARGIN = 5;
	public final static char PREFIX_CHAR = '|';
	public final static char SAPCE_CHAR = ' ';
	public final static String NULL_STRING = "NIL";
	private TreeNode<T> root;
	protected Tree(TreeNode<T> root){
		if(root == null){
			throw new IllegalArgumentException("Root can't be null");
		}
		this.root = root;
		this.root.setParent(null);
	}
	
	
	
	protected void transplant(TreeNode<T> node, TreeNode<T> newNode){
		//as this operation is only for the node in the system, 
		//so the node check for them must be performed first to ensure the safely
		if(node == root){
			root = newNode;
			newNode.setParent(null);
		}else{
			TreeNode<T> parentNode = node.getParent();
			if(parentNode.getLeftChild() == node){
				parentNode.setLeftChild(newNode);
			}else{
				parentNode.setRightChild(newNode);
			}
			newNode.setParent(parentNode);
		}
	}
	
	public int getLevel(TreeNode<T> node){
		if(node.getParent() == null){
			return 0;
		}else{
			return 1 + getLevel(node.getParent());
		}
	}
	
	public int getLevelReverse(TreeNode<T> node){
		return getDeep() - getLevel(node);
	}
	
	public int getDeep(){
		return getNodeDeep(getRoot());
	}

	private int getNodeDeep(TreeNode<T> node) {
		int leftDeep = 0;
		int rightDeep = 0;
		if(node.getLeftChild() != null){
			leftDeep = 1 + getNodeDeep(node.getLeftChild());
		}
		if(node.getRightChild() != null){
			leftDeep = 1 + getNodeDeep(node.getRightChild());
		}
		return leftDeep>rightDeep?leftDeep:rightDeep;
	}
	
	protected boolean isRoot(int index){
		if(root.getIndex() == index){
			return true;
		}else{
			return false;
		}
	}

	

	
	
	
	public int size(){
		return subTreeSize(root);
	}  
	
	private int subTreeSize(TreeNode<T> node){
		int startSize = 1;
		if(node.getLeftChild()!= null){
			TreeNode<T> leftChild = node.getLeftChild();
			startSize += subTreeSize(leftChild);
		}
		if(node.getRightChild()!= null){
			TreeNode<T> rightChild = node.getRightChild();
			startSize += subTreeSize(rightChild);
		}
		return startSize;
	} 
	
	protected TreeNode<T> getRoot(){
		return root;
	}
	
	private void printTreeLine(int start, int end, TreeNode<T> node, int last){
		int toPrintNumber = (start + end)/2;
		if(start == PREFIX_MARGIN){
			for (int i = 0; i < start; i++) {
				System.out.print(PREFIX_CHAR);
			}
		}
		for(int i = start; i < end; i++){
			if(i == toPrintNumber){
				String toBePrint = "";
				System.out.print(SAPCE_CHAR);
				if(node.getValue() != null){
					toBePrint = node.getValue().toString();	
				}else{
					toBePrint = NULL_STRING;
				}
				System.out.print(toBePrint);
				i+= toBePrint.length();
			}else{
				System.out.print(SAPCE_CHAR);
			}
		}
		if(end == last){
			System.out.print("\n");
		}
		if(node.getLeftChild() != null){
			printTreeLine(start, toPrintNumber, node.getLeftChild(), last);
		}
		if(node.getRightChild()!= null){
			printTreeLine(toPrintNumber+1, end, node.getLeftChild(), last);
		}
	}
	
}
