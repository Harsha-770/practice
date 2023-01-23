package assignment;

import java.util.Collection;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Question_11 {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		WebDriverWait explicit = new WebDriverWait(driver, 15);
		driver.get("file:///C:/Users/Admin/Downloads/MultipleWindow.html");
		String parentWindowId = driver.getWindowHandle();
		driver.findElement(By.xpath("//input[@value='Open Food Sites']")).click();
		explicit.until(ExpectedConditions.numberOfWindowsToBe(4));
		Set<String> allWindowIds = driver.getWindowHandles();
		allWindowIds.remove(parentWindowId);
		TreeMap windowPopup = new TreeMap();
		try {
			for(String windowId :allWindowIds) {
				driver.switchTo().window(windowId);
				String title = driver.getTitle();
				windowPopup.put(title, windowId);
			}
		}
		catch(Exception e) {
			for(String windowId :allWindowIds) {
				driver.switchTo().window(windowId);
				String title = driver.getTitle();
				windowPopup.put(title, windowId);
			}

		}

		System.out.println(windowPopup);
		Collection<String> value = windowPopup.values();
		for( String windowid : value) {
			driver.switchTo().window(windowid);
			driver.manage().window().maximize();
			System.out.println(driver.getTitle());
			driver.close();

		}
	}

}
