package locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ToRegisterUsingId_prmg2 {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("https://demowebshop.tricentis.com/");
		Thread.sleep(2000);
		driver.findElement(By.linkText("Register")).click();
		Thread.sleep(2000);
		driver.findElementById("gender-male").click();
		Thread.sleep(2000);
		driver.findElementById("FirstName").sendKeys("Handy");
		Thread.sleep(2000);
		driver.findElementById("LastName").sendKeys("Krishna");
		Thread.sleep(2000);
		driver.findElementById("Email").sendKeys("harshakrishnaiahshetty770@gmail.com");
		Thread.sleep(2000);
		driver.findElementById("Password").sendKeys("Harsha@770");
		Thread.sleep(2000);
		driver.findElementById("ConfirmPassword").sendKeys("Harsha@770");
		Thread.sleep(2000);
		driver.findElementById("register-button").click();
	}

}
