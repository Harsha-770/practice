package advancedSeleniuem;

import org.openqa.selenium.chrome.ChromeDriver;

public class ToCaptureWindowId {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://online.kfc.co.in/");
		Thread.sleep(6000);
		String s1 = driver.getTitle();
		System.out.println(s1);
		System.out.println(driver.getWindowHandle());
		
		
	}

}
