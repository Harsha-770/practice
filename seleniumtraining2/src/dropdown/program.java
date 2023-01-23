package dropdown;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class program {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.get("https://www.carwale.com/jeep-cars/");
		driver.findElement(By.xpath("//input[@ placeholder ='Search']")).sendKeys("jeep",Keys.ENTER);
		WebElement sortBy = driver.findElement(By.xpath("//select"));
		Select dropdown = new Select(sortBy);
		System.out.println("sortBy dropdown :"+ dropdown.isMultiple());
		List<WebElement> listOfElement = dropdown.getOptions();
		for(WebElement ele : listOfElement) {
			System.out.print(ele.getText());
		}
		dropdown.selectByIndex(2);
	}

}
