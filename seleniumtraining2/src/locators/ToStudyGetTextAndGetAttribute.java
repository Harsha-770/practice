package locators;

import javax.security.auth.kerberos.KeyTab;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ToStudyGetTextAndGetAttribute {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./driver/Chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		
		/*to capture the value from the userName textbox
		driver.get("https://yonobusiness.sbi/login/yonobusinesslogin");
		WebElement usernameTextField = driver.findElement(By.id("userName"));
		usernameTextField.sendKeys("Harsha");
		Thread.sleep(2000);
		String attrvalue = usernameTextField.getAttribute("value");
		System.out.println(attrvalue); */
		
		/*to capture the tooltip text
		driver.get("https://demo.actitime.com/login.do");
		String tooltip = driver.findElement(By.id("keepMeLoggedInCaptionContainer")).getAttribute("title");
		System.out.println(tooltip);*/
		
		/*to capture tool tip text
		driver.get("https://www.woodenstreet.com/");
		Thread.sleep(2000);
		String alternateText=driver.
				findElement(By.xpath("//img[@title='Adolph Bed With Side Storage']")).getAttribute("alt");
		Thread.sleep(2000);
		System.out.println(alternateText);*/
		
		
		driver.get("https://demowebshop.tricentis.com/login");
		Thread.sleep(2000);
		driver.findElement(By.id("Email")).sendKeys("harsha",Keys.TAB);
		String errorText = driver.findElement(By.xpath("//span[@for='Email']")).getText();
		System.out.println(errorText);
		
		
	}

}
