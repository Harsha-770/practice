package dataprovider;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ToregisterUserToDemoWebShop {
	@DataProvider
	public static String[][] ToreadDataFromExcelSheet() throws EncryptedDocumentException, IOException{
		FileInputStream fis = new FileInputStream(new File("./TestData/TestData.xlsx"));
		Workbook workbook = WorkbookFactory.create(fis);
		Sheet sheet = workbook.getSheet("DemoWebShop");
		int rowCount = sheet.getPhysicalNumberOfRows()-1;
		int col = sheet.getRow(0).getPhysicalNumberOfCells()-1;
		String data[][]= new String[rowCount][col];
		for(int i=0,j=1; i<rowCount;i++,j++) {
			for(int k =0,l=1; k<col;k++,l++) {
				data[i][k]=sheet.getRow(j).getCell(l).toString();
			}
		}
		return data;
	}
	@Test(dataProvider="ToreadDataFromExcelSheet")
	public static void launch(String[] data) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.get("https://demowebshop.tricentis.com/register");
		driver.findElement(By.id("gender-"+data[0]+"")).click();
		driver.findElement(By.id("FirstName")).sendKeys(data[1]);
		driver.findElement(By.id("LastName")).sendKeys(data[2]);
		driver.findElement(By.id("Email")).sendKeys(data[3]);
		driver.findElement(By.id("Password")).sendKeys(data[4]);
		driver.findElement(By.id("ConfirmPassword")).sendKeys(data[5]);
		driver.findElement(By.id("register-button")).click();
		Thread.sleep(2000);
		driver.quit();
		
		
	}
	

}
