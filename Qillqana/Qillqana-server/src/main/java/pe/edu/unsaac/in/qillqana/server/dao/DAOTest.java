package pe.edu.unsaac.in.qillqana.server.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import pe.edu.unsaac.in.qillqana.common.model.User;
import pe.edu.unsaac.in.qillqana.server.dao.impl.mariadb.UserDaoMariaDb;

public class DAOTest {
	public static final Logger logger = Logger.getLogger(DAOTest.class
			.getName());

	public static void main(String[] args) throws ClassNotFoundException,
			SQLException, IOException {
		PropertyConfigurator.configure("log4j.properties");
		Properties conf = new Properties();
		FileInputStream fis = new FileInputStream(
				"conf/configuration.properties");
		conf.load(fis);
		
		logger.info("Loading MySQL Driver...");
		Class.forName(conf.getProperty("database.driver"));
		logger.info("Driver loaded");
		logger.info("Opening Connection....");
		Connection connection = DriverManager.getConnection(
				conf.getProperty("database.url"), conf.getProperty("database.user"), conf.getProperty("database.pass"));
		logger.info("Connected");

		UserDao userDao = new UserDaoMariaDb(connection);
		User user = new User();
		user.setId(0);
		user.setUser("alexove");
		user.setPassword("alexove");
		user.setNames("Alex Irmel");
		user.setSurnames("Oviedo Solis");
		user.setEmail("alexove@fedoraproject.org");
		userDao.save(user);
		User _user = userDao.findByUserName("alexove");
		logger.info("Recuperado de la DB:\n" + "id: " + _user.getId() + "\n"
				+ "user: " + _user.getUser());
	}
}
