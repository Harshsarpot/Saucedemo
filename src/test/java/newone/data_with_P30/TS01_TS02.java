package newone.data_with_P30;

import org.testng.annotations.Test;
import jxl.Sheet;
import jxl.Workbook;
import java.io.FileInputStream;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

public class TS01_TS02 {
	WebDriver driver;

	// newone.data_with_P30.NewTest
	@Test
	public void TC_001() throws Exception {
		driver.findElement(By.id("login-button")).click();
		Thread.sleep(2000);
	}

	@Test
	public void TC_002() throws Exception {
		FileInputStream f = new FileInputStream("C:\\Users\\HP\\OneDrive\\Desktop\\saucedemo project.xls");
		Workbook wk = Workbook.getWorkbook(f);
		Sheet s = wk.getSheet("Data");
		driver.findElement(By.id("user-name")).sendKeys(s.getCell(1, 1).getContents());
		Thread.sleep(2000);
		driver.findElement(By.id("login-button")).click();
		Thread.sleep(2000);
	}

	@Test
	public void TC_003() throws Exception {
		FileInputStream f = new FileInputStream("C:\\Users\\HP\\OneDrive\\Desktop\\saucedemo project.xls");
		Workbook wk = Workbook.getWorkbook(f);
		Sheet s = wk.getSheet("Data");
		driver.findElement(By.id("user-name")).sendKeys(s.getCell(1, 2).getContents());
		Thread.sleep(2000);
		driver.findElement(By.id("password")).sendKeys(s.getCell(1, 3).getContents());
		Thread.sleep(2000);
		driver.findElement(By.id("login-button")).click();
		Thread.sleep(2000);
	}

	@Test
	public void TC_004() throws Exception {
		FileInputStream f = new FileInputStream("C:\\Users\\HP\\OneDrive\\Desktop\\saucedemo project.xls");
		Workbook wk = Workbook.getWorkbook(f);
		Sheet s = wk.getSheet("Data");
		driver.findElement(By.id("user-name")).sendKeys(s.getCell(1, 4).getContents());
		Thread.sleep(2000);
		driver.findElement(By.id("password")).sendKeys(s.getCell(1, 5).getContents());
		Thread.sleep(2000);
		driver.findElement(By.id("login-button")).click();
		Thread.sleep(2000);
	}

	@Test
	public void TC_005() throws Exception {
		FileInputStream f = new FileInputStream("C:\\Users\\HP\\OneDrive\\Desktop\\saucedemo project.xls");
		Workbook wk = Workbook.getWorkbook(f);
		Sheet s = wk.getSheet("Data");
		driver.findElement(By.id("user-name")).sendKeys(s.getCell(1, 2).getContents());
		Thread.sleep(2000);
		driver.findElement(By.id("password")).sendKeys(s.getCell(1, 3).getContents());
		Thread.sleep(2000);
		driver.findElement(By.id("login-button")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("react-burger-menu-btn")).click();
		Thread.sleep(5000);

	}

	@DataProvider(name = "Test Data")
	public Object[][] data() {

		Object[][] obj = new Object[3][2];
		obj[0][0] = "locked_out_user";
		obj[0][1] = "secret_sauce";
		obj[1][0] = "performance_glitch_user";
		obj[1][1] = "secret_sauce";
		obj[2][0] = "error_user";
		obj[2][1] = "secret_sauce";

		return obj;
	}

	@Test(dataProvider = "Test Data")
	public void login(String uid, String pwd) throws Exception {
		driver.findElement(By.id("user-name")).sendKeys(uid);
		Thread.sleep(1000);
		driver.findElement(By.id("password")).sendKeys(pwd);
		Thread.sleep(1000);
		driver.findElement(By.id("login-button")).click();
		Thread.sleep(5000);
	}

	@Test
	public void TC_006() throws Exception {
		FileInputStream f = new FileInputStream("C:\\Users\\HP\\OneDrive\\Desktop\\saucedemo project.xls");
		Workbook wk = Workbook.getWorkbook(f);
		Sheet s = wk.getSheet("Data");
		driver.findElement(By.id("user-name")).sendKeys(s.getCell(1, 2).getContents());
		Thread.sleep(2000);
		driver.findElement(By.id("password")).sendKeys(s.getCell(1, 3).getContents());
		Thread.sleep(2000);
		driver.findElement(By.id("login-button")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("react-burger-menu-btn")).click();
		Thread.sleep(5000);
		driver.findElement(By.id("react-burger-cross-btn")).click();
		Thread.sleep(5000);
	}

	@BeforeMethod
	public void LunchAPP() throws Exception {

		driver = new ChromeDriver();
		driver.get("https://www.saucedemo.com/");
		driver.manage().window().maximize();
		Thread.sleep(2000);
	}

	@AfterMethod
	public void AppClose() {
		driver.close();
	}

}
