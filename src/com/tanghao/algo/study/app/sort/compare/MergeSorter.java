package com.tanghao.algo.study.app.sort.compare;

public class MergeSorter extends Sorter {

	@Override
	public void sort() {
		// TODO Auto-generated method stub
		mergeSort(0, array.length-1);
	}
	
	private void mergeSort(int startIndex, int endIndex){
		if(startIndex < endIndex){
			int midPoint = (startIndex + endIndex)/2;
			mergeSort(startIndex, midPoint);
			mergeSort(midPoint + 1, endIndex);
			merge(startIndex,endIndex,midPoint);
		}
	}

	private void merge(int startIndex, int endIndex, int midPoint) {
		// TODO Auto-generated method stub
		int leftLength = midPoint - startIndex + 1;
		int rightLength = endIndex - midPoint;
		int [] leftArray = new int [leftLength];
		int [] rightArray = new int [rightLength];
		int leftIndex = 0;
		int rightIndex = 0;
		for(int i = startIndex; i <= endIndex; i ++){
			if(i <= midPoint){
				leftArray[i - startIndex] = array[i];
			}else{
				rightArray[i - midPoint -1] = array[i];
			}
		}
		
		for(int i = startIndex; i <= endIndex; i ++){
			if(leftIndex  == leftLength){
				array[i] = rightArray[rightIndex];
				rightIndex++;
			}else if(rightIndex == rightLength){
				array[i] = leftArray[leftIndex];
				leftIndex++;
			}else if(leftArray[leftIndex] < rightArray[rightIndex]){
				array[i] = leftArray[leftIndex];
				leftIndex++;
			}else{
				array[i] = rightArray[rightIndex];
				rightIndex++;
			}
			
		}
	}

}
