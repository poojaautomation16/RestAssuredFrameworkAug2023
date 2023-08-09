package com.qa.gorest.utils;

import java.awt.desktop.SystemSleepEvent;

public class StringUtils {
	
	public static String getRandomEmailId() {
		return "api"+System.currentTimeMillis()+"@api.com";
	}

}
