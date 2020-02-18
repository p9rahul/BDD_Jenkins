//package ExcelUtility;
//
//import java.io.File;
//import java.io.FileInputStream;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.Map;
//
//import org.apache.poi.ss.usermodel.DataFormatter;
//import org.apache.poi.ss.usermodel.Row;
//import org.apache.poi.xssf.usermodel.XSSFSheet;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//
//public class ExcelReader2 {
//
//	public static final String  excelFileLocation = System.getProperty("user.dir")+ "\\src\\main\\resources\\TestData\\TestData.xlsx";			
//	
//	private static FileInputStream fis;
//	private static XSSFWorkbook workbook;
//	private static XSSFSheet sheet;
//	private static Row row;
//	
//	public static void loadExcel()
//	{
//		try{
//		File file=new File(excelFileLocation);
//		fis=new FileInputStream(file);
//		workbook = new XSSFWorkbook(fis);
//		sheet = workbook.getSheet("Sheet1");
//		fis.close();
//		}catch(Exception e)
//		{
//			System.out.println("Error in consturctor codes");
//		}
//	}
//	
//	
//	/*
//	 * This methods reads all values from excel file 
//	 * like excel has 10 rows then will read all 10 rows
//	 */
//	public static Map<String,ArrayList<String>> getDataFromExcel()
//	{
//		loadExcel();
//		Map<String,ArrayList<String>> superMap=new HashMap<String, ArrayList<String>>();
//		DataFormatter dataformatter=new DataFormatter();
//		
//		row = sheet.getRow(0);
//		int colNumber = row.getLastCellNum();
//		for(int i=0;i<colNumber;i++)
//		{
//			row = sheet.getRow(0);
//			 String keyData = dataformatter.formatCellValue(row.getCell(i)).trim();  // fix 1st row as header
//			 
//			 ArrayList<String> list = new ArrayList<String>();
//			 int totalRows = sheet.getLastRowNum() +1;   // total columns or cells in 1 row
//			 for(int j=1;j<totalRows;j++)
//			 {
//				 row = sheet.getRow(j);
//				 String valueData = dataformatter.formatCellValue(row.getCell(i)).trim();
//				 list.add(valueData);
//			 }
//			 superMap.put(keyData, list);
//		}
//		
//		return superMap;
//	}
//}
