package Logic_PKG;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;

import BaseClass_PKG.Base_methods;
import Locators_PKG.Test_Locators;


public class Test_Logic extends Test_Locators
{
	Test_Locators tl= new Test_Locators();
	Base_methods bm= new Base_methods();
	
	public boolean Logic_timeSheets() throws InterruptedException
	{
		boolean title_status=false;
		log.info("*** Test Case Logic_timeSheets Started Excuting ***");
    	test = extent.createTest("TimeSheet TestCase1");
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		Thread.sleep(1000);
		log.info("*** Clicking on TimeSheet ***");
		tl.Click_On_Timesheets().click();
		test.info("******** Clicked on TimeSheet ********");
		bm.ScreenShot();
		test.info("ScreenShot Captured for TestCase1");
		String ActualTitle=driver.getTitle();
		title_status=ActualTitle.equalsIgnoreCase(ExpectedTitle);
		test.pass("Sucessfully clicked on TimeSheets");
		return title_status;
		
		
	}
	
	public boolean Logic_On_StatusSummary() throws InterruptedException
	{
		test = extent.createTest("StatusSummary TestCase2");
		log.info("*** Test Case Logic_On_StatusSummary Started Excuting ***");
      	test.info("******** Test Case Logic_On_StatusSummary Started Excuting ********");
		log.info("*** Entering Summary Text ***");
		test.info("******** Entering Summary Text ********");
     	tl.Click_On_StatusSummary().sendKeys("Good in Techinical Support");
     	log.info("*** Entered Summary Text ***");
		test.info("******** Entered Summary Text ********");
		test.pass("Sucessfully Entered Text on Status Summary");
		return true;
	
		
	}
	public boolean Logic_On_Achivements() throws InterruptedException
	{
		test = extent.createTest("Achivements TestCase3");
		log.info("*** Test Case Logic_On_Acheivements Started Excuting ***");
		test.info("******** Test Case Logic_On_Acheivements Started Excuting ********");
		log.info("*** Entering Acheivements Text ***");
		test.info("******** Entering Acheivements Text ********");
     	tl.Click_On_acheivements().sendKeys("Good in Achievements Support");
     	log.info("*** Entered Achievements Text ***");
		test.info("******** Entered Achievements Text ********");
		test.pass("Sucessfully Entered Text on Acheivements");
		return true;
		
	}
	public boolean Logic_On_FocusPlans() throws InterruptedException
	{
		test = extent.createTest("Logic_On_RisksandIssues");
		log.info("*** Test Case Logic_On_RisksandIssues Started Excuting ***");
		test.info("******** Test Case Logic_On_RisksandIssues Started Excuting ********");
		log.info("*** Entering RisksandIssues Text ***");
		test.info("******** Entering RisksandIssues Text ********");
		try
		{
     	
			tl.Click_On_FocusPlan().sendKeys("Good in Focusplan Support");
			log.info("*** Entered RisksandIssues Text ***");
			test.info("******** Entered RisksandIssues Text ********");	
			test.pass("Sucessfully Entered Text on RisksandIssues");
		}
		catch(Exception e)
		{
			test.fail("No such Elemnt located Due to wrong Locator ");
		}
     	
		return true;
		
	}

}
