package com.tanghao.algo.study.app.sort.linearsort;

import com.tanghao.algo.study.app.sort.compare.Sorter;

/**
 * Counting sort running on Big-thera(n+k) focus on small range of integers sorting problem
 * where n is the length of input array and k is the range of input integers 
 * e.g. INPUT [1,0,3,2,2,3,2,1,0]
 * n == 9 as INPUT.length == 9 
 * k == 4 as only 0,1,2,3 in the INPUT array
 * @author Hao
 *
 */
public class CountingSorter extends Sorter{
	private int range;
	
	public CountingSorter(int [] array, int range){
		this.array = array;
		this.range = range;
	}
	
	@Override
	public void sort() {
		int [] outputArray = new int [array.length];
		int [] countingArray = new int [range];
		
		array = countingSort(outputArray, countingArray);
	}
	
	private int[] countingSort(int[] outputArray, int[] countingArray) {
		//First Step: count the Integer number and put each Integer count Into countingArray[Integer]
		for(int i = 0; i < array.length; i++){
			countingArray[array[i]]++;
		}
		//Second Step: get the Counting of sum of all the Integers <= current Integer and put Into CountingArray[Integer]
		for(int i = 1; i < range; i++){
			countingArray[i] = countingArray[i] + countingArray[i-1];
		}
		//Third Step: push the result in to output array element by element from input array
		//the looping sequence must start from last element in array down to first element to keep output array is stable
		for(int i = array.length -1 ; i >=0 ; i--){
			//DEBUGED: counting value is leading 1 to the array index, minus one is necessary to get correct Output Index
			outputArray[countingArray[array[i]] - 1] = array[i];
			countingArray[array[i]]--;
		}
		return outputArray;
	}

	public int getRange() {
		return range;
	}
	public void setRange(int range) {
		this.range = range;
	}

}
