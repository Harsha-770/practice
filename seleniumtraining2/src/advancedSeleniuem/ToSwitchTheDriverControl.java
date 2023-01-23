package advancedSeleniuem;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class ToSwitchTheDriverControl {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("file:///C:/Users/Admin/Downloads/MultipleWindow.html");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[@value='Open Food Sites']")).click();
		Thread.sleep(9000);
		String expectedPageTitle = "Original Italian Recipes - Giallozafferano Recipes";
		Set <String> allwindowIds = driver.getWindowHandles();
		
		for(String windowId : allwindowIds) {
			driver.switchTo().window(windowId);
			String actualPageTitle = driver.getTitle();
			System.out.println(actualPageTitle);
			if(expectedPageTitle.equals(actualPageTitle)) {
				driver.close();
			}
		}
		
		
		

	}

}
