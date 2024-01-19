package newone.data_with_P30;

import org.testng.annotations.Test;

import jxl.Sheet;
import jxl.Workbook;

import org.testng.annotations.BeforeMethod;

import java.io.FileInputStream;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;

public class TS03 {
	// newone.data_with_P30.TSS07_TS14

	WebDriver driver;

	@Test
	public void TC_007() throws Exception {
		driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
		Thread.sleep(5000);
	}

	@Test
	public void TC_008() throws Exception {
		driver.findElement(By.xpath("//img[@alt='Sauce Labs Backpack']")).click();
		Thread.sleep(5000);
	}

	@Test
	public void TC_009() throws Exception {
		driver.findElement(By.id("add-to-cart-sauce-labs-bike-light")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("add-to-cart-sauce-labs-fleece-jacket")).click();
		Thread.sleep(5000);
	}

	@Test
	public void TC_010() throws Exception {
		driver.findElement(By.id("add-to-cart-sauce-labs-bike-light")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("add-to-cart-sauce-labs-fleece-jacket")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();
		Thread.sleep(5000);
	}

	@Test
	public void TC_011() throws Exception {
		driver.findElement(By.xpath("//select[@class='product_sort_container']")).click();
		Thread.sleep(5000);
	}

	@Test
	public void TC_012() throws Exception {
		driver.findElement(By.xpath("//select[@class='product_sort_container']")).click();
		Thread.sleep(5000);
		Select se = new Select(driver.findElement(By.xpath("//select[@class='product_sort_container']")));
		Thread.sleep(3000);
		se.selectByVisibleText("Price (low to high)");
		Thread.sleep(5000);
	}

	@Test
	public void TC_013() throws Exception {
		JavascriptExecutor jc = (JavascriptExecutor) driver;
		WebElement p = driver.findElement(By.xpath("//a[@href='https://twitter.com/saucelabs']"));
		jc.executeScript("arguments[0].scrollIntoView()", p);
		Thread.sleep(8000);
		driver.findElement(By.xpath("//a[@href='https://twitter.com/saucelabs']")).click();
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
		driver.quit();
	}

}
