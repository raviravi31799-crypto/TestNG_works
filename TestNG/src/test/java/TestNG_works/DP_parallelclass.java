package TestNG_works;

import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;

public class DP_parallelclass {
 
  	
  	
  	@DataProvider(name="testData",parallel=true)
  	public Object[][] dataprovfunc(){
  		return new Object[][] {{"Selenium"},{"TestNG"},{"Automation"}
  		};
  	}

}

  	
  	
  	
  	
  	
  	
  	
  	
  	
  	
  	
  	
  	
  	
  	
  	
  	
  	
  	
  	
  	
  	
  	
  	
  
