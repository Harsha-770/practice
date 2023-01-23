package drivers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleMaps {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");
		
		driver.findElement(By.xpath("//a[@aria-label='Google apps']")).click();
		Thread.sleep(3000);
		WebElement frameElement = driver.findElement(By.xpath("//iframe[@name='app']"));
		Thread.sleep(3000);
		driver.switchTo().frame(frameElement);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[text()='Maps']")).click();
	}

}
