package TestNG_works;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Assertions {
  @Test
  public void data() {
	  String str1=new String("TestNG");
	  String str2=new String("TestNG");
	  String str3=null;
	  String str4="TestNG";
	  String str5="TestNG";
	  String str6=new String("Not_TestNG");
	  int val1=5;
	  int val2=6;
	  //check objects are equal
	  Assert.assertEquals(str1, str2);	 
	  System.out.println("Equals Assertion is successful");
	  
	  //Check objects are not equal
	  Assert.assertNotEquals(str1, str6);	 
	  System.out.println("NotEquals Assertion is successful");
	  
	  
	  //check condition is true
	  Assert.assertTrue(val1<val2);	 
	  System.out.println("True Assertion is successful");
	   
	  //check condition is false
	  Assert.assertFalse(val1> val2);	 
	  System.out.println("False Assertion is successful");
	  
	  //check object is not null
	  Assert.assertNotNull(str1);	 
	  System.out.println("NotNull Assertion is successful");
	  
	  //check object is null
	  Assert.assertNull(str3);	 
	  
	  
	  //check two object references are same 
	  Assert.assertSame(str4, str5);	 
	  System.out.println("Same Assertion is successful");
	  
	  //check two object references are not same 
	  Assert.assertNotSame(str1, str5);	 
	  System.out.println("NotSame Assertion is successful");
  }
  
}
