package com.tanghao.algo.study.app.sort.compare;

import com.tanghao.algo.study.common.CommonLogics;

public class InsertionSorter extends Sorter{

	@Override
	public void sort() {
		for(int i = 0 ; i < getArray().length - 1 ; i++){
			int smaillest = getSmallest(i);
			if(smaillest != i){
				CommonLogics.swap(array, i, smaillest);
			}
		}
	}

	private int getSmallest(int i) {
		if(i == array.length - 2){
			return array.length -1;
		}else{
			int smallest = i;
			for(int j = i+1; j < array.length;j++){
				if(array[j] < array[smallest]){
					smallest = j;
				}
			}
			return smallest;
		}
	}
	
}
