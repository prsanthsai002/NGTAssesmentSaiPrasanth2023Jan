package StepDefinitions;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class MyntraLogin {
	WebDriver driver;
	String rootFolder=System.getProperty("user.dir");
	
  @BeforeMethod
  public void LaunchApp() {
	System.setProperty("webdriver.chrome.driver", rootFolder+"//src//test//resources//chromedriver.exe");
	driver=new ChromeDriver();
  }
  
  @Test
  public void MyntraLogin() throws Exception {
//	  Properties propObj=new Properties();
//	  obj.load(new FileInputStream(rootFolder+"\\login.properties"));
//		
//	  String AppUrl=obj.getProperty("AppUrl");
//	  String UserName=obj.getProperty("UserName");
//	  String Password=obj.getProperty("Password");
//	  String rootFolder=System.getProperty("user.dir");
//	  Properties propObj=new Properties();
//		propObj.load(new FileInputStream(rootFolder+"//src//test//resources//login.properties"));
		
//		String AppUrl=propObj.getProperty("AppUrl");
	  
	  driver.get("https://www.myntra.com/login/password");
	  driver.findElement(By.id("mobileNumberPass")).sendKeys("prsanthsai002@gmail.com");
		driver.findElement(By.xpath("//input[@class='form-control has-feedback']")).sendKeys("Prasanth1!");
		
//	  driver.get(AppUrl);
//	  driver.findElement(By.id("mobileNumberPass")).sendKeys(UserName);
//      driver.findElement(By.xpath("//input[@class='form-control has-feedback']")).sendKeys(Password);
		
		driver.findElement(By.xpath("//button[@class=\"btn primary  lg block submitButton\"]")).click();
		Thread.sleep(30000);
		driver.findElement(By.xpath("//button[@class=\"btn primary  lg block submitButton\"]")).click();
		Thread.sleep(5000);
		
		String ExpectedTitle="Online Shopping for Women, Men, Kids Fashion & Lifestyle - Myntra";
		String ActualTitle=driver.getTitle();
		
		Assert.assertTrue(ActualTitle.equals(ExpectedTitle));
		
		
  }

  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }
}
