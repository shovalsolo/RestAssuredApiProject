/* 
 * This is a class that is using class ExcelUtils from package baseUtils to read from excel
 */

package readFromExcel;

import baseUtils.ExcelUtils;

public class ExcelUtilsTest {

	public static void main(String[] args) {
		
		String excelPath = "./excelData/data.xlsx";						//Saving the path to the excel file
		
		String sheetName = "Sheet1";									//Saving parameter for the name of the sheet
		
		ExcelUtils excel = new ExcelUtils( excelPath, sheetName);		//Creating an object of the class ExcelUtils to read from excel
		
		excel.getRowCount();											//Calling the function getRowCount that will return the number of Rows
		excel.getCellData(1,0);											//Calling the function getCellData with cell location that will return the content of the cell
		excel.getCellData(1,1);
		excel.getCellData(1,2);
	}

}
