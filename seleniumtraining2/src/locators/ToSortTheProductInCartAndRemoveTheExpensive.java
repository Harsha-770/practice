package locators;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ToSortTheProductInCartAndRemoveTheExpensive {
	
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://www.flipkart.com");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[@class ='_2KpZ6l _2doB4z']")).click();
		  WebElement searchBar = driver.findElement(By.xpath("//input[@placeholder ='Search for products, brands and more']"));
		  searchBar.sendKeys("iphone-13",Keys.ENTER);
		  Thread.sleep(3000);
		 driver.findElement(By.xpath("//img[@alt='APPLE iPhone 13 (Green, 256 GB)']")).click();
		 String parentWindowId = driver.getWindowHandle();
		 Set<String> allwindowsIds = driver.getWindowHandles();
		 allwindowsIds.remove(parentWindowId);
		 for(String windowId:allwindowsIds) {
			 driver.switchTo().window(windowId);
			 driver.findElement(By.xpath("//button[text()='Add to cart']")).click();
			 Thread.sleep(3000);
			 driver.close();
			 
		 }
		 driver.switchTo().window(parentWindowId);
		 searchBar.sendKeys(Keys.CONTROL+"A");
		 searchBar.sendKeys(Keys.DELETE);
		 searchBar.sendKeys("iphone-12",Keys.ENTER);
		 Thread.sleep(3000);
		driver.findElement(By.xpath("//img[@alt ='APPLE iPhone 12 (Blue, 128 GB)']")).click();
		Thread.sleep(3000);
		 Set<String> allwindowsIds2 = driver.getWindowHandles();
		 allwindowsIds2.remove(parentWindowId);
		 for(String windowId:allwindowsIds2) {
			 driver.switchTo().window(windowId);
			 driver.findElement(By.xpath("//button[text()='Add to cart']")).click();
			 Thread.sleep(3000);
			 driver.close();
		 }
		 driver.switchTo().window(parentWindowId);
		 searchBar.sendKeys(Keys.CONTROL+"A");
		 searchBar.sendKeys(Keys.DELETE);
		 searchBar.sendKeys("iphone-12",Keys.ENTER);
		 Thread.sleep(3000);
		driver.findElement(By.xpath("//img[@alt ='APPLE iPhone 12 (Red, 64 GB)']")).click();
		Thread.sleep(3000);
		 Set<String> allwindowsIds3 = driver.getWindowHandles();
		 allwindowsIds3.remove(parentWindowId);
		 for(String windowId:allwindowsIds3) {
			 driver.switchTo().window(windowId);
			 Thread.sleep(2000);
			 boolean flag = driver.findElement(By.xpath("//button[text()='Add to cart']")).isDisplayed();
			 System.out.println(flag);
			 driver.findElement(By.xpath("//button[text()='Add to cart']")).click();
			 Thread.sleep(3000);
			 
		 }
		
		
	}
}
