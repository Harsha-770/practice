package actionClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ToExploreToMoveElement {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		WebDriver driver = new  ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		WebDriverWait explicit = new WebDriverWait(driver, 15);
		 
		// open the website
		driver.get("https://www.reliancedigital.in/");
		driver.findElement(By.xpath("//button[text()='No, don’t.']")).click();
		
		//to perform mouse over and action on home appliance and click on the refirgarator
		WebElement homeapplicanceNavBarElement = driver.findElement(By.xpath("//div[text()='Home Appliances']"));
		Actions action = new Actions(driver);
		//action.moveToElement(homeapplicanceNavBarElement).perform();
		//driver.findElement(By.linkText("Refrigerators")).click();
		
		// to performe move over action using ToMoveByOffset method
		action.moveByOffset(596, 110).perform();
		Thread.sleep(2000);
		action.moveByOffset(-300, 175).click().perform();
	}

}
