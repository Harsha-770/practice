package tasks;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class WoodstreetTask {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.woodenstreet.com/");
		Thread.sleep(15000);
		driver.findElement(By.xpath("//div[@class ='swpmodal-close reqClose']")).click();
		Thread.sleep(15000);
		driver.findElement(By.xpath("//img[@title='Study Table']")).click();
		Thread.sleep(15000);
		String price = driver.findElement(By.xpath("(//div[@class='price'])[2]/strong")).getText();
		System.out.println(price);
		price = price.replace("Rs", "");
		price= price.replaceAll(" ", "");
		price=price.replaceAll(",","");
		System.out.println(price);
		int cost = Integer.parseInt(price);
		if(cost > 10000) {
			System.out.println("the price is tooo high ");
		}
		else {
			String parentWindowId = driver.getWindowHandle();
			driver.findElement(By.xpath("(//div[contains(@id , 'article')])[2]")).click();
			Set<String> allWindowIds = driver.getWindowHandles();
			allWindowIds.remove(parentWindowId);
			for(String windowId: allWindowIds) {
				driver.switchTo().window(windowId);
				driver.findElement(By.xpath("//a[@id='button-cart-buy-now']")).click();
				
		}

	}

}

}
