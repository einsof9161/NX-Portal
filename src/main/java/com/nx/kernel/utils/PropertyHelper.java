package com.nx.kernel.utils;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.Iterator;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Properties;

@Component
public class PropertyHelper  {
	
	
	private static String propertiesPath;
	/**
	 * 依照Key值取得檔案的屬性
	 * @param key
	 * @return
	 */
	public static String findPropertiesKey(String key) {
		try {
			Properties prop = getProperties();
			return prop.getProperty(key);
		} catch (Exception e) {
			return "";
		}
		
	}

	public static void main(String[] args) {
		Properties prop = new Properties();
		InputStream in = PropertyHelper.class.getResourceAsStream("/"+propertiesPath);
		try {
			prop.load(in);
			Iterator<Entry<Object, Object>> itr = prop.entrySet().iterator();
			while (itr.hasNext()) {
				Entry<Object, Object> e = (Entry<Object, Object>) itr.next();
				System.err.println((e.getKey().toString() + "" + e.getValue()
						.toString()));
			}
		} catch (Exception e) {
			
		}
	}

	/**
	 * 取得properties物件
	 * @return
	 */
	public static Properties getProperties(){
		Properties prop = new Properties();
		System.out.println(propertiesPath);
		String savePath = PropertyHelper.class.getResource("/"+propertiesPath).getPath();
		try {
			InputStream in =new BufferedInputStream(new FileInputStream(savePath));  
			prop.load(in);
		} catch (Exception e) {
			return null;
		}
		return prop;
	}
	
	/**
	 * 寫入properties物件
	 * @return
	 */
	public static void writeProperties(String key, String value) {
		try {
			Properties prop = getProperties();
			prop.setProperty(key, value);
			String path = PropertyHelper.class.getResource("/"+propertiesPath).getPath();
			FileOutputStream outputFile = new FileOutputStream(path);
			prop.store(outputFile, "modify");
			outputFile.close();
			outputFile.flush();
		} catch (Exception e) {
		}
	}
	
	
	public PropertyHelper(){
		
		System.out.println("Inject");
	}
}
