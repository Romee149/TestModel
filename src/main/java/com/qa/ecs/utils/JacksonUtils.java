package com.qa.ecs.utils;

import java.io.IOException;
import java.io.InputStream;

import org.testng.Assert;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JacksonUtils {
	public static <T> T deserializeJson(String fileName, Class<T> T) {		
		fileName = "\\testdata\\" + fileName;
		try {
		InputStream is = JacksonUtils.class.getClassLoader().getResourceAsStream(fileName);
		ObjectMapper objMap = new ObjectMapper();
		return objMap.readValue(is, T);
		}catch(Exception e) {
			e.getStackTrace();
		}
		return null;
	}
}