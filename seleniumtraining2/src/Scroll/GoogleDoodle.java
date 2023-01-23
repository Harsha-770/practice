package Scroll;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleDoodle {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		driver.get("https://www.google.com/doodles");
		JavascriptExecutor js = (JavascriptExecutor)driver;
		for(;;) {
			try {
				driver.findElement(By.partialLinkText("India Independence Day 2022")).click();
				break;
			}
			catch(NoSuchElementException e) {
				js.executeScript("window.scrollBy(0,400);" );
			}
		}
		
		
	}

}
