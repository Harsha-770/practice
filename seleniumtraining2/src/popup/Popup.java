package popup;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Popup {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		WebDriverWait explicit = new WebDriverWait(driver,15);
		Actions action = new Actions(driver);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		
		// launch website
		driver.get("https://licindia.in/");
		WebElement agentPortal = driver.findElement(By.partialLinkText("Agents Portal"));
		js.executeScript("arguments[0].scrollIntoView(false);", agentPortal);
		try {
		agentPortal.click();
		}
		catch(Exception e) {
			js.executeScript("window.scrollBy(0,280)");
			agentPortal.click();
			
		}
		String curentWindow = driver.getWindowHandle();
		Alert alert= driver.switchTo().alert();
		System.out.println(alert.getText());
		alert.accept();
		explicit.until(ExpectedConditions.numberOfWindowsToBe(2));
		Set<String> windowIds = driver.getWindowHandles();
		
		windowIds.remove(curentWindow);
		for(String windowid :windowIds ) {
			driver.switchTo().window(windowid);
		}
		explicit.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//span[text()='Sign In']"))));
		driver.findElement(By.xpath("//span[text()='Sign In']")).click();
		List<WebElement> errorMsg = driver.findElements(By.xpath("//li[contains(text(),'Please enter ')]"));
		for(WebElement msg: errorMsg) {
			System.out.println(msg.getText());
		}
	}

}
