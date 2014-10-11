package com.tanghao.algo.study.common.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TreePrinter<T extends Comparable<T>> {
	private final HashMap<Integer, ArrayList<posValueSet<T>>> posValueMap = new HashMap<>();	
	private final int size; 
	
	public TreePrinter(Tree<T> tree) {
		super();
		TreeNode<T> root = tree.getRoot();
		addSubTreeToList(tree, root);
		size = getPrintWidth(tree);
	}
	
	private int getPrintWidth(Tree<T> tree){
		int i = 1;
		int shiftSize = tree.getDeep() + 1;
		return i<<shiftSize;
	}
	
	private void addSubTreeToList(Tree<T> tree, TreeNode<T> node) {
		// TODO Auto-generated method stub
		int level = tree.getLevel(node);
		if(posValueMap.containsKey(level) == false){
			posValueMap.put(level, new ArrayList<posValueSet<T>>());
		}
		ArrayList<posValueSet<T>>  levelList = posValueMap.get(level);
		int position = getNodePosition(tree, node);
		posValueSet<T> nodePVSet = new posValueSet<T>(position, node.getValue());
		if(levelList.contains(nodePVSet) == false){
			levelList.add(nodePVSet);
		}
		if(node.getLeftChild()!=null){
			addSubTreeToList(tree, node.getLeftChild());
		}
		if(node.getRightChild()!=null){
			addSubTreeToList(tree, node.getRightChild());
		}
	}
	
	public void printOnConsole(){
		int level = 0;
		while(posValueMap.containsKey(level)){
			List<posValueSet<T>> pvSetList = posValueMap.get(level);
			for(int i = 1 ; i<= size; i++){
				T value = getPositionValue(pvSetList, i);
				if(value != null){
					String valueString = value.toString();
					int stringLength = valueString.length();
					System.out.print(valueString);
					i += (stringLength -1);
				}else{
					System.out.print(" ");
				}
			}
			System.out.println();
			level++;
		}
	}
	
	private T getPositionValue(List<posValueSet<T>> pvList, int position){
		for(posValueSet<T> pv : pvList){
			if(pv.position == position){
				return pv.value;
			}
		}
		return null;
	}
	
	public int getNodePosition(Tree<T> tree, TreeNode<T> node){
		int currentValue = (int)Math.pow(2, tree.getLevelReverse(node));
		if(node.getParent()!=null){
			if(node.getParent().getRightChild()!=null && node.getParent().getRightChild().equals(node)){
				currentValue += getNodePosition(tree, node.getParent()); 
			}else{
				currentValue = getNodePosition(tree, node.getParent()) - currentValue; 
			}
		}
		return currentValue;
	}

	private class posValueSet<T>{
		private int position;
		private T value;
			
		public posValueSet(int position, T value) {
			super();
			this.position = position;
			this.value = value;
		}

		@Override
		public boolean equals(Object obj) {
			// TODO Auto-generated method stub
			if(obj instanceof posValueSet){
				posValueSet pvs = (posValueSet)obj;
				if(pvs.position == this.position){
					return true;		
				}
			}
			return false;
		}
		
		@Override
		public int hashCode(){
			return position*31;
		}
	}
}