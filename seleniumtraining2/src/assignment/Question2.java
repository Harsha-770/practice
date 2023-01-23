package assignment;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver.Navigation;
import org.openqa.selenium.chrome.ChromeDriver;


// WAS TO NAVIGATE TO ZOMATO AND SWIGGY AND THEN PERFOME BROWSER NAVIGATION FORWARD BACK AND REFRESH
public class Question2 {
	public static void main(String[] args) throws InterruptedException, MalformedURLException {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.zomato.com/");
		System.out.println("hi");
		Thread.sleep(2000);
		driver.get("https://www.swiggy.com/");
		Thread.sleep(2000);
		Navigation navigate = driver.navigate();
		navigate.back();
		Thread.sleep(1000);
		navigate.forward();
		Thread.sleep(2000);
		navigate.refresh();
		Thread.sleep(2000);
		URL url = new URL("https://www.zomato.com/");
		navigate.to(url);
		driver.quit();
	}

}
