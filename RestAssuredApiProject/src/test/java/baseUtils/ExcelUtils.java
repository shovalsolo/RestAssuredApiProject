/* 
 * This is a class that is getting information from excel file data.xlsx and this class is called from ExcelUtilsDemo
 * Using 
 * 1. ExcelUtils- Contractor getting 2 parameters file location and sheet name creating XSSFWorkbook object
 * 2. getRowCount- This function will print the number of rows in a sheet
 * 3. getCellData- This function will print the data in a sheet
 * . XSSFWorkbook- XSSFWorkbook instance for excel.xslx files
 * . XSSFSheet- XSSFSheet and giving the sheet name
 */

package baseUtils;

import java.io.IOException;
import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	
	static XSSFWorkbook workbook;
	static XSSFSheet sheet;
	
	public ExcelUtils(String excelPath, String sheetName) {					//Contractor that is getting 2 parameters file location and sheet name
		try {
			workbook = new XSSFWorkbook(excelPath);							//Creating an XSSFWorkbook instance for excel.xslx files
			sheet = workbook.getSheet(sheetName);							//Creating an XSSFSheet and giving the sheet name
		} 
		catch (Exception e) {
			System.out.println("Message is : " +e.getMessage());			//Printing the exception message
			System.out.println("Couse is : " +e.getCause());				//Printing the exception cause
			e.printStackTrace();											//Will print the line of the error
		}
	}
	
	public static void getCellData(int rowNom , int colNum) {

		DataFormatter fomater = new DataFormatter();						//Creating an object of DataFormatter that will format string or integer 
		Object value = fomater.formatCellValue(sheet.getRow(rowNom).getCell(colNum));	//Setting the location of the cell to format

		System.out.println(value);
	}
	
	public static void getRowCount() {
		
		int rowCount = sheet.getPhysicalNumberOfRows();						//Getting the number of rows
		System.out.println("The number of Rows is : "+ rowCount);			//Printing the number of rows		
	}
}
