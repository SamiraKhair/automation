package basicscript;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ReadingExcelFiles {
    public static void main(String[] args) {
        String excelFilePath = ".\\dataFiles\\CustomerData.xlsx"; // File path for the Excel file

        // Verify if file exists
        File excelFile = new File(excelFilePath);
        if (!excelFile.exists()) {
            System.err.println("Error: File not found at " + excelFilePath);
            return;
        }
        //random

        // Read the Excel file
        try (FileInputStream inputStream = new FileInputStream(excelFilePath);
             XSSFWorkbook workbook = new XSSFWorkbook(inputStream)) {

            XSSFSheet sheet = workbook.getSheetAt(0); // Get the first sheet
            if (sheet == null) {
                System.err.println("Error: No sheets found in the workbook.");
                return;
            }

            int rows = sheet.getLastRowNum(); // Get total rows
            int cols = sheet.getRow(0).getLastCellNum(); // Get total columns

            System.out.println("Reading data from: " + excelFilePath);
            System.out.println("------------------------------------------------");

            // Iterate through rows and columns
            for (int r = 0; r <= rows; r++) {
                Row row = sheet.getRow(r);
                if (row == null) continue; // Skip empty rows

                for (int c = 0; c < cols; c++) {
                    Cell cell = row.getCell(c);
                    if (cell == null) {
                        System.out.print("NULL\t");
                        continue;
                    }

                    // Handle different cell types
                    switch (cell.getCellType()) {
                        case STRING:
                            System.out.print(cell.getStringCellValue() + "\t");
                            break;
                        case NUMERIC:
                            System.out.print(cell.getNumericCellValue() + "\t");
                            break;
                        case BOOLEAN:
                            System.out.print(cell.getBooleanCellValue() + "\t");
                            break;
                        default:
                            System.out.print("UNKNOWN\t");
                    }
                }
                System.out.println(); // Move to the next row
            }
        } catch (IOException e) {
            System.err.println("Error reading the Excel file: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
