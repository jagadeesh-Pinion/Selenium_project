package TestCases_PKG;

import org.testng.Assert;
import org.testng.annotations.Test;

import BaseClass_PKG.Base_methods;
import Logic_PKG.Test_Logic;

public class TestCases extends Base_methods
{
	Test_Logic logic= new Test_Logic();
	
	@Test
	public void TestScript_01() throws InterruptedException
	{
		Assert.assertTrue(logic.Logic_timeSheets());
		log.info("*** Testcase1 Finished ***");

	}

	@Test(priority=2)
	public void TestScript_02() throws InterruptedException
	{
		Assert.assertTrue(logic.Logic_On_StatusSummary());
		log.info("*** Testcase2 Finished ***");

	}
	
	@Test(priority=3)
	public void TestScript_03() throws InterruptedException
	{
		Assert.assertTrue(logic.Logic_On_Achivements());
		log.info("*** Testcase3 Finished ***");

	}
	@Test(priority=4)
	public void TestScript_04() throws InterruptedException
	{
		Assert.assertTrue(logic.Logic_On_FocusPlans());
		log.info("*** Testcase4 Finished ***");

	}
	
	

}
