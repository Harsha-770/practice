package locators;

import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;

public class toCopyAndPasteUsingEnum {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://fireflink.com/");
		driver.findElementByXPath("//a[text()='Sign Up']").click();
		driver.findElementByXPath("//input[@placeholder='Enter your name']").sendKeys("Harsha");
		driver.findElementByXPath("//input[@placeholder='Enter your email']").sendKeys("kharsha770@gmail.com");
		Thread.sleep(1000);
		driver.findElementByXPath("//input[@placeholder='Enter your password']").sendKeys("Hasha@770",Keys.CONTROL+"a");
		
		driver.findElementByXPath("//input[@placeholder='Enter your password']").sendKeys(Keys.CONTROL+"c");
	
		driver.findElementByXPath("//input[@placeholder='Confirm your password']").sendKeys(Keys.CONTROL+"v");
		
	}

}
