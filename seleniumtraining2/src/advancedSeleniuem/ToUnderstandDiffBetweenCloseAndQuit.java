package advancedSeleniuem;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.server.handler.GetTitle;

public class ToUnderstandDiffBetweenCloseAndQuit {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("file:///C:/Users/Admin/Downloads/MultipleWindow.html");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//input[@value='Open Food Sites']")).click();
		Thread.sleep(3000);
		Set<String> allwindowIds = driver.getWindowHandles();
		System.out.println("Size of set: "+allwindowIds.size());
		for(String windowId : allwindowIds) {
			driver.switchTo().window(windowId);
			String title = driver.getTitle();
			System.out.println(title);
			System.out.println(windowId);
		}
		driver.quit();
	}

}
