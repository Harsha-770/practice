package advancedSeleniuem;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.chrome.ChromeDriver;

public class ToCaptureSizeAndPositionOfTheBrowserWindow {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","./driver/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.tesla.com/");
		Dimension sizeOfTheBrowser= driver.manage().window().getSize();
		int heigth = sizeOfTheBrowser.getHeight();
		int width = sizeOfTheBrowser.getWidth();
		System.out.println("Height ="+heigth);
		System.out.println("Width ="+width);
		
		
		org.openqa.selenium.Point positionOfTheBrowser = driver.manage().window().getPosition();
		System.out.println("x :"+positionOfTheBrowser.getX());
		System.out.println("y :"+positionOfTheBrowser.getY());
	}

}
