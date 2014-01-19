package com.tanghao.algo.study.test.sort;

import org.testng.AssertJUnit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tanghao.algo.study.app.sort.compare.ISorter;
import com.tanghao.algo.study.app.sort.compare.QuickSorter;

public class QuickSorterTest {
	private ISorter sorter;
	public static final int[] EXPECTED_OUTPUT_ARRAY = {0,1,2,3,4,5,6,7,8,9};
	public static final int[] INPUT_ARRAY ={1,5,7,9,2,4,6,8,3,0};

  @BeforeMethod
  public void beforeMethod() {
	  sorter.setArray(INPUT_ARRAY);
  }

  @AfterMethod
  public void afterMethod() {
	  sorter.printArray();
  }

  @BeforeClass
  public void beforeClass() {
	  sorter = new QuickSorter();
  }


  @Test
  public void sort() {
	  sorter.sort();
	  AssertJUnit.assertArrayEquals(sorter.getArray(),EXPECTED_OUTPUT_ARRAY);
  }
}
