package tasks;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import net.bytebuddy.agent.builder.AgentBuilder.RedefinitionStrategy.DiscoveryStrategy.Explicit;

public class fileLawn {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		RemoteWebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		WebDriverWait explicitWait =new WebDriverWait(driver,15);
		
		driver.get("https://firelawn.com/");
		driver.findElement(By.xpath("//span[text()='5.0']/../..//img[@alt=\"APPLE iPhone 14 Pro\"]")).click();
		driver.findElement(By.xpath("//input[@placeholder='580023']")).sendKeys("562110");
		WebElement checkButton = driver.findElement(By.xpath("//button[text()='Check']"));
		explicitWait.until(ExpectedConditions.elementToBeClickable(checkButton));
		checkButton.click();
	}

}
