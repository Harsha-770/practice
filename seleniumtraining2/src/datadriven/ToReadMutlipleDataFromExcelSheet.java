package datadriven;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ToReadMutlipleDataFromExcelSheet {
	
	public static void main(String[]args) throws IOException {
		
		//step-1 : Creating input stream type object
		File absPath = new File("./TestData/TestData.xlsx");
		FileInputStream fis = new FileInputStream(absPath);
		
		//Step-2 : Creating object FileType
		Workbook workBook = new XSSFWorkbook(fis);
		
		Sheet info = workBook.getSheet("2dArray");
		int rowCount = info.getPhysicalNumberOfRows();
		int columnCount=info.getRow(1).getPhysicalNumberOfCells();
		
		String allData[][]=new String[rowCount][columnCount];
		for(int i =0;i<rowCount;i++) {
				for(int j=0; j<columnCount;j++) {
					allData[i][j]= info.getRow(i).getCell(j).toString();
				}
		}
	
		for(String[] arry : allData) {
			for(String infodata : arry) {
				System.out.print(infodata+"   ");
			}
			System.out.println();
		}
	}

}
