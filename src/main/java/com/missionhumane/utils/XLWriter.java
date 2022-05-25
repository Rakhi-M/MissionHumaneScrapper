package com.missionhumane.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XLWriter {

	static Workbook excelWorkbook = null;
	public static void writeExcel(String filePath,String fileName,String sheetName,List<List<String>> dataToWrite) throws IOException{

		//Create a object of File class to open xlsx file
		File file =    new File(filePath+"\\"+fileName);

		//Create an object of FileOutputStream class to create write data in excel file
		FileOutputStream outputStream = new FileOutputStream(file);

		Workbook excelWorkbook = new XSSFWorkbook();;     

		//Read excel sheet by sheet name    
		Sheet sheet = excelWorkbook.getSheet(sheetName);   
		sheet=excelWorkbook.createSheet(sheetName);

		Row header = sheet.createRow(0);
		addHeader(header,sheet);
		int rowCount=1;


		//Get the first row from the sheet
		Row row = sheet.getRow(0);

		for(int i=0;i<dataToWrite.get(0).size();i++) {

			//Create a new row and append it at last of sheet
			Row newRow = sheet.createRow(rowCount++);

			//Create a loop over the cell of newly created Row
			for(int j = 0; j < row.getLastCellNum(); j++){
				//Fill data in row
				Cell cell = newRow.createCell(j);
				cell.setCellValue(dataToWrite.get(j).get(i));
			}
		}

		//write data in the excel file
		excelWorkbook.write(outputStream);
		//close output stream
		outputStream.close();
		excelWorkbook.close();
	}


	static void addHeader(Row header, Sheet sheet) {
		Cell cell =  header.createCell(0);
		sheet.autoSizeColumn(0);
		cell.setCellValue("Item Name");

		cell = header.createCell(1);
		sheet.autoSizeColumn(1);
		cell.setCellValue("Contact Name");	

		cell= header.createCell(2);
		sheet.autoSizeColumn(2);
		cell.setCellValue("Contact Number");

		cell= header.createCell(3);
		sheet.autoSizeColumn(3);
		cell.setCellValue("Location");

		cell=header.createCell(4);
		sheet.autoSizeColumn(4);
		cell.setCellValue("Description");



	}
}
