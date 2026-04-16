package TestNG_works;

import org.testng.annotations.Test;

public class Test_executionorder {
  @Test
  public void A() {
	  System.out.println("Hello");
  }
  @Test
  public void B(){
	  System.out.println("Hi");
  }
  @Test
  public void C() {
	  System.out.println("Welcome");
  }
}
