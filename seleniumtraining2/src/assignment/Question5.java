// WAS TO PRINT TITLES OF ALL THE WINDOWS OF MULTIPLEwINDOWS.HTML
package assignment;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class Question5 {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("file:///C:/Users/Admin/Downloads/MultipleWindow.html");
		driver.findElement(By.xpath("//input[@value='Open Food Sites']")).click();
		Thread.sleep(2000);
		Set<String>allWindowIds = driver.getWindowHandles();
		for(String windowId : allWindowIds) {
			Thread.sleep(02000);
			driver.switchTo().window(windowId);
			String title = driver.getTitle();
			System.out.println(title);
			
		}
		
	}

}
