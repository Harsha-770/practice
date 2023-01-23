package locators;
//to check the alligment of facebook page;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ToGetSizeandLocationOfTheWebelement {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();


		Thread.sleep(1000);
		driver.get("https://www.facebook.com/login");
		WebElement emailTextField = driver.findElement(By.id("email"));
		WebElement passwordTextField = driver.findElement(By.xpath("//div[@class='_55r1 _1kbt']"));

		Dimension sizeOfTheEmailTextField = emailTextField.getSize();
		Point locationOfTheEmailTextField = emailTextField.getLocation();
		Dimension sizeOfThePasswordTextField = passwordTextField.getSize();
		Point locationOThePasswordTextField = passwordTextField.getLocation();

		int xLocationOfTheEmailTextField = locationOfTheEmailTextField.x;
		int xLocationOfThePasswordTextField = locationOThePasswordTextField.x;
		int widthOfTheEmailTextFieldplusxlocationofEmailTextField = sizeOfTheEmailTextField.width+xLocationOfTheEmailTextField;
		int widthOfThePasswordFieldplusxlocationOfPasswordTextField = sizeOfThePasswordTextField.width+xLocationOfThePasswordTextField;

		System.out.println("width of the email Text field ="+sizeOfTheEmailTextField.width);
		System.out.println("width of the password The field ="+sizeOfTheEmailTextField.width);
		System.out.println("xlocationOfTheEmailTextField ="+xLocationOfTheEmailTextField);
		System.out.println("xLocationOfThePasswordTextField ="+xLocationOfThePasswordTextField);

		//(check the left alignment 
		if(xLocationOfTheEmailTextField==xLocationOfThePasswordTextField) 
			System.out.println("email text field and password textfield are alligned properly toward left");

		else
			System.out.println("email text field and password textfield are not  alligned properly toward left");


		///(check the alignment towards right alignment 
		if(widthOfTheEmailTextFieldplusxlocationofEmailTextField==widthOfThePasswordFieldplusxlocationOfPasswordTextField)
			System.out.println("email text field and password textfield are alligned properly toward right");
		else
			System.out.println("email text field and password textfield are not  alligned properly toward right");
		Thread.sleep(2000);
		driver.quit();	
	}

}
