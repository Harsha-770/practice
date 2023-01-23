package locators;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ToCheckTheOverLappingOfWebelement {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();


		Thread.sleep(1000);
		driver.get("https://www.facebook.com/login");
		WebElement emailTextField = driver.findElement(By.id("email"));
		WebElement passwordTextField = driver.findElement(By.xpath("//div[@class='_55r1 _1kbt']"));
		
		Dimension sizeOfTheEmailTextField = emailTextField.getSize();
		Point locationOfTheEmailTextField = emailTextField.getLocation();
		Dimension sizeOfThePasswordTextField = passwordTextField.getSize();
		Point locationOThePasswordTextField = passwordTextField.getLocation();
		
		int yLocationOfTheEmailTextField = locationOfTheEmailTextField.y;
		int yLocationOfThePasswordTextField = locationOThePasswordTextField.y;
		int gapBetweenTheEmailAnadPasswordTextBox = (yLocationOfThePasswordTextField) - (yLocationOfTheEmailTextField+sizeOfTheEmailTextField.height);
		System.out.println(gapBetweenTheEmailAnadPasswordTextBox);
		if((yLocationOfThePasswordTextField)==(yLocationOfTheEmailTextField+sizeOfTheEmailTextField.height+gapBetweenTheEmailAnadPasswordTextBox))
			System.out.println("the password and email textfield are not overlapping ");
		else
			System.out.println("the password and email textfield are  overlapping ");
			
		
		driver.quit();
	}

}
