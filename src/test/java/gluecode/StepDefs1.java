package gluecode;
import java.util.List;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.ComposePage;
import pages.HomePage;
import pages.LoginPage;
import pages.LogoutPage;

public class StepDefs1
{
	public HomePage hp;
	public LoginPage lp;
	public ComposePage cp;
	public LogoutPage lop;
	public WebDriverWait wait;
	public Shared sh; //"Shared" class can provide reusable objects of other classes
	
	//Constructor method can get "Shared" class object as argument from PICOcontainer
	public StepDefs1(Shared sh)
	{
		this.sh=sh;
	}
	
	//Operational methods or Step definitions with cucumber-java annotations
	@Given("^launch site using \"(.*)\"$")
	public void method1(String bn) throws Exception
	{
		sh.driver=sh.tu.openBrowser(bn);
		wait=sh.tu.defineWait(sh.driver);
		hp=new HomePage(sh.driver,wait);
		lp=new LoginPage(sh.driver,wait);
		cp=new ComposePage(sh.driver,wait);
		lop=new LogoutPage(sh.driver,wait);
		//Launch site by using url in properties file
		String url=sh.tu.getPropertyValue("url");
		sh.tu.lanuchSite(url);
	}
	
	@Then ("^tittle should be \"(.*)\"$")
	public void method2(String expected) 
	{
		String actual=sh.driver.getTitle();
		if(expected.equals(actual))
		{
			sh.s.log("Gmail title test passed");
			Assert.assertTrue(true); //TestNG
		}
		else
		{
			byte[] b=sh.driver.getScreenshotAs(OutputType.BYTES); //SWD
			sh.s.attach(b,"image/png","Gmail title test failed"); //cucumber-java
			Assert.assertTrue(false); //TestNG
		}
	}
	
	@And("quit site")  
	@ When("close site")
	public void method3()
	{
		sh.tu.closeSite();
	}
	
	@When("^enter userid as \"(.*)\"$")
	public void method4(String uid)
	{
		hp.uidfill(uid);
	}
	
	@And("click userid next button")
	public void method5()
	{
		hp.uidNextClick();
	}
	
	@Then("^Validate outcome related to given userid criterialike \"(.*)\"$")
	public void method6(String c)
	{
		try
		{
			if(c.equals("blank") && hp.isBlankuidError())
			{
				sh.s.log("Blank userid test passed");
			}
			else if(c.equals("invalid") && hp.isInvaliduidError())
			{
				sh.s.log("invalid userid test passed");
			}
			else if(c.equals("valid") && hp.isPasswordDisplayed())
			{
				sh.s.log("valid userid test passed");
			}
			else
			{	
				byte[] b=sh.driver.getScreenshotAs(OutputType.BYTES);
				sh.s.attach(b,"image/png","Blank userid test failed");
				Assert.assertTrue(false);
			}
		}
		catch(Exception ex) 
		{
			byte[] b=sh.driver.getScreenshotAs(OutputType.BYTES);
			sh.s.attach(b,"image/png","Blank userid test failed");
			Assert.assertTrue(false);
		}
	}
	
	@And("^enter password as \"(.*)\"$")
	public void method7(String p)throws Exception
	{
		lp.pwdFill(p);
		Thread.sleep(2000);
	}
	
    @And("click password next button")
    public void method8()throws Exception
	{
		lp.pwdNextClick();
		Thread.sleep(5000);
	}
    
    @Then("^Validate outcome related to given password criterialike\"(.*)\"$")
    public void method9(String pc)
	{
		try
		{
			if(pc.equals("blank") && lp.isBlankPwdError())
			{
				sh.s.log("Blank password test passed");
			}
			else if(pc.equals("invalid") && lp.isInvalidPwdError())
			{
				sh.s.log("invalid password test passed");
			}
			else if(pc.equals("valid") && cp.isComposeVisible())
			{
				sh.s.log("valid password test passed");
			}
			else
			{	
				byte[] b=sh.driver.getScreenshotAs(OutputType.BYTES);
				sh.s.attach(b,"image/png","Blank userid test failed");
				Assert.assertTrue(false);
			}
		}
		catch(Exception ex) 
		{
			byte[] b=sh.driver.getScreenshotAs(OutputType.BYTES);
			sh.s.attach(b,"image/png","Blank userid test failed");
			Assert.assertTrue(false);
		}
	}
    
        @And("send mail and test")
        public void method10(DataTable dt) throws Exception
        {
    	  List<List<String>> l=dt.asLists();
    	  //0th row(first row) in data table is having names of columns
    	  for(int i=1;i<l.size();i++)
    	  {
    		  Thread.sleep(5000);
    		  cp.clickCompose();
    		  cp.fillTo(l.get(i).get(0));
    		  cp.fillSubject(l.get(i).get(1));
    		  cp.fillBody(l.get(i).get(2));
    		  cp.attachment(l.get(i).get(3));
    		  cp.clickSend();
    		  //compose testing
    		  String msg=cp.getOutPutMessage();
    		  if(!msg.contains("Sorry"))
    		  {
    			  sh.s.log("Compose test passed");
    			  Assert.assertTrue(true);
    		  }
    		  else
    		  {
    			  byte[] b=sh.driver.getScreenshotAs(OutputType.BYTES);
  				  sh.s.attach(b,"image/png","Compose test failed");
  				  Assert.assertTrue(false);
    		  }
    	  }
        }
        
        @When("do logout")
        public void method11()
        {
        	lop.clickProfilePic();
        	lop.clickSignOut();
        }
	

}
