package actionClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class KeyActionEcommerce {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		WebDriverWait explicit = new WebDriverWait(driver, 15);
		
		// lauch the website
		driver.get("https://www.kalkifashion.com/");
		System.out.println("website opened");
		driver.findElement(By.xpath("(//nav[not(@id='mobile-nav')]//div[@id='desktop-nav']//a[contains(@class,'menu')]"));
		
		
		
	}

}
