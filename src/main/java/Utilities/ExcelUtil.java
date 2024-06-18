package Utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil {
	private static Workbook workbook;
	private static Sheet sheet;

	//public static boolean shoulRunTest(String filePath, String sheetName, String testcaseType, String testCaseID)
	public static Object[][] getTestData(String filePath, String sheetName, String testCaseID)
	{
		List<Object[]> data = new ArrayList<>();
		try (FileInputStream fileInputStream = new FileInputStream(filePath))
		{
			workbook = new XSSFWorkbook(fileInputStream);
			sheet = workbook.getSheet(sheetName);
			
			int rowCount = sheet.getPhysicalNumberOfRows();
			//int colCount = sheet.getRow(0).getPhysicalNumberOfCells();
			
			//List<Object[]> data = new ArrayList<>();
			for(int i = 1; i<rowCount; i++)
			{
				Row row = sheet.getRow(i);
				if(row != null)
				{
					Cell executionRequiredCell = row.getCell(1);
					//Cell testCaseTypeCell = row.getCell(0);
					Cell testCaseIDCell = row.getCell(4);
					String executionRequired = executionRequiredCell != null ? executionRequiredCell.toString().trim() : "";
					//String curentTestCaseType = testCaseTypeCell != null ? testCaseTypeCell.toString().trim() : "";
					String currentTestCaseID = testCaseIDCell != null ? testCaseIDCell.toString().trim() : "";
	                
					//String executionRequired = row.getCell(1).toString().trim();
					
					//String currentTestCaseType = row.getCell(0).toString().trim();
					//String executionRequired = getCellValueAsString(row.getCell(1));
		            //String currentTestCaseType = getCellValueAsString(row.getCell(0));
					
					//if(executionRequired.equalsIgnoreCase("Yes") && curentTestCaseType.equalsIgnoreCase(testcaseType))
					if(executionRequired.equalsIgnoreCase("Yes") && currentTestCaseID.equalsIgnoreCase(testCaseID))
					{
						String searchTerm = row.getCell(2) != null ? row.getCell(2).toString() : "";
						String isValidSearch = row.getCell(3) != null ? row.getCell(3).toString() : "";
						//List<String> rowData = new ArrayList<>();
						//Object[] rowData = new Object[colCount - 2];
						/*for(int j=2; j<colCount; j++)
						{
							Cell cell = row.getCell(j);
							rowData.add(cell != null ? cell.toString() : "");
						}*/
						data.add(new Object[] {searchTerm, isValidSearch});
					}
				}
			}
			//return data.toArray(new Object[0][]);
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		return data.toArray(new Object[0][]);
	}
}
	/*private static String getCellValueAsString(Cell cell) {
        if (cell == null) {
            return null;
        }
        switch (cell.getCellType()) {
            case STRING:
                return cell.getStringCellValue().trim();
            case NUMERIC:
                return String.valueOf(cell.getNumericCellValue());
            case BOOLEAN:
                return String.valueOf(cell.getBooleanCellValue());
            case BLANK:
                return ""; // Handle blank cells
            default:
                return cell.toString().trim();
        }
    }*/

