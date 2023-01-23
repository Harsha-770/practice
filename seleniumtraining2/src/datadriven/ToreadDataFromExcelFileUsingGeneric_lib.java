package datadriven;

import java.time.LocalDateTime;
import java.util.Date;

import generic_Libraries.GenericMethodToReadDataFromExcel;

public class ToreadDataFromExcelFileUsingGeneric_lib {
	public static void main(String[] args) {
		String key = GenericMethodToReadDataFromExcel.fromExcel("relianceDigital", 0, 0);
		String value = GenericMethodToReadDataFromExcel.fromExcel("relianceDigital", 0, 1);
		System.out.println(key);
		  LocalDateTime date = GenericMethodToReadDataFromExcel.fromExcelLocalDate("relianceDigital", 5, 0);
		 String monthName = date.getMonth().name();
		 System.out.println(monthName);
}
}
