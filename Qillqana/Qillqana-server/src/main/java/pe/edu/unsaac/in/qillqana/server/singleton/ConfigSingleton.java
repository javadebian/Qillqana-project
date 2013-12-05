package pe.edu.unsaac.in.qillqana.server.singleton;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;

public class ConfigSingleton {
	public static final Logger logger = Logger.getLogger(ConfigSingleton.class
			.getName());
	private static Properties properties = null;

	private ConfigSingleton() {
	}

	public static Properties getInstance() {
		if (properties == null) {
			try {
				properties = new Properties();
				FileInputStream fis = new FileInputStream(
						"conf/configuration.properties");
				properties.load(fis);
				return properties;
			} catch (FileNotFoundException e) {
				logger.error(e.getLocalizedMessage());
				return null;
			} catch (IOException e) {
				logger.error(e.getLocalizedMessage());
				return null;
			}
		}else{
			return properties;
		}
	}
}
