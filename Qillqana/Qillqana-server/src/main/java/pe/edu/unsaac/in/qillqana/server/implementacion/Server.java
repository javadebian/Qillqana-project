package pe.edu.unsaac.in.qillqana.server.implementacion;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.logging.Logger;

public class Server {
	
	private static Logger logger=Logger.getLogger(Server.class.getName());
	private int port;
	private ServerSocket ssocket;

	public Server() {
		port = 1025;
	}
	
	public Server(int port){
		this.port=port;
	}

	public void initServer() {
		try {
			logger.info("Starting at "+port);
			ssocket = new ServerSocket(port);
			while (true) {
				ServerThread sthread=new ServerThread(ssocket.accept());
				sthread.start();
			}
		} catch (IOException e) {
			logger.severe(e.getMessage());
		}
	}

	public void initServerBGMode() {

	}
}
