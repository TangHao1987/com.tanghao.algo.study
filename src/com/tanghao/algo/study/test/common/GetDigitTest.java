package com.tanghao.algo.study.test.common;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.tanghao.algo.study.common.CommonLogics;

public class GetDigitTest {
  @Test
  public void testGetDigit() {
	  int inputValue1 = 3;
	  int inputDigit1 = 1;
	  int exceptedOutput1 = 3;
	  int inputValue2 = 14;
	  int inputDigit2 = 2;
	  int exceptedOutput2 = 1;
	  int inputValue3 = 2320;
	  int inputDigit3 = 3;
	  int exceptedOutput3 = 3;
	  int inputValue4 = 0;
	  int inputDigit4 = 1;
	  int exceptedOutput4 = 0;
	  
	  int output1 = CommonLogics.getDigit(inputValue1, inputDigit1);
	  Assert.assertEquals(output1, exceptedOutput1);
	  
	  int output2 = CommonLogics.getDigit(inputValue2, inputDigit2);
	  Assert.assertEquals(output2, exceptedOutput2);
	  
	  int output3 = CommonLogics.getDigit(inputValue3, inputDigit3);
	  Assert.assertEquals(output3, exceptedOutput3);
	  
	  int output4 = CommonLogics.getDigit(inputValue4, inputDigit4);
	  Assert.assertEquals(output4, exceptedOutput4);
  }
  
  @Test(expectedExceptions={IllegalArgumentException.class})
  public void testGetDigitException(){
	  int inputValue = 123;
	  int inputDigit = -3;
	  CommonLogics.getDigit(inputValue, inputDigit);
  }
}
