package PdfUtil;

import java.io.File;
import java.io.FileInputStream;

import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.parser.PdfTextExtractor;

public class PDFReader_Example {

	public int decodePdf(byte[] decodeBytes, String textToValidate){
		int count=0;
		System.setProperty("java.util.Arrays.useLegacyMergeSort", "true");
		try{
			PdfReader reader1 = new PdfReader(decodeBytes);
			int pages = reader1.getNumberOfPages();
			while(pages>0)
			{
				String page = PdfTextExtractor.getTextFromPage(reader1, pages);
				String lines[] = page.split("\n");
				for(int i=0;i<lines.length;i++){
					if(lines[i].contains(textToValidate))
					{
						count++;
					}
				}
				pages--;
			}
		}catch(Exception e){
			System.out.println("pdf reader exception -> decodePdf ");
			e.printStackTrace();
		}
		return count;
	}
	
	public byte[] parsePdf(String paths)
	{
		File file = new File(paths);
		byte[] byteArray = new byte[(int) file.length()];
		try{
			FileInputStream fis =new FileInputStream(file);
			fis.read(byteArray);
			fis.close();
		}catch(Exception e){
			System.out.println("pdf reader exception -> parsePdf ");
		}
		return byteArray;
	}
	
	public static void main(String[] args) {
		
		System.out.println("start");
		PDFReader_Example pdf = new PDFReader_Example();
		 byte[] bytearr = pdf.parsePdf("E:\\Rahul\\Workspace\\Selenium070718\\src\\main\\resources\\TestData\\testpdf.pdf");
		int returnValue =pdf.decodePdf(bytearr, "ACCOUNT DETAILS - INR");
		if(returnValue == 1)
			System.out.println("content verified");
		else
			System.out.println("content npt verified");
	}
}
