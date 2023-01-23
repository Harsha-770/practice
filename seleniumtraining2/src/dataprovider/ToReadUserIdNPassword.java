package dataprovider;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
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
import org.testng.annotations.Test;

public class ToReadUserIdNPassword {
	@DataProvider
	public static String[][] userIdNPassword() throws EncryptedDocumentException, IOException{
		FileInputStream fis = new FileInputStream(new File("./TestData/TestData.xlsx"));
		Workbook workbook = WorkbookFactory.create(fis);
		Sheet sheet = workbook.getSheet("actiTime");
		int rowCount = sheet.getPhysicalNumberOfRows()-1;
		int col=sheet.getRow(0).getPhysicalNumberOfCells();
		
		
		String data[][]=new String[rowCount][col];
		for(int i=0, j=1;i<rowCount;i++,j++) {
			for(int k=0; k<col;k++) {
				data[i][k]=sheet.getRow(j).getCell(k).toString();
			}
		}
		return data;
	}
	@Test(dataProvider = "userIdNPassword")
	public static void launchApplication(String data[]) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://demo.actitime.com/login.do");
		
		driver.findElement(By.name("username")).sendKeys(data[0]);
		driver.findElement(By.name("pwd")).sendKeys(data[1]);
		driver.findElement(By.id("loginButton")).click();
		driver.quit();
	}

}
