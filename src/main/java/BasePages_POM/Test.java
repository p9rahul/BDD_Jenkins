package BasePages_POM;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Test {

	public static void main(String[] args) throws IOException {
		
		FileReader file = new FileReader("C:\\Users\\Rahul\\eclipse-workspace\\BDD_Jenkins\\src\\main\\resources\\Notes\\Git.txt");
		
		BufferedReader br = new BufferedReader(file);

		int totalLine = 0;
		int lineWiseChar = 0;
		String line;
		while((line = br.readLine())!= null)
		{
			++totalLine;
			lineWiseChar =line.length();
			System.out.println("Char in each line :" +lineWiseChar);
		}
		System.out.println("totalLine line in this file : "+totalLine);
	
		
	}
}
