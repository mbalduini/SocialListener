package org.citydatafusion.cpsma.social_listener.configuration;

import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PropertiesReader {

	private static Logger logger;
	private String propertiesFilePath;
	private Configuration conf = null;


	public PropertiesReader(String propertiesFilePath){
		this.propertiesFilePath = propertiesFilePath;
		logger = LoggerFactory.getLogger(PropertiesReader.class.getName());
		readPropertiesFile();
	}

	private Configuration readPropertiesFile(){

		try {
			conf = new PropertiesConfiguration(propertiesFilePath);
		} catch (ConfigurationException e) {
			logger.error("ConfigurationException Exception", e);
		}

		return conf;

	}

	public Object readProperty(String propertyName){

		Object obj = null;
		obj = conf.getProperty(propertyName);
		return obj;

	}

}
