package pe.edu.unsaac.in.qillqana.server.mediator;

import java.io.BufferedReader;
import java.io.PrintWriter;

import org.apache.log4j.Logger;

public class StudentSession extends Session {
	private static final Logger logger = Logger.getLogger(StudentSession.class
			.getName());

	// private Student student;

	public StudentSession(Mediator mediator, BufferedReader in, PrintWriter out) {
		super(mediator, in, out);
	}

	@Override
	public void receive(String message) {
		// TODO Here we can send messages to clients throught sockets
		logger.info("mensaje recibido");
		logger.info(message);
	}

}
