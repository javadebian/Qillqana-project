package pe.edu.unsaac.in.qillqana.server.impl;

import java.io.BufferedReader;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.logging.Logger;

import pe.edu.unsaac.in.qillqana.common.command.Command;

import com.google.gson.Gson;

public class ServerThread extends Thread {

	private static Logger logger = Logger.getLogger(ServerThread.class
			.getName());

	private PrintWriter out;
	private BufferedReader in;
	private Socket socket;

	public ServerThread(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		initStreams();
		try {
			String line = "";
			Command prototype;
			Gson translator = new Gson();
			boolean _break = false;
			while (!_break && (line = in.readLine()) != null) {
				// TODO Try to move this code another file like Protocol or like this
				// Read the command and the process it
				prototype = translator.fromJson(line, Command.class);
				// Here begins the protocol implementation
				switch (prototype.getName()) {
				// We will to process the control commands here
				case "message":
					logger.info("Message received, it says:"
							+ prototype.getParameter("body"));
					break;
				case "enable":
					// Here we can enable to a student to write in the
					// whiteboard
					switch (prototype.getParameter("feature").toString()) {
					case "talk":
						break;
					case "write":
						break;
					}
					break;
				case "disable":
					// Here we can disable to a student to write in the
					// whiteboard
					switch (prototype.getParameter("feature").toString()) {
					case "talk":
						break;
					case "write":
						break;
					}
					break;
				case "exit":
					logger.info("EXIT command was received");
					// TODO notify to the system that this session is killed
					_break = true;
					break;
				default:
					// Here we will to resend other commands types to the
					// clients connected
					break;
				}
			}
			closeStreams();
		} catch (EOFException e) {
			logger.severe("The connection with client fails");
			logger.severe(e.getLocalizedMessage());
			closeStreams();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void closeStreams() {
		try {
			logger.info("Killing streams and connection");
			in.close();
			out.close();
			socket.close();
			join();
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}

	}

	private void initStreams() {
		try {
			out = new PrintWriter(socket.getOutputStream(), true);
			in = new BufferedReader(new InputStreamReader(
					socket.getInputStream()));
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
