package webRegression;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginRegression {
	public static WebDriver driver;
	public static WebDriverWait wait;
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ru20104049\\Desktop\\eclipseSpace\\demo\\resources\\chromedriver.exe");
		driver = new ChromeDriver();
		wait = new WebDriverWait(driver,30);
		driver.manage().window().maximize();
		driver.get("https://www.flipkart.com/");
		driver.findElement(By.xpath("//*[text()='Enter Email/Mobile number']/ancestor::div[1]/input")).sendKeys("rupesh.kmr@gmail.com");
		driver.findElement(By.xpath("//*[text()='Enter Password']/ancestor::div[1]/input")).sendKeys("@Ramadevi25");
		driver.findElement(By.xpath("//*[text()='Login']//parent::button")).click();
	}

}

