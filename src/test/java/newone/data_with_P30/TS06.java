package newone.data_with_P30;

import java.io.FileInputStream;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import jxl.Sheet;
import jxl.Workbook;

public class TS06 {
	WebDriver driver;

	@Test
	public void TC_23() throws Exception {
		JavascriptExecutor jc = (JavascriptExecutor) driver;
		WebElement w = driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/div[1]/div[4]/div[2]/a/div"));
		jc.executeScript("arguments[0].scrollIntoView()", w);
		Thread.sleep(3000);
		WebElement p = driver.findElement(By.xpath("//a[@href='https://twitter.com/saucelabs']"));
		jc.executeScript("arguments[0].scrollIntoView()", p);
		Thread.sleep(5000);
	}
	
	@Test
	public void TC_24() throws Exception {
		JavascriptExecutor jc = (JavascriptExecutor) driver;
		WebElement p = driver.findElement(By.xpath("//a[@href='https://twitter.com/saucelabs']"));
		jc.executeScript("arguments[0].scrollIntoView()", p);
		Thread.sleep(2000);
		driver.findElement(By.id("cancel")).click();
		Thread.sleep(5000);
	}
	
	@Test
	public void TC_25() throws Exception {
		JavascriptExecutor jc = (JavascriptExecutor) driver;
		WebElement p = driver.findElement(By.xpath("//a[@href='https://twitter.com/saucelabs']"));
		jc.executeScript("arguments[0].scrollIntoView()", p);
		Thread.sleep(2000);
		driver.findElement(By.id("finish")).click();
		Thread.sleep(5000);
	}
	
	@Test
	public void TC_26() throws Exception {
		JavascriptExecutor jc = (JavascriptExecutor) driver;
		WebElement p = driver.findElement(By.xpath("//a[@href='https://twitter.com/saucelabs']"));
		jc.executeScript("arguments[0].scrollIntoView()", p);
		Thread.sleep(2000);
		driver.findElement(By.id("finish")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("back-to-products")).click();
		Thread.sleep(5000);
	}

	@BeforeMethod
	public void LunchAPP() throws Exception {
		FileInputStream f = new FileInputStream("C:\\Users\\HP\\OneDrive\\Desktop\\saucedemo project.xls");
		Workbook wk = Workbook.getWorkbook(f);
		Sheet s = wk.getSheet("Data");
		driver = new ChromeDriver();
		driver.get(s.getCell(1, 0).getContents());
		driver.manage().window().maximize();
		driver.findElement(By.id("user-name")).sendKeys(s.getCell(1, 2).getContents());
		driver.findElement(By.id("password")).sendKeys(s.getCell(1, 3).getContents());
		driver.findElement(By.id("login-button")).click();
		driver.findElement(By.id("add-to-cart-sauce-labs-bike-light")).click();
		driver.findElement(By.id("add-to-cart-sauce-labs-fleece-jacket")).click();
		driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();
		driver.findElement(By.id("checkout")).click();
		driver.findElement(By.id("first-name")).sendKeys(s.getCell(1, 6).getContents());
		driver.findElement(By.id("last-name")).sendKeys(s.getCell(1, 7).getContents());
		driver.findElement(By.id("postal-code")).sendKeys(s.getCell(1, 8).getContents());
		driver.findElement(By.xpath("//input[@id='continue']")).click();
		Thread.sleep(3000);

	}

	@AfterMethod
	public void AppClose() {
		driver.close();
	}
}
