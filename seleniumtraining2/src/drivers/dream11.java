package drivers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class dream11 {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.dream11.com/");
		WebElement frameElement = driver.findElement(By.xpath("//iframe[@title='Iframe Example']"));
		Thread.sleep(2000);
		driver.switchTo().frame(frameElement);
		driver.findElement(By.id("regEmail")).sendKeys("1234567890");
		
	}

}
