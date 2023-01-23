package basics;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadDataFromExcel {
	public static void main(String[] args) throws IOException {
		File abspath = new File("./TestData/TestData");
		FileInputStream fis = new FileInputStream(abspath);
		
		Workbook work = new XSSFWorkbook(fis);
		
	String haesh=	work.getSheet("relianceDigital").getRow(0).getCell(0).toString();
	System.out.println(haesh);
	}

}
