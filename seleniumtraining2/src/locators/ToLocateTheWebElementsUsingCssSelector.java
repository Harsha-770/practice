package locators;

import org.openqa.selenium.chrome.ChromeDriver;

public class ToLocateTheWebElementsUsingCssSelector {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://demowebshop.tricentis.com/");
		Thread.sleep(1000);
		driver.manage().window().maximize();
		Thread.sleep(1000);
		driver.findElementByCssSelector("a[class='ico-login']").click();
		Thread.sleep(1000);
		driver.findElementByCssSelector("input[id='Email']").sendKeys("harshakrishnaiahshetty770@gmail.com");
		Thread.sleep(1000);
		driver.findElementByCssSelector("input[id ='Password']").sendKeys("Harsha@770");
		Thread.sleep(1000);
		driver.findElementByCssSelector("input[value='Log in']").click();
		Thread.sleep(1000);
		driver.findElementByXPath("(//a[contains(text(),'Electronics')])[3]").click();
		Thread.sleep(1000);
		

	}

}
