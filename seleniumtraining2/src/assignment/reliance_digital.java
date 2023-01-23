package assignment;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class reliance_digital {
	public static WebDriver driver ;
	@Test
	public static void testrun() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		WebDriverWait explicit = new WebDriverWait(driver,50);	
		
		// lauch the website
		driver.get("https://www.reliancedigital.in/");
		WebElement popup = driver.findElement(By.xpath("//button[text()='No, don’t.']"));
		explicit.until(ExpectedConditions.visibilityOf(popup));
		driver.findElement(By.xpath("//button[text()='No, don’t.']")).click();
		driver.findElement(By.id("suggestionBoxEle")).click();;
		
		driver.findElement(By.id("suggestionBoxEle")).sendKeys("mobile",Keys.ENTER);
		
		driver.findElement(null);
	}

}
