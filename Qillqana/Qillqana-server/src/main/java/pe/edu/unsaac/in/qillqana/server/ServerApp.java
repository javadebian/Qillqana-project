package pe.edu.unsaac.in.qillqana.server;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import pe.edu.unsaac.in.qillqana.server.impl.Server;
import pe.edu.unsaac.in.qillqana.server.singleton.ConfigSingleton;

public class ServerApp {

	private static final Logger logger = Logger.getLogger(ServerApp.class
			.getName());

	public static void main(String[] args) throws IOException,
			ClassNotFoundException, SQLException {
		PropertyConfigurator.configure("log4j.properties");
		// Read configuration parameter from the file
		logger.info("Reading configuration parameters");
		Properties conf = ConfigSingleton.getInstance();
		int port = Integer.parseInt(conf.getProperty("server.port"));

		logger.info("Configuration parameters readed");

		// Starting the server
		logger.info("Starting the server at port: " + port);
		Server server = new Server(port);
		server.initServer();
	}
}
