package uiFrame.com.ehe.HA.helper.logger;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import uiFrame.com.ehe.HA.helper.resource.ResourceLocator;

public class LoggerHelper {
	
	private static boolean root = false;
	
	public static Logger getLogger(Class cls) {
		if (root) {
			return Logger.getLogger(cls);
		}
		
		PropertyConfigurator.configure(ResourceLocator.getResourcePath("/src/main/resources/configfile/log4j.properties"));
		root = true;
		return Logger.getLogger(cls);
	}
	
	public static void main(String[] args) {
		
	Logger log = LoggerHelper.getLogger(LoggerHelper.class);
	log.info("logger is set up");
	log.info("logger is working");
	log.info("logger is perfect");
	
	
	}

}
