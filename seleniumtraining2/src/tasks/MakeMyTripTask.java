package tasks;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import generic_Libraries.GenericMethodToReadDataFromExcel;

public class MakeMyTripTask {
	public static WebDriver driver ;
	public static void main(String[] args) {
		String From = GenericMethodToReadDataFromExcel.fromExcel("makeMyTrip", 1, 0);
		String to = GenericMethodToReadDataFromExcel.fromExcel("makeMyTrip", 1, 1);
		LocalDateTime date = GenericMethodToReadDataFromExcel.fromExcelLocalDate("makeMyTrip", 1, 2);
		String monthName = date.getMonth().name();
		int day = date.getDayOfMonth();
		int year = date.getYear();
		System.out.println(monthName);
		System.out.println(day);
		System.out.println(year);
		String month =""+monthName.charAt(0)+monthName.substring(1, monthName.length()).toLowerCase();
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		WebDriverWait explicit = new WebDriverWait(driver, 20);
		Actions action = new Actions(driver);


		//step -1 launch the website
		driver.get("https://www.makemytrip.com");
		System.out.println("website launched ");

		//step-2 select the from city
		action.click().perform();
		driver.findElement(By.xpath("//span[text()='From']")).click();
		driver.findElement(By.xpath("//input[@placeholder='From']")).sendKeys(From);

		driver.findElement(By.xpath("//p[contains(text(),'"+From+"')]")).click();
		//explicit.until(ExpectedConditions.visibilityOf(selectedFromCity));
		//selectedFromCity.click();
		System.out.println("from city is selected");
		// Step2, select the to city
		driver.findElement(By.xpath("//span[text()='To']")).click();
		driver.findElement(By.xpath("//input[@placeholder='To']")).sendKeys(to);

		driver.findElement(By.xpath("//p[contains(text(),'"+to+"')]")).click();
		//explicit.until(ExpectedConditions.visibilityOf(selectedToCity));
		//selectedFromCity.click();
		System.out.println("To city is selected");
		for(;;) {
			try {
				driver.findElement(By.xpath("//div[contains(text(),'"+month+" "+year+"')]/../..//p[contains(text(),'"+day+"')]")).click();
				System.out.println("from date is selected");
				break;
			}
			catch(Exception e){
				driver.findElement(By.xpath("//span[@aria-label='Next Month']")).click();
				//explicit.until(ExpectedConditions.elementToBeClickable(nextButton));
				//nextButton.click();

			}
		}
	
		driver.findElement(By.xpath("//span[text()='RETURN']")).click();
		for(;;) {
			try {
				driver.findElement(By.xpath("//span[text()='"+year+"']/../..//div[text()='"+month+"']/../..//p[text()='"+day+"']")).click();
				System.out.println("to date is selected");
				break;
			}
			catch(Exception e){
				driver.findElement(By.xpath("//span[@aria-label='Next Month']")).click();
				//explicit.until(ExpectedConditions.elementToBeClickable(nextButton));
				//nextButton.click();

			}
		}
		driver.findElement(By.linkText("Search")).click();
		
	}


}


