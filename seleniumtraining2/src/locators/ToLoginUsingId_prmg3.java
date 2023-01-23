package locators;

import org.openqa.selenium.chrome.ChromeDriver;

public class ToLoginUsingId_prmg3 {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		 driver.get("https://demowebshop.tricentis.com/");
		 Thread.sleep(2000);
		 driver.findElementByPartialLinkText("Log in").click();
		 driver.findElementById("email").sendKeys("harshakrishnaiahshetty@gmail.com");
		 driver.findElementById("Password").sendKeys("Harsha@770");
			
		 Thread.sleep(2000);
		 
	}

}
