package tasks;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Flipkarttask {
	public static WebDriver driver;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		/*System.out.println("Enter the number of product needs to be added in cart");
		int number = sc.nextInt();*/
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		WebDriverWait explicit = new WebDriverWait(driver, 15);
		
		// step-1 open the flipkart 
		driver.get("https://www.flipkart.com/");
		driver.findElement(By.xpath("//button[text()='✕']")).click();
		
		// step -2 Search and Add 3 different product to cart
		
	}
	public static void searchAndAddProduct(String product) {
		driver.findElement(By.name("q")).click();
		driver.findElement(By.name("q")).clear();
	}
}
