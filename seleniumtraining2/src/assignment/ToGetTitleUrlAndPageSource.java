package assignment;

import org.openqa.selenium.chrome.ChromeDriver;

public class ToGetTitleUrlAndPageSource {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.flipkart.com/");
	
		String sourceCode = driver.getPageSource();
		System.out.println(sourceCode);
		String url = driver.getCurrentUrl();
		System.out.println(url);
		String title = driver.getTitle();
		System.out.println(title);
		driver.quit();
	}

}
