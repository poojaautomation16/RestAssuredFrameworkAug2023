package com.qa.gorest.configuration;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationManager{
	
	private Properties prop;
	private FileInputStream ip;

	public Properties initprop() {
		prop = new Properties();
		try {
			ip = new FileInputStream("./src/test/resources/config/config.properties");
		    prop.load(ip);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return prop;
	}

}
