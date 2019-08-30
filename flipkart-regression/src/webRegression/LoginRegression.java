package webRegression;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginRegression {
	
	public static WebDriver driver;
	public static WebDriverWait wait;
	
	@BeforeClass
	public void init() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ru20104049\\Desktop\\eclipseSpace\\demo\\resources\\chromedriver.exe");
		driver = new ChromeDriver();
		wait = new WebDriverWait(driver,30);
		driver.manage().window().maximize();
		driver.get("https://www.flipkart.com/");
	}
	
	@Test(description="Login to Flipkart")
	public void flipkartLogin() {
		WebElement userName = driver.findElement(By.xpath("//*[text()='Enter Email/Mobile number']/ancestor::div[1]/input"));
		wait.until(ExpectedConditions.visibilityOf(userName)).sendKeys("rupesh.kmr@gmail.com");
		driver.findElement(By.xpath("//*[text()='Enter Password']/ancestor::div[1]/input")).sendKeys("Test123!");
		driver.findElement(By.xpath("//*[text()='Login']//parent::button")).click();
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}

