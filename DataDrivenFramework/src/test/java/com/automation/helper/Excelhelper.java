package com.automation.helper;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excelhelper {

	public static Object[][] excelhelper(String path, String sheetname) throws Exception {

		File file = new File(path);

		FileInputStream fp = new FileInputStream(file);

		Workbook workbook = WorkbookFactory.create(fp);

		Sheet sheet = workbook.getSheet(sheetname);

		Object[][] data = new Object[sheet.getPhysicalNumberOfRows()-1][sheet.getRow(0).getPhysicalNumberOfCells()];

		for (int row = sheet.getFirstRowNum()+1; row <= sheet.getLastRowNum(); row++) {
			for (int cell = sheet.getRow(row).getFirstCellNum(); cell < sheet.getRow(row).getLastCellNum(); cell++) {
				data[row-1][cell] = sheet.getRow(row).getCell(cell).toString();
			}
		}

		workbook.close();

		return data;

	}
}
