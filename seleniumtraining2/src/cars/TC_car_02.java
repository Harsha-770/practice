package cars;

import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.testng.annotations.Test;

public class TC_car_02 {
	WebDriver driver = null;
	@Parameters("browser")
	@Test
	public void audi(@Optional("chrome")String bname) {
		if(bname.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		}
		else if(bname.equalsIgnoreCase("firefox")){
			driver = new FirefoxDriver();
		}
		else if(bname.equalsIgnoreCase("opera")) {
			driver = new OperaDriver();
		}
		else {
			throw new InvalidBrowserNameExepection();
		}
	driver.manage().window().maximize();
	driver.get("https://www.volkswagen.co.in/");
	driver.quit();
	
}

}
