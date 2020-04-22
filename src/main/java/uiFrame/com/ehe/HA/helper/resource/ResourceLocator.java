package uiFrame.com.ehe.HA.helper.resource;

public class ResourceLocator {
	
	public static String getResourcePath(String path) {
		String basePath = System.getProperty("user.dir");
		return basePath + path; 
	}
	
	public static void main(String[] args) {
		String log4j = ResourceLocator.getResourcePath("/src/main/resources/configfile/log4j.properties");
		System.out.println(log4j);
	}

}
