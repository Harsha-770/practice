// Was to close only Barbeque nation window in Multiple Window.html
package assignment;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class Question_10 {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe/");
		ChromeDriver driver = new ChromeDriver();
		driver.get("file:///C:/Users/Admin/Downloads/MultipleWindow.html");
		driver.findElement(By.xpath("//input[@value='Open Food Sites']")).click();
		 String excpeted_title = "#1 buffet grill barbeque restaurant near you. Exciting Offers on lunch dinner with our trademark. | Barbeque Nation";
		Thread.sleep(2000);
		Set<String>allWindowIds = driver.getWindowHandles();
		for(String WindowId : allWindowIds) {
			driver.switchTo().window(WindowId);
			String title = driver.getTitle();
			if(title.equals(excpeted_title)) {
				driver.close();
			}
		}
	}

}
