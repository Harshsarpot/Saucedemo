package newone.data_with_P30;

import org.testng.annotations.Test;

import jxl.Sheet;
import jxl.Workbook;

import org.testng.annotations.BeforeMethod;

import java.io.FileInputStream;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class TS04 {
	
	//newone.data_with_P30.TS14_TS17
	WebDriver driver;
	
  @Test
  public void TC_014() throws Exception {
	  driver.findElement(By.id("add-to-cart-sauce-labs-bike-light")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("add-to-cart-sauce-labs-fleece-jacket")).click();
		Thread.sleep(3000);
        driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();
        Thread.sleep(2000);
  }
  
  @Test
	public void TC_015() throws Exception {
	    driver.findElement(By.id("add-to-cart-sauce-labs-bike-light")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("add-to-cart-sauce-labs-fleece-jacket")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("remove-sauce-labs-fleece-jacket")).click();
		Thread.sleep(5000);
	}
  
  @Test
 	public void TC_016() throws Exception {
 	    driver.findElement(By.id("add-to-cart-sauce-labs-bike-light")).click();
 		Thread.sleep(3000);
 		driver.findElement(By.id("add-to-cart-sauce-labs-fleece-jacket")).click();
 		Thread.sleep(3000);
 		driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();
 		Thread.sleep(3000);
 	    driver.findElement(By.id("continue-shopping")).click();
 	    Thread.sleep(6000);
  }
  
  @Test
	public void TC_017() throws Exception {
	    driver.findElement(By.id("add-to-cart-sauce-labs-bike-light")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("add-to-cart-sauce-labs-fleece-jacket")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();
		Thread.sleep(3000);
	    driver.findElement(By.id("checkout")).click();
	    Thread.sleep(6000);
  }
  
  @BeforeMethod
  public void LunchAPP() throws Exception {
		FileInputStream f = new FileInputStream("C:\\Users\\HP\\OneDrive\\Desktop\\saucedemo project.xls");
		Workbook wk = Workbook.getWorkbook(f);
		Sheet s = wk.getSheet("Data");
		driver = new ChromeDriver();
		driver.get(s.getCell(1, 0).getContents());
		driver.manage().window().maximize();
		Thread.sleep(2000);
		driver.findElement(By.id("user-name")).sendKeys(s.getCell(1, 2).getContents());
		Thread.sleep(2000);
		driver.findElement(By.id("password")).sendKeys(s.getCell(1, 3).getContents());
		Thread.sleep(2000);
		driver.findElement(By.id("login-button")).click();
		Thread.sleep(2000);
		}

  @AfterMethod
  public void AppClose() {
		driver.close();
		}

}
