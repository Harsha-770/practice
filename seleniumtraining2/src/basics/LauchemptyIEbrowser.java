package basics;

import org.openqa.selenium.ie.InternetExplorerDriver;



public class LauchemptyIEbrowser {

	public static void main(String[] args) {
		System.setProperty("webdriver.ie.driver","./Driver/IEDriverServer.exe");
		InternetExplorerDriver driver1 = new InternetExplorerDriver ();

	}

}
