package BaseClass_PKG;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import ContentManagement_PKG.Content_Inf;

public class Base_methods 
{
	    public static  WebDriver driver;
	    
      	public static String ExpectedTitle="Pinion Intranet";
        public static String ExpectedUrl="https://apps.pinion.services/Timesheet/Timesheets.aspx";
        
	    String browser="FireFox";
		
	    public static Logger log= LogManager.getLogger(Base_methods.class);
	    
		public static ExtentReports extent;
	    public static  ExtentSparkReporter sparkreport;
	    public static ExtentTest test;
	    
		@BeforeSuite
		public void ExtentReport_Demo() 
		{
			 log.info("*** BeforeSuite  Started Excuting ***");
			 sparkreport =new ExtentSparkReporter("./Reports//TestAutomationReport.html");
		     extent= new ExtentReports();
			 extent.attachReporter(sparkreport);
			 log.info("BeforeSuite Ended");
		}
		@BeforeTest
		public void Browser_Init()
		{		 
     		log.info("*** Before Test Started Excuting ***");
			if(browser.equalsIgnoreCase("Firefox"))
			{
				System.setProperty("webdriver.gecko.driver", "C://Drivers//local//geckodriver.exe");
				driver=new FirefoxDriver();
     			log.info("*** Opened Firefox Browser ***");
				driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
				log.info(" ***Before Test Ended ***");
			}
			else
			{
				System.setProperty("webdriver.chrome.driver", "C://Drivers//local//chromedriver.exe");
				driver=new ChromeDriver();
    			log.info("*** Opened Chrome Browser ***");			
			}
		}
		@BeforeClass
		public void TestLogin() throws InterruptedException
		{
			log.info(" *** Before Class Started Excuting ***");
			driver.get(Content_Inf.Pinion_Url);
			log.info("*** Pinion Url Entered ***");
			driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
			driver.findElement(By.xpath("//input[@id='UserName']")).sendKeys(Content_Inf.Username);	
			log.info("*** UserName Entered ***");
			driver.findElement(By.xpath("//a[@id='loginbtn']")).click();
			log.info("*** Next Button Clicked ***");
			driver.findElement(By.xpath("//input[@id='i0118']")).sendKeys(Content_Inf.Password);
			log.info("*** Pinion Password Entered ***");
			Thread.sleep(1000);
			driver.findElement(By.xpath("//input[@id='idSIButton9']")).click();
			log.info("*** Login Button Clicked ***");
			log.info("*** Waiting For Authentication ***");
			WebDriverWait rv1= new WebDriverWait(driver,100);
			rv1.until(ExpectedConditions.urlContains(Content_Inf.Auth_Url));
			log.info("*** Authentication Completed ***");
			driver.findElement(By.xpath("//input[@id='idBtn_Back']")).click();
			driver.findElement(By.xpath("/html[1]/body[1]/div[5]/div[1]/div[1]/div[3]/div[1]/div[1]/button[2]")).click();
			log.info("*** Performed Action on Company policy pop_up ***");
			log.info("*** Before Class Ended ***");

		}
		
		public void ScreenShot()
		{
			log.info("*** Taking ScreenShot ***");
			String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
			String filename="ScreenShot1";
			EventFiringWebDriver efw= new EventFiringWebDriver(driver);
			File f1=efw.getScreenshotAs(OutputType.FILE);
			File f2=new File("./ScreenshotsSuccess/" + timestamp +".jpg");
		   try
		   {
			   FileUtils.moveFile(f1, f2);
			   log.info("*** ScreenShot captured Sucessfully ***");
		   }
		   catch(IOException e)
		   {
			   e.printStackTrace();
		   }
		}
		
	@AfterSuite
	public void Extent_rlease()
	{
		extent.flush();
	}
	
		public WebElement Click_on_TimeSheets(WebDriver d ,By by)
		{
			return driver.findElement(by);
		}
	
	
}
