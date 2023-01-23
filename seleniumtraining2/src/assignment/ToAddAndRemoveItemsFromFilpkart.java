package assignment;


import java.util.*;
import java.util.concurrent.TimeUnit;

import org.omg.PortableInterceptor.INACTIVE;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
/***
 * 
 * @author harsha
 *
 */
public class ToAddAndRemoveItemsFromFilpkart {

	public static void main(String[] args)  {

		//User Input for number of phones and brandname
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number of phones");
		int number = sc.nextInt();
		String brandName[] = new String[number];
		System.out.println("Enter the brand names");
		for(int i=0;i<number;i++) {
			brandName[i] = sc.next();
		}

		//opening browser and website
		System.setProperty("webdriver.chrome.driver","./driver/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		WebDriverWait explicitwait = new WebDriverWait(driver, 15);
		System.out.println("chrome browser opened");

		driver.get("https://www.flipkart.com/");
		Map<Integer, String> product = new TreeMap<Integer, String>();
		driver.findElement(By.xpath("//button[text()='✕']")).click();

		//homepage
		String parentWindowId = driver.getWindowHandle();


		//search for phone
		String phoneName="";
		for(int i=0;i<number;i++) {
			driver.findElement(By.name("q")).sendKeys(Keys.CONTROL+"a");
			driver.findElement(By.name("q")).sendKeys(Keys.DELETE);
			driver.findElement(By.name("q")).sendKeys(brandName[i]+" phone");
			driver.findElement(By.xpath("//button[@type='submit']")).submit();
			System.out.println("selected phone"+(i+1));

			//selecting phone
			try {
				WebElement phone = driver.findElement(By.xpath("(//img[@loading='eager'])[1]"));
				phoneName=driver.findElement(By.xpath("//div[contains(text(),'(')]")).getText();
				phone.click();
			}
			catch(Exception e) {
				driver.navigate().refresh();
				WebElement catchphone = driver.findElement(By.xpath("//div[contains(text(),')')]"));
				phoneName=driver.findElement(By.xpath("//div[contains(text(),'(')]")).getText();
				catchphone.click();
			}

			//navigating to child tab
			Set<String> windowIds = driver.getWindowHandles();
			windowIds.remove(parentWindowId);
			for(String windowid:windowIds) {
				driver.switchTo().window(windowid);
			}

			//get phonePrice and phoneName
			System.out.println("phone name: "+phoneName);
			String PhonePrice = driver.findElement(By.xpath("(//div[contains(text(),'₹')])[1]")).getText();
			System.out.println("phone price: "+PhonePrice);
			PhonePrice=PhonePrice.replaceAll("[^0-9]","");
			int mobilePrice = Integer.parseInt(PhonePrice);

			//adding phoneName and phonePrice to map
			product.put(mobilePrice, phoneName) ;

			//add phone to cart
			driver.findElement(By.xpath("//button[text()='Add to cart' or text()='GO TO CART']")).click();
			System.out.println("phone added to cart");
			explicitwait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Place Order']")));

			//close child tab
			driver.close();
			driver.switchTo().window(parentWindowId);
		}

		//sorting according to phonePrice and getting the lowest price
		Integer minimum = Collections.min(product.keySet());
		System.out.println(product.keySet());
		System.out.println("lowest price: "+minimum);
		String actualPhoneName = product.get(minimum);
		System.out.println("lowest priced phone: "+actualPhoneName );

		//opening cart
		System.out.println("opened cart page");
		driver.findElement(By.xpath("//span[text()='Cart']")).click();

		//Remove the cheapest phone from cart
		int k=3;
		for(;;) {
			try {
				String titleInCart = driver.findElement(By.xpath("//div[@class='_1AtVbE col-12-12']["+(k++)+"]//a[text()]")).getText();
				if(titleInCart.equals(actualPhoneName)) {
					driver.findElement(By.xpath("//a[text()='"+actualPhoneName+"']/../../../..//div[text()='Remove']")).click();
					driver.findElement(By.xpath("//div[contains(text(),'remove this item?')]/..//div[text()='Remove']")).click();
					System.out.println("deleted the phone");
					break;
				}
			}
			catch(Exception e) {
				((JavascriptExecutor) driver).executeScript("window.scrollBy(0,250)");
				k--;
			}
		}
		
		//quit
		System.out.println("quit application");
		//driver.quit();
	}
}