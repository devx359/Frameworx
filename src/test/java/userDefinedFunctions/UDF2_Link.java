package userDefinedFunctions;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestContext;

import com.aventstack.extentreports.ExtentTest;


import utils.Locator;


public class UDF2_Link extends UDF1_Button{

	WebDriver driver;
	Locator locator;
	ExtentTest test;
	
	public UDF2_Link(ITestContext context)
	{
		super(context);
		driver = (WebDriver) context.getAttribute("driver");	
		locator = new Locator();
		test = (ExtentTest)context.getAttribute("test");
	}

	public void navigateToURL(String actualURL) {
		try {

			driver.get(actualURL);

		}  catch (Exception e) {
			System.out.println("Unable to open " + actualURL+ e);
			test.error(e);
			
		}
	}

	public void Click(String strxpath) {
		try {

			
			By LinkLocator = locator.getWebElement(strxpath);
			WebDriverWait wait = new WebDriverWait(driver, 90);
			wait.until(ExpectedConditions.visibilityOfElementLocated(LinkLocator));
			wait.until(ExpectedConditions.elementToBeClickable(LinkLocator)).click();
		} catch (Exception e) {
			System.out.println("Unable to click on link: " + strxpath +" "+e);
			test.error(e);
			Assert.fail();
		}

	}
	public void ClickonPresent(String strxpath) {
		try {
		
			By LinkLocator = locator.getWebElement(strxpath);
			WebDriverWait wait = new WebDriverWait(driver, 10);			
			wait.until(ExpectedConditions.presenceOfElementLocated(LinkLocator)).click();
		} catch (Exception e) {
			System.out.println("Unable to click on link: " + strxpath +" "+e);	
			test.error(e);
			Assert.fail();
		}

	}

	public void JSClick(String strxpath) {
		try {
	
			By LinkLocator = locator.getWebElement(strxpath);			
			WebDriverWait wait = new WebDriverWait(driver, 100);
			WebElement elementToClick=wait.until(ExpectedConditions.visibilityOfElementLocated(LinkLocator));	
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", elementToClick);
			//System.out.println("Clicked on "+strxpath);
	
		} catch (Exception e) {
			System.out.println("Unable to click on link " + strxpath +e);
			e.printStackTrace();
			test.error(e);
			Assert.fail();
			
		}

	}

	


	public boolean isPresent(String strxpath) {
		boolean res=false;
		try {
			By LinkLocator = locator.getWebElement(strxpath);
			WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.presenceOfElementLocated(LinkLocator));
			res=true;
		} catch (Exception e) {
			System.out.println(strxpath+" is not present " +e);
		//	e.printStackTrace();
			return res;
		}
		return res;

	}

	public void isEnable(String strxpath) {
		try {
			By LinkLocator = locator.getWebElement(strxpath);
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.presenceOfElementLocated(LinkLocator)).isEnabled();
		} catch (Exception e) {
			System.out.println("Link is not enabled");
		}

	}
}
