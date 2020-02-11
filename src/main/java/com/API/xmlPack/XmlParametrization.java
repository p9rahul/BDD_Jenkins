package com.API.xmlPack;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;

import ExcelUtility.ExcelReader2;


public class XmlParametrization {

	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException {
		
		String xmlFilePath = System.getProperty("user.dir") +"\\src\\main\\resources\\WebServicesFolder\\template_Property.xml";
		FileReader path=new FileReader(new File(xmlFilePath));
		
		BufferedReader br=new BufferedReader(path);
		
		String line1="";
		String line="";
		while((line=br.readLine())!=null)
		{
			line1=line1+line;
		}
		System.out.println(line1);
		
		Map<String, ArrayList<String>> tokens = ExcelReader2.getDataFromExcel();

		Map<String,String> token = new HashMap<String, String>();
		
		int arraylistSize =0;
		for(Map.Entry<String, ArrayList<String>> map1 : tokens.entrySet() )
		{
			token.put(map1.getKey(), map1.getValue().get(0));
		}
				
		String patternString="\\$\\{("+StringUtils.join(tokens.keySet(),"|")+")\\}";
		Pattern p=Pattern.compile(patternString);
		Matcher m=p.matcher(line1);
		
		StringBuffer request=new StringBuffer();
		while(m.find())
		{
			m.appendReplacement(request, token.get(m.group(1)));
		}
		m.appendTail(request);
		System.out.println(request);
		String s1=request.toString();
		
		
		//Write it into a file
		String xmlFilePathWrite = System.getProperty("user.dir") +"\\src\\main\\resources\\WebServicesFolder\\converted.xml";
		File file = new File(xmlFilePathWrite);
		file.createNewFile();

		BufferedWriter bw=new BufferedWriter(new FileWriter(file));
		bw.write(s1);
		bw.flush();
		bw.close();
		
//		FileOutputStream fos=new FileOutputStream(file);
//		byte[] contentInBytes = request.getBytes();
	}

}

//StringUtils
