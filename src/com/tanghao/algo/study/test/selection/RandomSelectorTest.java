package com.tanghao.algo.study.test.selection;

import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

import com.tanghao.algo.study.app.selection.ISelector;
import com.tanghao.algo.study.app.selection.RandomSelector;

public class RandomSelectorTest {
	private ISelector selector;
	public static final int [] INPUT_ARRAY = {2,5,1,4,8,6,7,3};
	public static final int INPUT_INDEX = 4;
	public static final int EXPECTED_OUTPUT = 5;
  @BeforeMethod
  public void beforeMethod() {
	  selector = new RandomSelector();
	  selector.setArray(INPUT_ARRAY);
  }

  @AfterMethod
  public void afterMethod() {
	  
  }


  @Test
  public void select() {
    int output = selector.select(INPUT_INDEX);
    AssertJUnit.assertEquals(EXPECTED_OUTPUT, output);
  }
}
