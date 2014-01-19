package com.tanghao.algo.study.app.sort.compare;

public abstract class Sorter implements ISorter {
	protected int[] array;

	public int[] getArray() {
		return array;
	}

	public void setArray(int[] array) {
		this.array = array;
	}

	public void printArray() {
		verifyArray();
		System.out.println("Array elements are: ");
		for (int i : array) {
			System.out.print(" " + i);
		}
		System.out.println();
	}

	private void verifyArray() {
		if (array == null || array.length == 0) {
			throw new IllegalArgumentException(
					"Input array can't be null or empty");
		}
	}
	
	public abstract void sort(); 

}
