package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	public static Object[][] readExcelData(String filePath, String sheetName) throws IOException {
		FileInputStream file = new FileInputStream(filePath);
		Workbook workbook = new XSSFWorkbook(file);
		Sheet sheet = workbook.getSheet(sheetName);

		int rowCount = sheet.getPhysicalNumberOfRows();
		int colCount = sheet.getRow(0).getPhysicalNumberOfCells();

		Object[][] data = new Object[rowCount - 1][colCount]; // Skipping header row

		Iterator<Row> rowIterator = sheet.iterator();
		rowIterator.next(); // Skip header

		int i = 0;
		while (rowIterator.hasNext()) {
			Row row = rowIterator.next();
			for (int j = 0; j < colCount; j++) {
				data[i][j] = row.getCell(j).toString();
			}
			i++;
		}
		workbook.close();
		return data;
	}

}
