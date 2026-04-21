package Parameter;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Test_1 {
  @Test
  @Parameters({"val1","val2"})
  public void sum(int v1,int v2) {
	  int sum=v1+v2;
	  System.out.println(sum) ;
	  
  }
}
