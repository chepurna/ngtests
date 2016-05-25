package com.ghtest.ngtests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NewTest1 {
	WebDriver driver;
	WebDriverWait wdw;
  @Test
  public void testCheckoutText() {
	  System.setProperty("webdriver.chrome.driver", "c:/SeleniumWebdrivers/chromedriver.exe");
	  driver = new ChromeDriver(); 
	  wdw = new WebDriverWait(driver,5000);
	  driver.navigate().to("http://www.practiceselenium.com/welcome.html");
	  String lnkCheckOut = "Check Out";
	  wdw.until(ExpectedConditions.elementToBeClickable(By.linkText("Check Out")));
	  driver.findElement(By.linkText(lnkCheckOut)).click();
	  try{
		  Thread.sleep(1000);
	  }catch(InterruptedException ie){
		  ie.printStackTrace();
	  }
	  String xstr = "//*[@id=\"wsb-element-00000000-0000-0000-0000-000451990420\"]/div/pre/strong/span";
	  String astr = driver.findElement(By.xpath(xstr)).getText();
	  Assert.assertEquals(astr, "Enter your billing information");
	  driver.close();
  }
}
