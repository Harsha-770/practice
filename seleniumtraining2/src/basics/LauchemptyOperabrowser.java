package basics;


import org.openqa.selenium.opera.OperaDriver;

public class LauchemptyOperabrowser {
public static void main(String[] args) {
		
		System.setProperty("webdriver.opera.driver","./Driver/operadriver.exe");
		OperaDriver driver1 = new OperaDriver();

	}

}
