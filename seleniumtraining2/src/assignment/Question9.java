package assignment;

import org.openqa.selenium.chrome.ChromeDriver;

//WAS TO GET CURRENT WINDOW ID OF FACEBOOK .COM. 
public class Question9 {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./driver/Chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.faceboock.com");
		String windowId = driver.getWindowHandle();
		System.out.println(windowId);
	}

}
