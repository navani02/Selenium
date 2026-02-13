package org.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataDriveFramework { 
public static void main(String[] args) throws IOException {
		
		//Locate the File --> Create object for File
				File f = new File("C:\\Users\\Aparna\\eclipse-workspace\\Framework10ambatch\\ExcelFolder\\TestDatas.xlsx");
				//Read that File --> Create object for FileInputStream
				FileInputStream fis = new FileInputStream(f);
				//Read that book --> create Object for Workbook-i -- XSSFWorkbook 
			    Workbook w = new XSSFWorkbook(fis); 
			    //Get the sheet from book  --> call getSheet()
			    Sheet sh = w.getSheet("Sheet1");
				//Get the Row from Sheet ==> Call getRow()
			    for (int i = 0; i < sh.getPhysicalNumberOfRows(); i++) {
			    	Row r = sh.getRow(i);
			    	for (int j = 0; j < r.getPhysicalNumberOfCells(); j++) {
			    		//Get the cell from row ==> Call getCell()
					    Cell c = r.getCell(j);
					    int type = c.getCellType();
					    String value ="";
					    if(type==1) {
					    	value = c.getStringCellValue();
					    }
					    else if(DateUtil.isCellDateFormatted(c)){
					    	Date dd = c.getDateCellValue();
					    	SimpleDateFormat sdf = new SimpleDateFormat("dd-mm-yyyy");
					    	value = sdf.format(dd);      
					    }
					    else {
					    	double number = c.getNumericCellValue();
					    	long l = (long)number;
					    	value = String.valueOf(l); 
					    }
					    	System.out.println(value);
					    
					
					}
			    	System.out.println();
				}
			    
			    

}
}
