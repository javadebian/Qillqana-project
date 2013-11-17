package pe.edu.unsaac.in.qillqana.server.mediator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import org.apache.log4j.Logger;

import pe.edu.unsaac.in.qillqana.common.command.Command;
import pe.edu.unsaac.in.qillqana.common.gson.GsonUtils;
import pe.edu.unsaac.in.qillqana.common.mediator.Mediator;
import pe.edu.unsaac.in.qillqana.common.mediator.Session;

public class LessonSession extends Thread implements Session {
	public static final Logger logger=Logger.getLogger(LessonSession.class.getName());
	
	private int idSession;
	private Mediator mediator;
	private Socket socket;
	private BufferedReader in;
	private PrintWriter out;
	
	public LessonSession(int idSession,Mediator mediator,Socket socket) {
		this.idSession=idSession;
		this.mediator=mediator;
		this.socket=socket;
	}

	public String getIdSession() {
		return idSession+"";
	}

	public void setIdSession(int idSession) {
		this.idSession = idSession;
	}

	public Mediator getMediator() {
		return mediator;
	}

	public void setMediator(Mediator mediator) {
		this.mediator = mediator;
	}

	public Socket getSocket() {
		return socket;
	}

	public void setSocket(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		try {
			initStreams();
			String line="";
			Command command=null;
			boolean _break=false;
			while ((line=in.readLine())!=null && !_break) {
				logger.info("Message received: "+line);
				command=GsonUtils.toCommand(line);
				_break=processCommad(command);
			}
			// TODO Revisar esta parte para saber si sale al cortar la conexion o enviar un mensaje de salida
			in.close();
			out.close();
			socket.close();
			mediator.removeSession(this);
			logger.info("This session was closed, streams and socket already closed");
			join();
		} catch (IOException e) {
			logger.error(e.getLocalizedMessage());
		} catch (InterruptedException e) {
			logger.error(e.getLocalizedMessage());
		}
	}
	@Override
	public void receiveCommand(Command command) {
		String str=GsonUtils.toJson(command);
		out.println(str);
	}

	@Override
	public void sendCommand(Command command) {
		mediator.sendMessage(command, this);
	}

	@Override
	public boolean processCommad(Command command) {
		boolean _break=false;
		switch (command.getName()) {
		case "exit": // Process "EXIT" Command
			_break=true;
			break;
		default:
			sendCommand(command);
			break;
		}
		return _break;
	}
	
	private void initStreams(){
		try {
			in=new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out=new PrintWriter(socket.getOutputStream(),true);
		} catch (IOException e) {
			logger.error(e.getLocalizedMessage());
		}
	}

}
