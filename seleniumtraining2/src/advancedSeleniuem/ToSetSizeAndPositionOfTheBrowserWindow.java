package advancedSeleniuem;


import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.chrome.ChromeDriver;

public class ToSetSizeAndPositionOfTheBrowserWindow {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https:/tesla.com/");
		Dimension  sizeOfTheBrowser =new Dimension(900,900);
		driver.manage().window().setSize(sizeOfTheBrowser);
		Thread.sleep(3000);
		Point positionOfTheBrowser = new Point(0,0);
		driver.manage().window().setPosition(positionOfTheBrowser);
	}

}
