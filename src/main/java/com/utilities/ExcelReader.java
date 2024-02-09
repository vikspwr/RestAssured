package com.utilities;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {

	private static XSSFWorkbook workbook;
	private static XSSFSheet sheet;
	private static XSSFRow row;
	private static XSSFCell cell;
	private String excelPath;

	public ExcelReader(String excelPath) {
		this.excelPath = excelPath;
	}

	public int getRowCount(String sheetName) {
		try {
			workbook = new XSSFWorkbook(new FileInputStream(new File(excelPath)));
			sheet = workbook.getSheet(sheetName);
		} catch (Exception e) {

		}

		return sheet.getLastRowNum();
	}

	public int getColumnCount(String sheetName, int rowNumber) {
		try {
			workbook = new XSSFWorkbook(new FileInputStream(new File(excelPath)));
			sheet = workbook.getSheet(sheetName);
			row = sheet.getRow(rowNumber);
		} catch (Exception e) {

		}
		return row.getLastCellNum();
	}

	public String getCellData(String sheetName, int rowNumber, int columnNumber) {

		DataFormatter dataFormatter = new DataFormatter();
		try {
			workbook = new XSSFWorkbook(new FileInputStream(new File(excelPath)));
			sheet = workbook.getSheet(sheetName);
			cell = sheet.getRow(rowNumber).getCell(columnNumber);
		} catch (Exception e) {

		}

		return dataFormatter.formatCellValue(cell);

	}

}
