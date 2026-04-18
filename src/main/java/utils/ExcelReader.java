package utils;

import org.apache.poi.ss.usermodel.*;
import java.io.FileInputStream;
import java.util.*;

public class ExcelReader {

    public static List<Map<String, String>> load(String path, String sheetName) {

        List<Map<String, String>> dataList = new ArrayList<>();
        DataFormatter formatter = new DataFormatter(); // 🔥 key change

        try (FileInputStream file = new FileInputStream(path);
             Workbook workbook = WorkbookFactory.create(file)) {

            Sheet sheet = workbook.getSheet(sheetName);

            if (sheet == null) {
                throw new RuntimeException("Sheet not found: " + sheetName);
            }

            Row headerRow = sheet.getRow(0);
            int colCount = headerRow.getPhysicalNumberOfCells();

            for (int i = 1; i <= sheet.getLastRowNum(); i++) {

                Row row = sheet.getRow(i);
                if (row == null) continue;

                Map<String, String> rowData = new HashMap<>();

                for (int j = 0; j < colCount; j++) {

                    String key = headerRow.getCell(j)
                            .toString().trim().toLowerCase();

                    Cell cell = row.getCell(j);

                    // 🔥 DataFormatter handles everything
                    String value = formatter.formatCellValue(cell).trim();

                    rowData.put(key, value);
                }

                dataList.add(rowData);
            }

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to read Excel file");
        }

        return dataList;
    }
}

