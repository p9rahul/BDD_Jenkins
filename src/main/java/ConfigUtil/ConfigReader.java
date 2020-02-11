package ConfigUtil;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;


public class ConfigReader {

	FileInputStream file;
	Properties property;
	
	public ConfigReader()
	{
		String configPath=System.getProperty("user.dir")+"\\src\\main\\resources\\configfile\\config.properties";
		try {
			file = new FileInputStream(new File(configPath));
			property=new Properties();
			property.load(file);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public String getUrl()
	{
		return property.getProperty("url");
	}
	
	public static void main(String[] args) {
		
		ConfigReader reader = new ConfigReader();
		System.out.println(reader.getUrl());
	}
	
}
