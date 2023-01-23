package datadriven;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ToReadDataFromPropertyFile {
	public static void main(String[] args) throws IOException {
		
		//Step 1 : Creating Input stream type object 
		File absPath = new File("./TestData/TestData.properties");
		FileInputStream fis = new FileInputStream(absPath);
		
		//Step 2 : Creating object of File type
		Properties properties = new Properties();
		properties.load(fis);
		
		//Step 3: Read methods
		
		
		
		System.setProperty(properties.get("keys").toString(), properties.get("path").toString());
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		WebDriverWait explicit = new WebDriverWait(driver,15);
		driver.get(properties.get("url").toString());
		WebElement popup = driver.findElement(By.xpath("//button[contains(@id,'cancel')]"));
		explicit.until(ExpectedConditions.elementToBeClickable(popup));
		popup.click();
		
		
		
		
	
		
	}
	

}
