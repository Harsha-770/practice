package tasks;

import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.server.commandhandler.ExceptionHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Task {
	public static void main(String[] args) throws InterruptedException {
		System.out.println("enter the product");
		Scanner sc=new Scanner(System.in);
		String product=sc.nextLine();
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		WebDriverWait explicit = new WebDriverWait(driver,20);
		driver.get("https://www.reliancedigital.in/");
		driver.findElement(By.id("wzrk-cancel")).click();
		driver.findElement(By.id("suggestionBoxEle")).sendKeys(product,Keys.ENTER);
		String parentWindowId = driver.getWindowHandle();
		try {
			driver.findElement(By.xpath("(//li[contains(@class,'grid')]//a)[4]")).click();
		}
		catch (StaleElementReferenceException e) {
			driver.navigate().refresh();
			driver.findElement(By.xpath("(//li[contains(@class,'grid')]//a)[4]")).click();
		}
		Set<String> allWindowId = driver.getWindowHandles();
		allWindowId.remove(parentWindowId);
		for(String windowId:allWindowId) {
			driver.switchTo().window(windowId);
		}
		String price=driver.findElement(By.xpath("(//li[text()='Deal Price: ']/..//span[contains(text(),',')])")).getText();
		System.out.println(price);
		price=price.replaceAll(",", "");
		price=price.replaceAll(" ", "");
		System.out.println(price);
		double pricevalue = Double.parseDouble(price);
		if(pricevalue>40000.00) {
			System.out.println("price is too hight!!!!!");
			System.out.println("thank you");
			driver.quit();
		}
		else {
			try {
				driver.findElement(By.xpath("//input[@id='RIL_PDPInputPincode']")).click();
			}
			catch(StaleElementReferenceException e) {
				driver.findElement(By.xpath("//input[@id='RIL_PDPInputPincode']")).click();
				driver.findElement(By.xpath("//input[@id='RIL_PDPInputPincode']")).sendKeys("562110",Keys.ENTER);
			}
			driver.findElement(By.xpath("//input[@id='RIL_PDPInputPincode']")).sendKeys("562110");
			WebElement deliveryStatus = driver.findElement(By.xpath("//img[@alt='Standard Delivery']"));
			explicit.until(ExpectedConditions.visibilityOf(deliveryStatus));
			driver.findElement(By.id("add_to_cart_main_btn")).click();
			driver.findElement(By.id("btn-continue-to-cart")).click();
		}

	}
}

