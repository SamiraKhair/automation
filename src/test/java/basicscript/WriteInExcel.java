package basicscript;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class WriteInExcel {
    public static void main(String[] args) {
        // Ensure directory exists
        File directory = new File(".\\dataFiles");
        if (!directory.exists()) {
            directory.mkdirs();
        }

        // Define the file path
        String excelFilePath = ".\\dataFiles\\CustomerData1.xlsx";

        // Create a Workbook and a Sheet
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Customers");

        // Dummy data for the Excel file
        Object[][] customerData = {
                {"Customer ID", "Valid To", "Valid From", "Billable"},
                {"CUST001", "2024-12-31", "2024-01-01", true},
                {"CUST002", "2025-06-30", "2024-07-01", false},
                {"CUST003", "2025-12-31", "2025-01-01", true},
                {"CUST004", "2026-03-31", "2025-04-01", false},
                {"CUST005", "2026-12-31", "2026-01-01", true}
        };

        // Populate the sheet with data
        int rowCount = 0;
        for (Object[] rowData : customerData) {
            Row row = sheet.createRow(rowCount++);
            int columnCount = 0;
            for (Object field : rowData) {
                Cell cell = row.createCell(columnCount++);
                if (field instanceof String) {
                    cell.setCellValue((String) field);
                } else if (field instanceof Boolean) {
                    cell.setCellValue((Boolean) field);
                } else if (field instanceof Integer) {
                    cell.setCellValue((Integer) field);
                } else if (field instanceof Double) {
                    cell.setCellValue((Double) field);
                }
            }
        }

        // Write the data to the Excel file
        try (FileOutputStream outputStream = new FileOutputStream(excelFilePath)) {
            workbook.write(outputStream);
            System.out.println("Excel file written successfully to " + excelFilePath);
        } catch (IOException e) {
            System.err.println("Error writing Excel file: " + e.getMessage());
        }

        // Close the workbook
        try {
            workbook.close();
        } catch (IOException e) {
            System.err.println("Error closing workbook: " + e.getMessage());
        }
    }
}
