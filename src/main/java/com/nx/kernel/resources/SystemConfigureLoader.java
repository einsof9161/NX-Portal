/**
 * 
 */
package com.nx.kernel.resources;



import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.io.Resource;


/**
 * @author edward
 *
 */
@javax.annotation.Resource
public class SystemConfigureLoader implements ApplicationContextAware{
	
	private static Properties prop = new Properties();

	
	private ApplicationContext appContext;
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		// TODO Auto-generated method stub
		this.appContext = applicationContext;
	}
	
	public Properties resource() throws FileNotFoundException, IOException{
		Resource res = appContext.getResource("classpath:nx.properties");
		prop.load(new FileInputStream(res.getFile()));
		return prop;
	}

}
