package assignment; // WAS to close parent window in MultipleWindow.html

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class Question_7 {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("file:///C:/Users/Admin/Downloads/MultipleWindow.html");
		driver.findElement(By.xpath("//input[@value='Open Food Sites']")).click();
		Thread.sleep(2000);
		String title_excpeted ="Multiple popups";
		Set<String>allWindIds = driver.getWindowHandles();
		for(String windowId : allWindIds) {
			String title = driver.getTitle();
			if(title.equals(title_excpeted)) {
			}
			else {
				System.out.println("f");
				driver.close();
				break;
				
			}
		}
	}

}
