package pe.edu.unsaac.edu.in.qillqana.server;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import pe.edu.unsaac.edu.in.qillqana.server.implementacion.Server;

public class ServerApp {
	public static void main(String[] args) throws IOException {
		// Leer configuraciones desde el archivo de configuracion
		Properties conf=new Properties();
		FileInputStream fis=new FileInputStream("conf/configuration.properties");
		conf.load(fis);
		int port=Integer.parseInt(conf.getProperty("server.port"));
		
		Server server=new Server(port);
		server.initServer();
	}
}
