package pe.edu.unsaac.in.qillqana.server.impl;

import java.io.BufferedReader;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import org.apache.log4j.Logger;

import pe.edu.unsaac.in.qillqana.common.command.Command;
import pe.edu.unsaac.in.qillqana.common.command.Constants;
import pe.edu.unsaac.in.qillqana.common.command.MessageCommand;
import pe.edu.unsaac.in.qillqana.common.gson.GsonUtils;
import pe.edu.unsaac.in.qillqana.common.mediator.Mediator;
import pe.edu.unsaac.in.qillqana.common.mediator.Session;
import pe.edu.unsaac.in.qillqana.common.model.User;
import pe.edu.unsaac.in.qillqana.server.dao.UserDao;
import pe.edu.unsaac.in.qillqana.server.ioc.IoC;
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
				processSocket(i, mediator, ssocket.accept());
				i++;
			}
		} catch (IOException e) {
			logger.error(e.getMessage());
		}
	}

	private void processSocket(int i, Mediator mediator, Socket socket) {
		// TODO Implements additional process commands to create a new mediator
		// or put another existing mediator
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(
					socket.getInputStream()));
			PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

			// Waiting for a Login command and process it
			String line = "";
			boolean _break = false;

			while (!_break) {
				line = in.readLine();
				Command command = GsonUtils.toCommand(line);
				switch (command.getName()) {
				case Constants.LOGIN:
					User user = processLoginCommand(command);
					if (user != null) {
						
						logger.info("Login success for "+command.getParameter("user").toString());

						MessageCommand msg = new MessageCommand();
						msg.setBody("Success");
						out.println(GsonUtils.toJson(msg));

						switch (user.getType()) {
						case Constants.TEACHER:
							logger.info("the user "+user.getUser()+" is a teacher, creating a mediator for it");
							Session session = new LessonSession(i, mediator,
									socket);
							mediator.addSession(session);
							session.start();

							_break = true;
							break;
						case Constants.STUDENT:
							// TODO Send the sessions list
							logger.info("There are a student");
							break;
						case Constants.USER:
							logger.info("There are a user");
							break;
						case Constants.ADMIN:
							logger.info("There are a admin");
							break;
						default:
							break;
						}
						_break = true;
					} else {
						// TODO send fail message
					}
					break;
				case Constants.EXIT:
					_break = true;
					break;
				default:// Estado de error
					break;
				}
			}
		} catch (EOFException e) {
			logger.error(e);
		} catch (IOException e) {
			logger.error(e);
		}
	}

	private User processLoginCommand(Command command) {
		UserDao user_dao = IoC.getUserDao();
		User user = user_dao.findByUserName(command.getParameter("user")
				.toString());
		if (user != null) {
			if (user.getPassword().trim()
					.equals(command.getParameter("password").toString().trim())) {
				return user;
			} else {
				return null;
			}
		} else {
			return null;
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
