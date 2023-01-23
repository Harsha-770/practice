package advancedSeleniuem;

import org.openqa.selenium.chrome.ChromeDriver;

public class TocaptureSourcecode {
	
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.apple.com/in");
	}

}
