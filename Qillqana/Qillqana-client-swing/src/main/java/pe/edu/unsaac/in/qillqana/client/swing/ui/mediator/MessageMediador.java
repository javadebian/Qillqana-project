package pe.edu.unsaac.in.qillqana.client.swing.ui.mediator;

import java.util.ArrayList;
import java.util.List;

import pe.edu.unsaac.in.qillqana.common.command.Command;
import pe.edu.unsaac.in.qillqana.common.mediator.Mediator;
import pe.edu.unsaac.in.qillqana.common.mediator.Session;

public class MessageMediador implements Mediator {
	private List<Session> sessions;
	public MessageMediador() {
		sessions=new ArrayList<>();
	}
	
	@Override
	public void sendMessage(Command command, Session originator) {
		for (Session session : sessions) {
			if(session!=originator){
				session.receiveCommand(command);
			}
		}
	}

	@Override
	public void addSession(Session session) {
		sessions.add(session);
	}

	@Override
	public void removeSession(Session session) {
		sessions.remove(session);
	}

}
