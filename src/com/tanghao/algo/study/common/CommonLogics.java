package com.tanghao.algo.study.common;

public class CommonLogics {
	/**
	 * This method swap the two indexes in array
	 * @param array
	 * @param indexA
	 * @param indexB
	 */
	public static void swap(int[] array, int indexA, int indexB){
		if(array != null && array.length >1 && indexA != indexB){
			array[indexA] = (array[indexA])^(array[indexB]);
			array[indexB] = (array[indexA])^(array[indexB]);
			array[indexA] = (array[indexA])^(array[indexB]);
		}
	}
	
	
	/**
	 * This method return the number of digits of given integer.
	 * If the integer inputed is negative number, illegal argument exception will be thrown
	 * 
	 * @param integer
	 */
	public static int getNumberOfDigits(int integer){
		if(integer < 0){
			throw new IllegalArgumentException("input integer must be positive"); 
		}else if(integer == 0){
			return 1;
		}else{
			return (int)(Math.log10((double)integer) + 1);
		}
	}
	
	public static int getDigit(int integer, int digit){
		if(digit<1 || digit > getNumberOfDigits(integer)){
			throw new IllegalArgumentException("given digit:" + digit + " is out of range of input integer:" + integer);
		}else{
			 return (int)(integer/(Math.pow((double)10, (double)(digit-1))))%10;
		}
	}
}
