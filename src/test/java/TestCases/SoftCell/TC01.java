package TestCases.SoftCell;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;

import utils.Screenshot;
import utils.TestBase;

public class TC01 extends TestBase {

	@Test(description="Does some hifi testing")
	public void meth() throws InterruptedException {
		

		//test = reports.createTest("Scenario 1");
		driver.get("https://www.google.com/");
		Thread.sleep(2000);
		// Assert.assertTrue(false);
		throw new NullPointerException();
		/*
		 * } catch (AssertionError e) { System.out.println("asdghaj"); Screenshot
		 * screenshot = new Screenshot(driver);
		 * screenshot.capture("Search_For_Keyword_Works"); }
		 */
	}
	
	@Test(description="checks something")
	public void meth2()
	{
		//test = reports.createTest("Scenario 2");
		Assert.assertTrue(true, "True");
	}
	
	@Test(description="checks something more")
	public void meth3()
	{
		//test = reports.createTest("Scenario 2");
		Assert.assertTrue(true, "True");
	}
}
