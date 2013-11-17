package pe.edu.unsaac.in.qillqana.common.mediator;

import pe.edu.unsaac.in.qillqana.common.command.Command;

public interface Mediator {
	public void sendMessage(Command command,Session originator);
	public void addSession(Session session);
	public void removeSession(Session session);
}
