package pe.edu.unsaac.in.qillqana.server;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import pe.edu.unsaac.in.qillqana.server.impl.Server;

public class ServerApp {

    private static final Logger logger = Logger.getLogger(ServerApp.class.getName());

    //TODO Remove this unused when the connection files will moved to Singleton or Pool structure
    @SuppressWarnings("unused")
	public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {
        PropertyConfigurator.configure("log4j.properties");
        // Read configuration parameter from the file
        logger.info("Reading configuration parameters");
        Properties conf = new Properties();
        FileInputStream fis = new FileInputStream("conf/configuration.properties");
        conf.load(fis);
        int port = Integer.parseInt(conf.getProperty("server.port"));
        logger.info("Configuration parameters readed");
        
        // Configuring database connection
        // TODO Move this code to Singleton or Pool Instance
        Class.forName(conf.getProperty("database.driver"));
        Connection connection = DriverManager.getConnection(
				conf.getProperty("database.url"), conf.getProperty("database.user"), conf.getProperty("database.pass"));
        
        // Starting the server
        logger.info("Starting the server at port: " + port);
        Server server = new Server(port);
        server.initServer();
    }
}
