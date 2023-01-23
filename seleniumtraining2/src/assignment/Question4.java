// WAS TO MOVE THE WINDOW TO THESE CO - ORDINATE (100,50)
package assignment;

import org.openqa.selenium.Point;
import org.openqa.selenium.chrome.ChromeDriver;

public class Question4 {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.zomato.com/");
		driver.manage().window().maximize();
		Thread.sleep(3000);
		Point point = new Point(100,50);
		
		driver.manage().window().setPosition(point);
		
		

	}

}
