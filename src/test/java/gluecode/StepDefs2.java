package gluecode;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.cucumber.java.en.And;
import pages.ComposePage;
import pages.HomePage;
import pages.LoginPage;



public class StepDefs2 
{
	//Declare objects to page classes and other required classes
	public HomePage hp;
	public LoginPage lp;
	public ComposePage cp;
	public WebDriverWait wait;
	public Shared sh; //"Shared" class can provide reusable objects of other classes
	
	//Constructor method can get "Shared" class object as argument from PICOcontainer
	public StepDefs2(Shared sh)
	{
		this.sh=sh;
	}
	
	//Operational methods or Step definitions with cucumber-java annotations
	@And("send mail and test by taking data from excel")
	public void method13() throws Exception
	{
		cp=new ComposePage(sh.driver,wait);
		//Open Excel file in read mode
		FileInputStream fi=new FileInputStream("src\\test\\resources\\testdata\\Book1.xlsx");
		Workbook wb=WorkbookFactory.create(fi);
		Sheet sheet=wb.getSheet("Sheet1");
		int nour=sheet.getPhysicalNumberOfRows();
		//0th row(first row) in excel file sheet is having names of columns
		for(int i=1;i<nour;i++)
		{
			DataFormatter df=new DataFormatter();
			String to=df.formatCellValue(sheet.getRow(i).getCell(0));
			String subj=df.formatCellValue(sheet.getRow(i).getCell(1));
			String body=df.formatCellValue(sheet.getRow(i).getCell(2));
			String attach=df.formatCellValue(sheet.getRow(i).getCell(3));
			Thread.sleep(10000);
			cp.clickCompose();
			cp.fillTo(to);
			cp.fillSubject(subj);
			cp.fillBody(body);
			cp.attachment(attach);
			Thread.sleep(5000);
			cp.clickSend();
			//Compose testing 
			String  msg=cp.getOutPutMessage();
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
		//close excel file
		wb.close();
		fi.close();
	}
}
