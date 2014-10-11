package com.tanghao.algo.study.test.datastructure.linkedlist;

import java.util.Iterator;
import org.junit.Assert;
import org.junit.Test;

import com.tanghao.algo.study.datastructure.linklist.Bag;

public class BagTest {

	@Test
	public void test() {
		Bag<Integer> newBag = new Bag<Integer>();
		//add list [4,1,5,7,2,4] into Bag
		Integer[] testInput = {4,1,5,7,2,4};
		for(Integer input: testInput){
			newBag.add(input);	
		}
		//test add and Iterator return number are all correct
		assertAllElements(newBag, testInput);

		//test remove first elements
		Iterator<Integer> iterator = newBag.iterator();
		iterator.remove();
		iterator.next();
		iterator.remove();
		//remove first 
		Integer[] expectedOutput = {4,1,5,2};
		assertAllElements(newBag, expectedOutput);
	}
	
	private void assertAllElements(Bag<Integer> newBag, Integer[] testInput){
		Iterator<Integer> iterator = newBag.iterator();
		for(int i = testInput.length -1; i == 0 ; i--){
			Assert.assertEquals(testInput[i], iterator.next());
		}
	}
}
