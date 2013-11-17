package pe.edu.unsaac.in.qillqana.client.swing.ui.mediator;

import org.apache.log4j.Logger;

import pe.edu.unsaac.in.qillqana.common.command.Command;
import pe.edu.unsaac.in.qillqana.common.gson.GsonUtils;
import pe.edu.unsaac.in.qillqana.common.mediator.Mediator;
import pe.edu.unsaac.in.qillqana.common.mediator.Session;

public class ConsoleSession implements Session {
	public static final Logger logger=Logger.getLogger(ConsoleSession.class.getName());
	private Mediator mediator;
	public ConsoleSession(Mediator mediator) {
		this.mediator=mediator;
	}
	@Override
	public void receiveCommand(Command command) {
		logger.info("Command received: "+GsonUtils.toJson(command));
	}

	@Override
	public void sendCommand(Command command) {
		logger.info("Sending the command to mediator");
		mediator.sendMessage(command, this);
	}

	@Override
	public boolean processCommad(Command command) {
		receiveCommand(command);
		return false;
	}

	@Override
	public String getIdSession() {
		// TODO Apéndice de método generado automáticamente
		return null;
	}

	@Override
	public void run() {
		// TODO Apéndice de método generado automáticamente

	}

	@Override
	public void start() {
		// TODO Apéndice de método generado automáticamente

	}

}
