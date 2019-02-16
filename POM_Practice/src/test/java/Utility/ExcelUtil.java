/**
 * 
 */
package Utility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Platform;

/**
 * @author jayjo
 *
 */
public class ExcelUtil {
	
	//main directory of the project - check and save project directory
	public static final String currentDir = System.getProperty("user.dir");
	//location of Test data excel file
	public static String testDataExcelPath = null;
	
	//excel workbook
	private static XSSFWorkbook excelWBook;
	//excel sheet
	private static XSSFSheet excelWSheet;
	//excel cell
	private static XSSFCell cell;
	//excel row
	private static XSSFRow row;
	//row number
	public static int rowNumber;
	//column number
	public static int columnNumber;
	
	//Setter and Getters of row and columns
	public static void setRowNumber(int pRowNumber) {
		rowNumber = pRowNumber;
	}
	
	public static int getRowNumber() {
		return rowNumber;
	}
	
	public static void setColumnNumber(int pColumnNumber) {
		columnNumber=pColumnNumber;
	}
	public static int getColumnNumber() {
		return columnNumber;
	}
	
	//This method has two parameter: "Test data excel file name" and "Excel sheet name"
	//It create FileInputStream and set excel file and excel sheet to excelWBook and excelWSheet variables.
	 public static void setExcelFileSheet(String sheetName) throws Exception {
	        //MAC or Windows Selection for excel path
	        if (Platform.getCurrent().toString().equalsIgnoreCase("MAC")) {
	            testDataExcelPath = currentDir + "//src//test//resources//testData//";
	        } else if (Platform.getCurrent().toString().contains("WIN")) {
	            testDataExcelPath = currentDir + "\\src\\test\\resources\\testData\\";
	        }
	        try {
	            // Open the Excel file
	            FileInputStream ExcelFile = new FileInputStream(testDataExcelPath + "TestData.xlsx");
	            excelWBook = new XSSFWorkbook(ExcelFile);
	            excelWSheet = excelWBook.getSheet(sheetName);
	        } catch (Exception e) {
	            try {
	                throw (e);
	            } catch (IOException e1) {
	                e1.printStackTrace();
	            }
	        }
	    }
	
		
	//This method reads the test data from the Excel cell
	//We are passing row number and column number as parameters.
	public static String getCellData(int RowNum, int ColNum) throws Exception {
		  try {
	            cell = excelWSheet.getRow(RowNum).getCell(ColNum);
	            DataFormatter formatter = new DataFormatter();
	            String cellData = formatter.formatCellValue(cell);
	            return cellData;
	        } catch (Exception e) {
	            throw (e);
	        }
	    
	}
	
	
	//This method takes row data as a parameter and returns the data of given row number.
	 public static XSSFRow getRowData(int RowNum) throws Exception {
	        try {
	            row = excelWSheet.getRow(RowNum);
	            return row;
	        } catch (Exception e) {
	            throw (e);
	        }
	    }
	
    //This method gets excel file, row and column number and set a value to the that cell.
	 public static void setCellData(String value, int RowNum, int ColNum) throws Exception {
	        try {
	            row = excelWSheet.getRow(RowNum);
	            cell = row.getCell(ColNum);
	            if (cell == null) {
	                cell = row.createCell(ColNum);
	                cell.setCellValue(value);
	            } else {
	                cell.setCellValue(value);
	            }
	            // Constant variables Test Data path and Test Data file name
	            FileOutputStream fileOut = new FileOutputStream(testDataExcelPath + "TestData.xlsx");
	            excelWBook.write(fileOut);
	            fileOut.flush();
	            fileOut.close();
	        } catch (Exception e) {
	            try {
	                throw (e);
	            } catch (IOException e1) {
	                e1.printStackTrace();
	            }
	        }
	    }
	
    
    
	

}
