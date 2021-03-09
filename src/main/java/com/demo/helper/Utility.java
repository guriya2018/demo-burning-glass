package com.demo.helper;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;

public class Utility {

	public static String getAbsolutePath() {
		return System.getProperty("user.dir");
	}
	
	public static String getFilePath(String filePath) {
		return getAbsolutePath() + File.separator + filePath;
	}
	
	public static void updateKeyValuesInPropertyFile(String key, String value) {
		PropertiesConfiguration conf;
		try{
			conf = new PropertiesConfiguration("config.properties");
			conf.setProperty(key,value);
			conf.save();
			
		}catch(ConfigurationException e) {
			e.printStackTrace();
		}
	
	}

	public static void uploadFile(String fileLocation) {
		try {
			// setting clipBoard with file location
			setClipboardData(fileLocation);
			// native key strokes for CTRL, V and ENTER Keys
			Robot robot =new Robot();
			
			robot.keyPress(KeyEvent.VK_CONTROL);
		//	robot.keyPress(KeyEvent.VK_V);
			robot.keyPress(KeyEvent.VK_V);
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyPress(KeyEvent.VK_ENTER);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void setClipboardData(String string ) {
		StringSelection stringSelection = new StringSelection(string);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
		
	}
	
	public static void main(String[] args) {
		System.out.println(getAbsolutePath());
	}
	
	
}

