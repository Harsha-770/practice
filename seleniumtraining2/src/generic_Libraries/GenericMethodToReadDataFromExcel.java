package generic_Libraries;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class GenericMethodToReadDataFromExcel {
	/**
	 * this method is used to the get the String  values from the workbook in any file form excel sheet
	 * @param SheetName should pass the sheet name
	 * @param rowNo should pass the sheet now where the 
	 * @param cellNo should pass the 
	 * @return
	 */
	public static String fromExcel(String SheetName, int rowNo, int cellNo) {
		FileInputStream fis = null;
		Workbook workbook = null;
		try {
			fis = new FileInputStream(new File ("./Testdata/TestData.xlsx"));
			try {
				workbook = WorkbookFactory.create(fis);
			} catch (EncryptedDocumentException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return workbook.getSheet(SheetName).getRow(rowNo).getCell(cellNo).getStringCellValue().toString();
	}
	/**
	 * this method is used to the get the numeric values from the workbook in any file form excel sheet
	 * @param SheetName : should  pass the name of the sheet;
	 * @param rowNo	    : should pass the row no with value is present;
	 * @param cellNo	: should pass the cell no where the value is present;
	 * @return
	 */
	public static double fromExcelint(String SheetName, int rowNo, int cellNo) {
		FileInputStream fis = null;
		Workbook workbook = null;
	
		try {
			fis = new FileInputStream(new File ("./Testdata/TestData.xlsx"));
			try {
				workbook = WorkbookFactory.create(fis);
			} catch (EncryptedDocumentException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return  workbook.getSheet(SheetName).getRow(rowNo).getCell(cellNo).getNumericCellValue();
	}
	/**
	 *  * this method is used to the get the boolean values from the workbook in any file form excel sheet
	 * @param SheetName : should  pass the name of the sheet;
	 * @param rowNo	    : should pass the row no with value is present;
	 * @param cellNo	: should pass the cell no where the value is present;
	 * @return
	 */
	public static boolean fromExcelBoolean(String SheetName, int rowNo, int cellNo) {
		FileInputStream fis = null;
		Workbook workbook = null;
		try {
			fis = new FileInputStream(new File ("./Testdata/TestData.xlsx"));
			try {
				workbook = WorkbookFactory.create(fis);
			} catch (EncryptedDocumentException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return  workbook.getSheet(SheetName).getRow(rowNo).getCell(cellNo).getBooleanCellValue();
		
	}
	/**
	 * this method is used to the get the localDate  values from the workbook in any file form of excel sheet 
	 * @param SheetName
	 * @param rowNo
	 * @param cellNo
	 * @return
	 */
	
	public static LocalDateTime fromExcelLocalDate(String SheetName, int rowNo, int cellNo) {
		FileInputStream fis = null;
		Workbook workbook = null;
		try {
			fis = new FileInputStream(new File ("./Testdata/TestData.xlsx"));
			try {
				workbook = WorkbookFactory.create(fis);
			} catch (EncryptedDocumentException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return workbook.getSheet(SheetName).getRow(rowNo).getCell(cellNo).getLocalDateTimeCellValue();
		
	}
}
	
