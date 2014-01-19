package com.tanghao.algo.study.app.sort.compare;

import com.tanghao.algo.study.common.CommonLogics;

/**
 * This class contained the implementation of the quick sort the class offers a
 * sort method and accessors for the data
 * 
 * @author Hao
 * 
 */
public class QuickSorter extends Sorter {
	@Override
	public void sort() {
		if (array != null && array.length > 0) {
			quickSort(0, array.length - 1);
		}
	}

	private void quickSort(int startIndex, int endIndex) {
		if (startIndex < endIndex) {
			int seperatePoint = partition(startIndex, endIndex);
			quickSort(startIndex, seperatePoint - 1);
			quickSort(seperatePoint, endIndex);
		}

	}

	private int partition(int startIndex, int endIndex) {
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

	public void printArray(){
		if(array != null && array.length > 0 ){
			System.out.println("The output of the array will be: ");
			for(int i : array){
				System.out.print(i + " ");
		}	
		}
	}

}