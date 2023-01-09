package StepDefinitions;

import org.testng.annotations.Test;

import junit.framework.Assert;

import org.testng.annotations.BeforeMethod;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class MyntraAddtoCart {
	  WebDriver driver;
	  String rootFolder=System.getProperty("user.dir");
	  String actualItemName="Karwan Purple iPhone 11 Metal Lens Phone Back Cover";
	  
  @BeforeMethod
  public void beforeMethod() {
	  System.setProperty("webdriver.chrome.driver", rootFolder+"//src//test//resources//chromedriver.exe");
	  driver=new ChromeDriver();
  }
  
  @SuppressWarnings("deprecation")
@Test
  public void AddingItemToCart() throws Exception {
	  driver.get("https://www.myntra.com/");
	  
	  driver.findElement(By.xpath("//input[@class='desktop-searchBar']")).sendKeys("Redmi 11");
	  driver.findElement(By.xpath("//input[@class='desktop-searchBar']")).sendKeys(Keys.ENTER);
	  
	  driver.findElement(By.xpath("//img[@title='Karwan Purple iPhone 11 Metal Lens Phone Back Cover']")).click();
	  
	  String mainWindow=driver.getWindowHandle();
	  Set <String> a = driver.getWindowHandles();
		String strArray[] = a.toArray(new String[a.size()]);
		String childWindow=strArray[1];
		if(!mainWindow.equalsIgnoreCase(childWindow)) {
			driver.switchTo().window(strArray[1]);
		}
		else {
			driver.switchTo().window(strArray[0]);
		}
		
		driver.findElement(By.xpath("//*[contains(text(),\"ADD TO BAG\")]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[contains(text(),\"GO TO BAG\")]")).click();
		String ExpectedName="Purple iPhone 11 Metal Lens Phone Back Cover";
		String ActualName = driver.findElement(By.xpath("//a[contains(@class,\"itemContainer-base-itemLink\")]")).getText();
		Assert.assertTrue(ExpectedName.equals(ActualName));
  }

  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }

}
