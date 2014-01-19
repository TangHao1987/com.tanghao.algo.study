package com.tanghao.algo.study.app.sort.linearsort;

import com.tanghao.algo.study.app.sort.compare.Sorter;
import com.tanghao.algo.study.common.CommonLogics;

public class RadixSorter extends Sorter{
	private int maxDigit;
	public final int DIGIT_RANGE = 10;
	public RadixSorter(int [] array, int maxDigit){
		this.array = array;
		this.maxDigit = maxDigit;
	}
	@Override
	public void sort() {
		// TODO Auto-generated method stub
		int [] countingArray = new int [DIGIT_RANGE];
		int [] outputArray = new int [array.length];
		for(int i= 1; i <= maxDigit; i++){
			array = (countingSortWithDigit(outputArray,countingArray,i)).clone();
		}
	}
	
	public int getMaxDigit() {
		return maxDigit;
	}
	public void setMaxDigit(int maxDigit) {
		this.maxDigit = maxDigit;
	}
	private int[] countingSortWithDigit(int[] outputArray, int[] countingArray, int digit) {
		//First Step: count the Integer number and put each Integer count Into countingArray[Integer]
		for(int i = 0; i < DIGIT_RANGE; i++){
			countingArray[i] = 0;
		}
		
		for(int i = 0; i < array.length; i++){
			countingArray[CommonLogics.getDigit(array[i], digit)]++;
		}
		//Second Step: get the Counting of sum of all the Integers <= current Integer and put Into CountingArray[Integer]
		for(int i = 1; i < DIGIT_RANGE; i++){
			countingArray[i] = countingArray[i] + countingArray[i-1];
		}
		//Third Step: push the result in to output array element by element from input array
		//the looping sequence must start from last element in array down to first element to keep output array is stable
		for(int i = array.length -1 ; i >=0 ; i--){
			//DEBUGED: counting value is leading 1 to the array index, minus one is necessary to get correct Output Index
			outputArray[countingArray[CommonLogics.getDigit(array[i], digit)] - 1] = array[i];
			countingArray[CommonLogics.getDigit(array[i], digit)]--;
			
		}
		return outputArray;
	}
}
