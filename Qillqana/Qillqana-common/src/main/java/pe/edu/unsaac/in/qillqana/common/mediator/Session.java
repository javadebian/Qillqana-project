package pe.edu.unsaac.in.qillqana.common.mediator;

import pe.edu.unsaac.in.qillqana.common.command.Command;

public interface Session extends Runnable{
	public void receiveCommand(Command command);
	public void sendCommand(Command command);
	public boolean processCommad(Command command);
	public String getIdSession();
	public void run();
	public void start();
}
