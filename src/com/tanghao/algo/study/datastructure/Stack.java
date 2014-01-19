package com.tanghao.algo.study.datastructure;

public class Stack {
	private static int SIZE;
	private int[] array;
	private int last = 0;

	public void initialize(int size) {
		if (size <= 0) {
			throw new IllegalArgumentException(
					"The Size must be a positive integer");
		}

		SIZE = size;
		array = new int[SIZE];
	}

	public void add(int value) {
		if (last == array.length) {
			System.out
					.println("array is full. Current number of elements in array is: "
							+ last);
		} else {
			array[last++] = value;
		}
	}

	public int pop() {
		if (isEmply()) {
			throw new IllegalArgumentException("Stack is emply.");
		}
		return array[--last];
	}

	public boolean isEmply() {
		if (last == 0) {
			return true;
		} else {
			return false;
		}
	}

	public void clean() {
		last = 0;
	}

	public static int getSIZE() {
		return SIZE;
	}

	public void printStack() {
		if (isEmply()) {
			System.out.println("Stack is emply.");
		} else {
			System.out.print("[");
			for (int i = 0; i < last; i++) {
				System.out.print(array[i]);
			}
			System.out.println("]");
		}
	}

}
