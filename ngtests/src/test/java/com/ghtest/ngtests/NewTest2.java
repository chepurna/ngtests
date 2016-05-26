package com.ghtest.ngtests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NewTest2 {
	WebDriver driver;
	WebDriverWait wdw;
  @Test
  public void testMenuItemsText() {
	  System.setProperty("webdriver.chrome.driver", "c:/SeleniumWebdrivers/chromedriver.exe");
	  driver = new ChromeDriver(); 
	  wdw = new WebDriverWait(driver,5000);
	  driver.navigate().to("http://www.practiceselenium.com/welcome.html");
	  String lnkCheckOut = "Menu";
	  wdw.until(ExpectedConditions.elementToBeClickable(By.linkText(lnkCheckOut)));
	  driver.findElement(By.linkText(lnkCheckOut)).click();
	  try{
		  Thread.sleep(1000);
	  }catch(InterruptedException ie){
		  ie.printStackTrace();
	  }
	  
	  String gtxstr="//*[@id=\"wsb-element-00000000-0000-0000-0000-000453230000\"]/div/p/span/span/strong";
	  String rtxstr="//*[@id=\"wsb-element-00000000-0000-0000-0000-000453231072\"]/div/p/span/span/strong";
	  String gtstr = driver.findElement(By.xpath(gtxstr)).getText();
	  String rtstr = driver.findElement(By.xpath(rtxstr)).getText();
	  Assert.assertEquals(gtstr, "Green Tea");
	  Assert.assertEquals(rtstr, "Red Tea");
	  driver.close();
  }
}
