package datadriven;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ToreadMutipleDataFromExcelSheet2 {
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		// Step 1 create the fileinput stream class
		FileInputStream fis = new FileInputStream("./TestData/testdata.xlsx");
		
		// step 2 crate the 
		Workbook workbook = WorkbookFactory.create(fis);
		
		//Step 3 call appropriate method read file
		Sheet info=workbook.getSheet("2dArray");
		int rowCount	=info.getPhysicalNumberOfRows();
		int columnCount =info.getRow(0).getPhysicalNumberOfCells();
		
		String Data[][]= new String[rowCount][columnCount];
		for(int i=0; i<rowCount;i++) {
				for(int j=0; j<columnCount;j++) {
					 Data[i][j]=info.getRow(i).getCell(j).toString();
				}
				
		}
		for(String[] innerData: Data) {
				for(String var: innerData) {
					System.out.print(var+",");
				}
				System.out.println();
		}
	}

}
