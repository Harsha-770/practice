package tasks;

import java.util.concurrent.TimeUnit;

import javax.security.auth.kerberos.KeyTab;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;

public class Rediff {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS );
		//step 1: open www.rediff.com
		driver.get("https://www.rediff.com/");
		
		//step 2 : enter the user id and password 
		driver.findElement(By.xpath("//a[text()='Sign in']")).click();
		driver.findElement(By.id("login1")).sendKeys("sumanthElfBatch@rediffmail.com",Keys.TAB);
		driver.findElement(By.id("password")).sendKeys("Testing@123",Keys.ENTER);
		//step3: compose an email.
		driver.findElement(By.xpath("//b[text()='Write mail']")).click();
		driver.findElement(By.xpath("(//a[@title='New Mail'])")).click();
		driver.findElement(By.xpath("//label[text()='To:']/..//input[@type='text']")).sendKeys("sumanthElfBatch@rediffmail.com",Keys.TAB);
		driver.findElement(By.xpath("//label[text()='Subject:']/..//input[@type='text']")).sendKeys("Harsha.K",Keys.TAB);
	}

}
