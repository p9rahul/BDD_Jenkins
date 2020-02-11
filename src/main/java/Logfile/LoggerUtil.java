package Logfile;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;


public class LoggerUtil {

	private static boolean root=false;
	
	public static Logger getLogger(Class cls){
		if(root){
			return Logger.getLogger(cls);
		}
		String basePath = System.getProperty("user.dir")+"\\src\\main\\resources\\configfile\\log4j.properties";
		PropertyConfigurator.configure(basePath);
		root = true;
		return Logger.getLogger(cls);
	}
	
	public static void main(String[] args) {
		Logger log = LoggerUtil.getLogger(LoggerUtil.class);
		log.info("logger is configured");
		log.info("logger is configured");
		log.info("logger is configured");
	}
}
