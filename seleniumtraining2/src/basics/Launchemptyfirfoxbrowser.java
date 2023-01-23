package basics;

import org.openqa.selenium.firefox.FirefoxDriver;

public class Launchemptyfirfoxbrowser {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.gecko.driver","./Driver/geckodriver.exe");
		FirefoxDriver driver1 = new FirefoxDriver();

	}

}
