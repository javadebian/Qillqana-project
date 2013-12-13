package pe.edu.unsaac.in.qillqana.client.swing.configurator;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.MissingResourceException;
import java.util.Properties;

public class ConfSingleton {

	private static Properties properties=null;

	private ConfSingleton() {
	}

	public static String getProperty(String key) {
		try {
			if(properties==null){
				properties=new Properties();
				FileInputStream fis=new FileInputStream("conf/configuration.properties");
				properties.load(fis);
				fis.close();
			}
			return properties.getProperty(key);
		} catch (MissingResourceException | IOException e) {
			return '!' + key + '!';
		}
	}
}
