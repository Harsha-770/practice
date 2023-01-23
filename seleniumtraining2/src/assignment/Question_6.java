package assignment;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Set;

import org.openqa.selenium.chrome.ChromeDriver;

public class Question_6 {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","./Driver/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("file:///C:/Users/Admin/Downloads/MultipleWindow.html");
		driver.findElementByXPath("//input[@value = 'Open Food Sites']").click();
		Thread.sleep(3000);
		Set<String>allWindowIds = driver.getWindowHandles();
		ArrayList<String> title=new ArrayList<String>();
		for(String windowId : allWindowIds) {
			driver.switchTo().window(windowId);
			title.add(driver.getTitle());

		}
		Collections.sort(title);
		for(int i =0; i<title.size();i++) {
			for(String windowId : allWindowIds) {
				driver.switchTo().window(windowId);
				if(title.get(i).equals(driver.getTitle())) {
					driver.close();
					
				}

			}

		}

	}
}


