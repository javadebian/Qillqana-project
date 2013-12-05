package pe.edu.unsaac.in.qillqana.server.ioc;

import pe.edu.unsaac.in.qillqana.server.dao.UserDao;
import pe.edu.unsaac.in.qillqana.server.dao.dbfactory.ConnectionFactory;
import pe.edu.unsaac.in.qillqana.server.dao.dbfactory.MariaDBConnectionFactory;
import pe.edu.unsaac.in.qillqana.server.dao.impl.mariadb.UserDaoMariaDb;
import pe.edu.unsaac.in.qillqana.server.singleton.ConfigSingleton;

public class IoC {
	private static ConnectionFactory connection = null;
	private static UserDao userDao = null;

	private IoC() {
	}

	public static ConnectionFactory getConnectionFactory() {
		if (connection == null) {
			String driver = ConfigSingleton.getInstance().getProperty(
					"database.driver");
			if (driver.contains("mysql"))
				return new MariaDBConnectionFactory();
			else if (driver.contains("maria")) {
				return new MariaDBConnectionFactory();
			} else
				return null;
		} else {
			return connection;
		}
	}

	public static UserDao getUserDao() {
		if (userDao == null) {
			if (getConnectionFactory() instanceof MariaDBConnectionFactory)
				return new UserDaoMariaDb(getConnectionFactory()
						.getConnection());
			else
				return null;

		}else{
			return userDao;
		}
	}
}
