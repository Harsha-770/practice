package basics;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class ToUnderstandpassingParameterUsingTestNg {
	@Parameters("url")
	@Test
	public  void TopassUrlFromXml(@Optional("https://zerodha.com/brokerage-calculator/#tab-equities")String a) {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		System.out.println(a);
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.get(a);
		
		
	}

}
