package com.tanghao.algo.study.test.datastructure;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.tanghao.algo.study.datastructure.Stack;

public class StackTest {
	private static final int STACK_SIZE = 5;
	private Stack stack;

	@Test
	public void testStack() {
		for(int i= 0; i <= STACK_SIZE; i++){
			stack.add(i);
			stack.printStack();
		}
		
		for(int i= 0; i < STACK_SIZE; i++){
			stack.pop();
			stack.printStack();
		}
	}

	@BeforeClass
	public void beforeClass() {
		stack = new Stack();
		stack.initialize(STACK_SIZE);
	}

}
