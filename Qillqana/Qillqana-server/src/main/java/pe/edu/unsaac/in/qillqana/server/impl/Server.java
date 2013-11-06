package pe.edu.unsaac.in.qillqana.server.impl;

import java.io.IOException;
import java.net.ServerSocket;

import org.apache.log4j.Logger;
import pe.edu.unsaac.in.qillqana.server.mediator02.LessonMediator;
import pe.edu.unsaac.in.qillqana.server.mediator02.sessions.Session;

public class Server {

    private static Logger logger = Logger.getLogger(Server.class.getName());
    private int port;
    private ServerSocket ssocket;

    public Server() {
        port = 1025;
    }

    public Server(int port) {
        this.port = port;
    }

    public void initServer() {
        try {
            ssocket = new ServerSocket(port);
            logger.info("Server started");
            LessonMediator mediator=new LessonMediator();
            int i=1;
            while (true) {
                 Session session=new Session(i, mediator, ssocket.accept());
                 mediator.addSession(session);
                 session.start();
                 i++;
//                ServerThread sthread = new ServerThread(ssocket.accept());
//                sthread.start();
            }
        } catch (IOException e) {
            logger.error(e.getMessage());
        }
    }

    public void initServerBGMode() {

    }
}
