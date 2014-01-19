package com.tanghao.algo.study.test.linearsort;

import org.testng.AssertJUnit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tanghao.algo.study.app.sort.compare.ISorter;
import com.tanghao.algo.study.app.sort.linearsort.RadixSorter;

public class RadixSorterTest {
	
	public final int [] EXPECTED_INPUT_ARRAY = {123,245,323,445,563,275,935,234,567,324,203};
	public final int [] EXPECTED_OUTPUT_ARRAY ={123,203,234,245,275,323,324,445,563,567,935};
	public final int EXPECTED_NO_OF_DIGITS = 3; 
	private ISorter sorter;
	
 	  @BeforeMethod
	  public void beforeMethod() {
		  sorter = new RadixSorter(EXPECTED_INPUT_ARRAY,EXPECTED_NO_OF_DIGITS);
	  }

	  @AfterMethod
	  public void afterMethod() {
		  getSorter().printArray();
	  }
	
	@Test
	public void testRadixSorter() {
		sorter.sort();
		AssertJUnit.assertArrayEquals(EXPECTED_OUTPUT_ARRAY, sorter.getArray());
	}

	public ISorter getSorter() {
		return sorter;
	}

	public void setSorter(ISorter sorter) {
		this.sorter = sorter;
	}
}
