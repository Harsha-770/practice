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
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ToRead5UrlsfromWorkBook {
	@DataProvider
	public static String[] urlData() throws EncryptedDocumentException, IOException{
		FileInputStream input = new FileInputStream(new File("./TestData/TestData.xlsx"));
		Workbook workbook = WorkbookFactory.create(input); 
		Sheet sheet = workbook.getSheet("URl");
		int rowcount = sheet.getPhysicalNumberOfRows()-1;
		int column = sheet.getRow(0).getPhysicalNumberOfCells();
		
		String data[] = new String[rowcount];
		for(int i=0,j=1;i<rowcount;i++,j++) {
			
			data[i]= sheet.getRow(j).getCell(0).toString();
		}
		return data;
	}
	@Test(dataProvider = "urlData")
	public static void launchUrl(String data) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		System.out.println(data);
		driver.get(data);
		driver.quit();
	}
	

}
