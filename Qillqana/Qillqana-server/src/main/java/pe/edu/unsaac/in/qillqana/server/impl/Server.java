package pe.edu.unsaac.in.qillqana.server.impl;

import java.io.IOException;
import java.net.ServerSocket;

import org.apache.log4j.Logger;

import pe.edu.unsaac.in.qillqana.common.mediator.Mediator;
import pe.edu.unsaac.in.qillqana.common.mediator.Session;
import pe.edu.unsaac.in.qillqana.server.mediator.LessonMediator;
import pe.edu.unsaac.in.qillqana.server.mediator.LessonSession;

public class Server {

    private static Logger logger = Logger.getLogger(Server.class.getName());
    private int port;
    private ServerSocket ssocket;

    public Server(int port) {
        this.port = port;
    }

    public void initServer() {
        try {
            ssocket = new ServerSocket(port);
            logger.info("Server started");
            Mediator mediator = new LessonMediator();
            int i = 1;
            while (true) {
            	// TODO Implements additional process commands to create a new mediator or put another existing mediator
            	Session session = new LessonSession(i, mediator, ssocket.accept());
                mediator.addSession(session);
                session.start();
                i++;
            }
        } catch (IOException e) {
            logger.error(e.getMessage());
        }
    }

    public void initServerBGMode() {
    	new Runnable() {
			
			@Override
			public void run() {
				initServer();				
			}
		};
    }
}
