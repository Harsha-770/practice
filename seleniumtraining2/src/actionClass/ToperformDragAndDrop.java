package actionClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ToperformDragAndDrop {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		WebDriverWait explicit = new WebDriverWait(driver, 15);
		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		//open the website
		driver.get("https://www.globalsqa.com/demo-site/draganddrop/");
		System.out.println("website opened");

		//to perform drag and drop action
		WebElement frame = driver.findElement(By.xpath("//iframe[@class='demo-frame lazyloaded']"));
		driver.switchTo().frame(frame);
		System.out.println("control switched to frame");
		WebElement trash = driver.findElement(By.id("trash"));
		WebElement image4 = driver.findElement(By.xpath("//img[@alt='Planning the ascent']"));
		WebElement image3 = driver.findElement(By.xpath("//img[@alt='On top of Kozi kopka']"));
		WebElement image2 = driver.findElement(By.xpath("//img[@alt='The chalet at the Green mountain lake']"));
		WebElement image = driver.findElement(By.xpath("//img[@alt='The peaks of High Tatras']"));

		//to move to the trash
		Actions action = new Actions(driver);
		action.dragAndDrop(image, trash).perform();
		System.out.println("first mage moved to trash");
		Thread.sleep(2000);
		action.dragAndDrop(image2, trash).perform();
		System.out.println("second image moved to trash");
		Thread.sleep(2000);
		action.dragAndDrop(image3, trash).perform();
		System.out.println("Thrid image is moved to trash" );
		Thread.sleep(2000);
		action.dragAndDrop(image4, trash).perform();
		System.out.println("fourth image is moved to trash" );

		//removing the two image from the trash
		WebElement gallery = driver.findElement(By.id("gallery"));
		action.clickAndHold(image).release(gallery).perform();
		System.out.println("image 1  is removed ");
		action.clickAndHold(image2).release(gallery).perform();
		System.out.println("image 2 is removed");
		driver.switchTo().defaultContent();
		System.out.println("brought back the control to the webpage");

		//performing the second task
		driver.findElement(By.id("Accepted Elements")).click();
		WebElement frame2 = driver.findElement(By.xpath("(//iframe[@class='demo-frame lazyloaded'])[2]"));
		driver.switchTo().frame(frame2);
		explicit.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("draggable"))));
		WebElement drag = driver.findElement(By.id("draggable"));
		WebElement drop = driver.findElement(By.id("droppable"));
		Thread.sleep(2000);
		action.clickAndHold(drag).release(drop).perform() ;


	}

}
