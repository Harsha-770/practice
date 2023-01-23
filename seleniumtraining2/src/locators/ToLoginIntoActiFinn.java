package locators;

import org.openqa.selenium.chrome.ChromeDriver;

public class ToLoginIntoActiFinn {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();

		driver.get("https://demo.actitime.com/login.do");
		driver.manage().window().maximize();
		driver.findElementById("username").sendKeys("admin");

		driver.findElementByName("pwd").sendKeys("manager");

		driver.findElementById("loginButton").click();
		Thread.sleep(3000);
		String s1 = driver.getTitle();
		driver.findElementByPartialLinkText("Logout").click();
		System.out.println(s1);
		
		

	}

}
