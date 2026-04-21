package TestNG_works;

import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;

public class DP_class3 {
  @Test(dataProvider = "dp")
  public void f( String keyword) {
  }

  @DataProvider(name="testData")
  public Object[][] dataProvFunc() {
    return new Object[][]{
      new Object[] { "Selenium" },
      new Object[] { "TestNG" },
      new Object[] {"Java"}
    };
  }
}
