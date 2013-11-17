package pe.edu.unsaac.in.qillqana.client.swing.ui.mediator;

import javax.swing.JTextArea;
import javax.swing.JTextField;

import pe.edu.unsaac.in.qillqana.common.command.Command;
import pe.edu.unsaac.in.qillqana.common.mediator.Mediator;
import pe.edu.unsaac.in.qillqana.common.mediator.Session;

public class UIChatSession extends Thread implements Session{
	private Mediator mediator;
	private JTextField txtIn;
	private JTextArea txtOut;

	public UIChatSession(Mediator mediator) {
		this.mediator=mediator;
	}

	@Override
	public void receiveCommand(Command command) {
		txtOut.append(command.getParameter("value").toString()+"\n");
	}

	@Override
	public void sendCommand(Command command) {
		mediator.sendMessage(command, this);
	}

	@Override
	public boolean processCommad(Command command) {
		return false;
	}

	@Override
	public String getIdSession() {
		return null;
	}

	@Override
	public void run() {
	}

	@Override
	public void start() {
	}

	public Mediator getMediator() {
		return mediator;
	}

	public void setMediator(Mediator mediator) {
		this.mediator = mediator;
	}

	public JTextField getTxtIn() {
		return txtIn;
	}

	public void setTxtIn(JTextField txtIn) {
		this.txtIn = txtIn;
	}

	public JTextArea getTxtOut() {
		return txtOut;
	}

	public void setTxtOut(JTextArea txtOut) {
		this.txtOut = txtOut;
	}

}
