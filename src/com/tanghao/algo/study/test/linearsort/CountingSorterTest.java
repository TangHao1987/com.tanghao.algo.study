package com.tanghao.algo.study.test.linearsort;

import org.testng.AssertJUnit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tanghao.algo.study.app.sort.compare.ISorter;
import com.tanghao.algo.study.app.sort.linearsort.CountingSorter;

public class CountingSorterTest {
	private ISorter sorter;
	public static final int[] EXPECTED_OUTPUT_ARRAY = {0,0,0,1,1,2,2,2,3,3,5,5};
	public static final int[] INPUT_ARRAY ={1,2,3,0,2,5,3,2,5,1,0,0};
	public static final int INPUT_RANGE = 6;

  @BeforeMethod
  public void beforeMethod() {
	  sorter = new CountingSorter(INPUT_ARRAY, INPUT_RANGE);
  }

  @AfterMethod
  public void afterMethod() {
	  sorter.printArray();
  }

  @Test
  public void sort() {
	  sorter.sort();
	  AssertJUnit.assertArrayEquals(sorter.getArray(),EXPECTED_OUTPUT_ARRAY);
  }
}
