package com.API.xmlPack;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.lang3.StringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;
import ExcelUtility.ExcelUtil;
import ExcelUtility.ExecutionContext;

public class XmlParametrization {
	ExecutionContext context = new ExecutionContext();

	public void doParametrization(String sheetName, String testCaseName) {

		try {

			String xmlFilePath = System.getProperty("user.dir")
					+ "\\src\\main\\resources\\WebServicesFolder\\template_Property.xml";
			FileReader path = new FileReader(new File(xmlFilePath));

			BufferedReader br = new BufferedReader(path);

			String line1 = "";
			String line = "";
			while ((line = br.readLine()) != null) {
				line1 = line1 + line;
			}
			System.out.println(line1);

			ExcelUtil excelData = new ExcelUtil();
			excelData.loadExcel(sheetName);
			this.context.testdata = excelData.readData1("TestCase", testCaseName);
			HashMap<String, String> token = this.context.testdata;

			String patternString = "\\$\\{(" + StringUtils.join(token.keySet(), "|") + ")\\}";
			Pattern p = Pattern.compile(patternString);
			Matcher m = p.matcher(line1);

			StringBuffer request = new StringBuffer();
			while (m.find()) {
				m.appendReplacement(request, token.get(m.group(1)));
			}
			m.appendTail(request);
			System.out.println(request);
//			String s1 = request.toString();
			this.context.apiJsonRequestTemplate=request.toString(); // save remplate 

			// Write it into a file
			String xmlFilePathWrite = System.getProperty("user.dir")
					+ "\\src\\main\\resources\\WebServicesFolder\\converted.xml";
			File file = new File(xmlFilePathWrite);
			file.createNewFile();

			BufferedWriter bw = new BufferedWriter(new FileWriter(file));
			bw.write(context.apiJsonRequestTemplate);
			bw.flush();
			bw.close();
		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}

	// Only calling
	@Test
	public void parametTC() {

		doParametrization("MobileProduct", "TC1");
		doParametrization("MobileProduct", "TC2");
		doParametrization("MobileProduct", "TC3");
	}
}
