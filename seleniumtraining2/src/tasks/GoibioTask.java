package tasks;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GoibioTask {
	public static void main(String[] args) {
		LocalDate systemsDate = LocalDate.now().plusMonths(8);
		String monthName = systemsDate.getMonth().name();
		int year = systemsDate.getYear();
		int day = systemsDate.getDayOfMonth();
		String month =""+monthName.charAt(0)+monthName.substring(1, monthName.length()).toLowerCase();
		
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		WebDriverWait explicit = new WebDriverWait(driver, 15);
		
		// launch the website
		driver.get("https://www.goibibo.com/");
		driver.findElement(By.xpath("//span[text()='Departure']")).click();
		for(;;) {
			try {
				driver.findElement(By.xpath("//div[text()='"+month+" "+year+"']/../..//p[text()='"+day+"']")).click();
				break;
			}
			catch(Exception e){
				WebElement nextButton = driver.findElement(By.xpath("//span[@aria-label='Next Month']"));
				explicit.until(ExpectedConditions.elementToBeClickable(nextButton));
				nextButton.click();
				
			}
		}
	
		
		
	}

}
