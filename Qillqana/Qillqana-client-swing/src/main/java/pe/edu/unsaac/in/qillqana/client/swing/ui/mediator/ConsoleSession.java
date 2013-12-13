package pe.edu.unsaac.in.qillqana.client.swing.ui.mediator;

import org.apache.log4j.Logger;

import pe.edu.unsaac.in.qillqana.client.swing.locale.Messages;
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
		logger.info(Messages.getString("command.received")+GsonUtils.toJson(command)); //$NON-NLS-1$
	}

	@Override
	public void sendCommand(Command command) {
		logger.info(Messages.getString("command.send.mediator")); //$NON-NLS-1$
		mediator.sendMessage(command, this);
	}

	@Override
	public boolean processCommad(Command command) {
		receiveCommand(command);
		return false;
	}

	@Override
	public String getIdSession() {
		return null;
	}

	@Override
	public void run() {}

	@Override
	public void start() {}

}
