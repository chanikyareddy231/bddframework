package gluecode;

import org.openqa.selenium.remote.RemoteWebDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utilities.TestUtility;

public class Shared 
{
	  //Global object related to all step definition classes
      public RemoteWebDriver driver;
      public Scenario s; //cucumber-java class to generate HTML report in scenario wise
      public TestUtility tu; //method to be executed before every "Scenario" or "ScenarioOutline:" iteration
      
      @Before
      public void method1(Scenario s) throws Exception
      {
    	  //define driver object as null by default
    	  driver=null;
    	  //create "scenario" class object to work for current "Scenario" or "ScenarioOutline:" 
    	  this.s=s;
    	  //create object to testutility class
    	  tu=new TestUtility();
      }
      
      @After
      public void method2(Scenario s)
      {
    	  s.log(s.getName()+" is Completed");
      }
}
