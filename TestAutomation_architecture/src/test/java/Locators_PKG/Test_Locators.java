package Locators_PKG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import BaseClass_PKG.Base_methods;

public class Test_Locators  extends Base_methods
{
	public WebElement Policy_PopUp()
	{
		return driver.findElement(By.xpath("/html[1]/body[1]/div[5]/div[1]/div[1]/div[3]/div[1]/div[1]/button[2]"));
	}
	public WebElement Click_On_Timesheets()
	{
		
		return driver.findElement(By.xpath("//div[@class=\"slide slidenew tf-services\"]//p"));
		//return driver.findElement(By.xpath("/html[1]/body[1]/div[3]/div[2]/div[2]/center[1]/div[1]/div[1]/div[1]/a[1]/div[1]/i[1]"));
	}
	public WebElement Click_On_StatusSummary()
	{
		return driver.findElement(By.xpath("//textarea[@data-ng-model='WorkStatus']"));
		//return driver.findElement(By.xpath("//body/div[1]/div[2]/div[1]/div[2]/form[1]/div[1]/div[1]/div[5]/div[1]/textarea[1]"));
	}
	public WebElement Click_On_acheivements()
	{
		
		return driver.findElement(By.xpath("//body//Textarea[@data-ng-model='WorkChallenge']"));
		//return driver.findElement(By.xpath("//body/div[1]/div[2]/div[1]/div[2]/form[1]/div[1]/div[1]/div[5]/div[2]/textarea[1]"));
	}
	public WebElement Click_On_FocusPlan()
	{
		
		return driver.findElement(By.xpath("//body//textarea[@data-ng-model='WorkRisk']"));
	}
	
	public WebElement Click_On_Issues()
	{
		
		return driver.findElement(By.xpath("//body//div//textarea[@data-ng-model='WorkNextSteps']"));
	}
	
	
	
	
}
