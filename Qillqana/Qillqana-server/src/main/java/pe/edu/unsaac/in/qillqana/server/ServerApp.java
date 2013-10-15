package pe.edu.unsaac.in.qillqana.server;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Logger;

import pe.edu.unsaac.in.qillqana.server.impl.Server;

public class ServerApp {
	private static Logger logger=Logger.getLogger(ServerApp.class.getName());
	public static void main(String[] args) throws IOException {
		// Read configuration parameter from the file
		logger.info("Reading configuration parameters");
		Properties conf=new Properties();
		FileInputStream fis=new FileInputStream("conf/configuration.properties");
		conf.load(fis);
		int port=Integer.parseInt(conf.getProperty("server.port"));
		logger.info("Configuration parameters readed");
		// Starting the server
		logger.info("Starting the server at port: "+port);
		Server server=new Server(port);
		server.initServer();
	}
}
