package locators;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class ToElementsUsingId {
	public static void main (String[]args) throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://demowebshop.tricentis.com/");
		Thread.sleep(2000);
	
		WebElement loginLink  = driver.findElementByLinkText("Log in");;
		loginLink.click();
		driver.findElementById("Email").sendKeys("HARSHA");
		Thread.sleep(2000);
		driver.findElementById("Password").sendKeys("Kharsha770");
		Thread.sleep(3000);
	}
}
