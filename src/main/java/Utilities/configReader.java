package Utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class configReader {
	
private static Properties properties = new Properties();
	
	static {
		try 
		{
			FileInputStream fis = new FileInputStream("src\\main\\resources\\Config.properties");
			properties.load(fis);
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
	public static String getProperty(String key)
	{
		return properties.getProperty(key);
	}
	
	public static int getGlobalWaitTime()
	{
		return Integer.parseInt(properties.getProperty("globalWaitTime"));
	}
	
	public static boolean isheadless()
	{
		return Boolean.parseBoolean(properties.getProperty("headless"));
	}

}
