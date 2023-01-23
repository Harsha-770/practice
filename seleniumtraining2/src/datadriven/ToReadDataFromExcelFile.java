package datadriven;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ToReadDataFromExcelFile {
	public static void main(String[] args) throws IOException {
		
		// Step 1: Creating Input Stream type object
		File absPath = new File("./testData/TestData.xlsx");
		FileInputStream fis = new FileInputStream(absPath);
		
		// Step 2 : Creating object of file type
		Workbook workbook = new XSSFWorkbook(fis);
		
		// step 3 : Read methods
		String key = workbook.getSheet("relianceDigital").getRow(0).getCell(0).getStringCellValue();
		String value = workbook.getSheet("relianceDigital").getRow(0).getCell(1).getStringCellValue();
		String url = workbook.getSheet("relianceDigital").getRow(1).getCell(0).getStringCellValue();
		String product = workbook.getSheet("relianceDigital").getRow(2).getCell(0).getStringCellValue();	
		int Quantatiy=  (int) workbook.getSheet("relianceDigital").getRow(3).getCell(0).getNumericCellValue();
		boolean flag = workbook.getSheet("relianceDigital").getRow(4).getCell(0).getBooleanCellValue();
		
		
		System.setProperty(key, value);
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);
		System.out.println(Quantatiy);
		System.out.println(flag);
	}

}
