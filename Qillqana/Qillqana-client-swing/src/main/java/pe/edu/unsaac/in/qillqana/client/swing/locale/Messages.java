package pe.edu.unsaac.in.qillqana.client.swing.locale;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.MissingResourceException;
import java.util.Properties;

import pe.edu.unsaac.in.qillqana.client.swing.configurator.ConfSingleton;

public class Messages {
	private static Properties properties=null;

	private Messages() {
	}

	public static String getString(String key) {
		try {
			if(properties==null){
				properties=new Properties();
				String file_name="locale/messages_"+ConfSingleton.getProperty("locale.language")+"_"+ConfSingleton.getProperty("locale.country")+".properties";
				System.out.println(file_name);
				FileInputStream fis=new FileInputStream(file_name);
				properties.load(fis);
				fis.close();
			}
			return properties.getProperty(key);
		} catch (MissingResourceException | IOException e) {
			return '!' + key + '!';
		}
	}
}
