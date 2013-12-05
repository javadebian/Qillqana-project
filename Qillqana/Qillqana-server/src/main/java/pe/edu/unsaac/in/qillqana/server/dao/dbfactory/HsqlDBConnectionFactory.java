package pe.edu.unsaac.in.qillqana.server.dao.dbfactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.log4j.Logger;

import pe.edu.unsaac.in.qillqana.server.singleton.ConfigSingleton;

public class HsqlDBConnectionFactory implements ConnectionFactory{
	public static final Logger logger = Logger
			.getLogger(HsqlDBConnectionFactory.class.getName());

	private static Connection connection = null;

	public HsqlDBConnectionFactory() {}

	@Override
	public Connection getConnection() {
		if (connection == null) {
			Properties conf = ConfigSingleton.getInstance();
			try {
				Class.forName(conf.getProperty("database.driver"));
				connection = DriverManager.getConnection(
						conf.getProperty("database.url"),
						conf.getProperty("database.user"),
						conf.getProperty("database.pass"));
				return connection;
			} catch (ClassNotFoundException e) {
				logger.error(e.getLocalizedMessage());
				return null;
			} catch (SQLException e) {
				logger.error(e.getLocalizedMessage());
				return null;
			}

		} else {
			return connection;
		}
	}

}
