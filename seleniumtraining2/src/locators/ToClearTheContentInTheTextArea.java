package locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ToClearTheContentInTheTextArea {
public static void main(String[] args) throws InterruptedException {
	System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
	ChromeDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://demo.vtiger.com/vtigercrm/ ");
	Thread.sleep(1000);
	WebElement UsernameTextfield = driver.findElement(By.xpath("//input[@id ='username']"));
	UsernameTextfield.clear();
	UsernameTextfield.sendKeys("Harsha.K");
	WebElement passwordTextField = driver.findElement(By.xpath("//input[@id ='password']"));
	passwordTextField.clear();
	passwordTextField.sendKeys("Haesja@789");
	driver.findElement(By.xpath("//button[text() ='Sign in']")).submit();
}
}
