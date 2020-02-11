package ExcelUtility;

import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;

import org.apache.poi.xssf.usermodel.XSSFFormulaEvaluator;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


//Equifax excel utility
public class ExcelUtil {
	
	public static final String excelPath=System.getProperty("user.dir")+"/src/main/resources/TestData/TestData.xlsx";
	
//	public ExecutionContext context;
	public FileInputStream fis =null;
	public XSSFWorkbook workbook=null;
	public XSSFSheet sheet = null;
	public XSSFRow row=null;
	public XSSFRow rowHeader =null;
	
	public void loadExcel(String sheetName)
	{
		try{
		fis = new FileInputStream(new File(excelPath));
		workbook = new XSSFWorkbook(fis);
		sheet = workbook.getSheet(sheetName);
		XSSFFormulaEvaluator.evaluateAllFormulaCells(workbook);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public HashMap<String, String> readData(String key, String value)
	{
		HashMap<String, String> data =new HashMap<String, String>();
		int cellValue = 0;
		int rowValue = 0;
		int rowCount = sheet.getPhysicalNumberOfRows();
		row = sheet.getRow(0);
		int cellCount = row.getPhysicalNumberOfCells();
		
		for(int j=0;j<cellCount;j++)
		{
			if(row.getCell(j).getStringCellValue().trim().equals(key.trim()))
			{
				cellValue=j;
				break;
			}
		}
		
		for(int i=0;i<rowCount;i++)
		{
			row = sheet.getRow(i);
			if(row.getCell(cellValue).getStringCellValue().trim().equals(value.trim()))
			{
				rowValue =i;
				break;
			}
		}
		
		for(int i=0;i<cellCount;i++)
		{
			rowHeader = sheet.getRow(0);
			String keyName = rowHeader.getCell(i).getStringCellValue().trim();	
			row = sheet.getRow(rowValue);
			String valueName =null;
			
			try{
				if(row.getCell(i).getStringCellValue().trim().startsWith("#"))
				{
					valueName = row.getCell(i).getStringCellValue().trim().substring(1);
				}
				else
				{
					valueName = row.getCell(i).getStringCellValue().trim();
				}
				
				data.put(keyName, valueName);
			}catch(Exception e){
				data.put(keyName, null);
			}
		}
		return data;
		
	}

}
