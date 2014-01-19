package com.tanghao.algo.study.app.selection;

import com.tanghao.algo.study.common.CommonLogics;

public class RandomSelector extends Selector {

	@Override
	public int select(int i) {
		// TODO Auto-generated method stub
		return randomSelect(0, array.length-1, i);
	}
	
	private int randomSelect(int startIndex, int endIndex, int pivot){
		if(startIndex == endIndex){
			return array[startIndex];
		}else{
			int partitionPoint = randomPartition(startIndex, endIndex);
			if(partitionPoint == pivot){
				return array[partitionPoint];
			}else if(pivot < partitionPoint){
				return randomSelect(startIndex, partitionPoint - 1, pivot);
			}else{
				return randomSelect(partitionPoint + 1, endIndex, pivot);
			}
		}
	}
	
	private int randomPartition(int startIndex, int endIndex){
		int i = startIndex - 1;
		int r = array[endIndex];
		for (int j = startIndex; j < endIndex; j++) {
			if (array[j] <= r) {
				i++;
				CommonLogics.swap(array, i, j);
			}
		}
		CommonLogics.swap(array, i+1, endIndex);
		return i+1;
	}
}
