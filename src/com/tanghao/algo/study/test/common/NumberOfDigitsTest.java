package com.tanghao.algo.study.test.common;

import org.testng.AssertJUnit;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

import com.tanghao.algo.study.common.CommonLogics;

public class NumberOfDigitsTest {
  @Test
  public void testNumberOfDigit() {
	  int [] DESIGNED_INPUT = {3,142,5235,23,2312};
	  int [] DESIGNED_OUTPUT = {1,3,4,2,4};
	  int [] output = new int[DESIGNED_INPUT.length];
	  for(int index = 0; index < DESIGNED_INPUT.length ; index++){
		 output[index] = CommonLogics.getNumberOfDigits(DESIGNED_INPUT[index]);
	  }
	  
	  AssertJUnit.assertArrayEquals(DESIGNED_OUTPUT, output);
  }
  
  @Test(expectedExceptions={IllegalArgumentException.class})
  public void testNumberOfDigitIllegalInput(){
	 int input = -1231;
	 CommonLogics.getNumberOfDigits(input);
  }
  
  @BeforeGroups(groups={"digitMethods"} )
  public void digitCommonMethodsSetup(){
	  
  }

}
