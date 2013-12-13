package pe.edu.unsaac.in.qillqana.client.swing.ui.panels;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import pe.edu.unsaac.in.qillqana.client.swing.locale.Messages;
import pe.edu.unsaac.in.qillqana.client.swing.ui.mediator.UIChatSession;
import pe.edu.unsaac.in.qillqana.common.command.Command;
import pe.edu.unsaac.in.qillqana.common.mediator.Mediator;

public class PnlChat extends JPanel implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JPanel pnlTitle;
	private JPanel pnlContent;
	private JPanel pnlButtons;

	private JTextArea txtOut;
	private JTextField txtIn;

	private JButton btnSend;

	private JLabel lblTitle;

	private UIChatSession chatSession;

	public PnlChat(Mediator mediator) {
		initGUI();
		initMediator(mediator);
	}

	private void initGUI() {
		setLayout(new BorderLayout());
        
        txtOut=new JTextArea();
        txtOut.setEditable(false);
        txtIn=new JTextField();
        txtIn.requestFocus();
        
        btnSend=new JButton(Messages.getString("label.send"));
        btnSend.addActionListener(this);
        btnSend.setActionCommand("SEND");
        
        pnlTitle=new JPanel();
        pnlContent=new JPanel();
        pnlButtons=new JPanel();
        
        lblTitle=new JLabel("<html><big>Chat</big></html>");
        
        pnlTitle.add(lblTitle);
        
        pnlContent.setLayout(new BorderLayout(10, 10));
        pnlContent.add(txtOut,BorderLayout.CENTER);
        pnlContent.add(txtIn,BorderLayout.SOUTH);
        
        pnlButtons.add(btnSend);
        
        add(pnlTitle,BorderLayout.NORTH);
        add(pnlContent,BorderLayout.CENTER);
        add(pnlButtons,BorderLayout.SOUTH);
        
        setPreferredSize(new Dimension(200, 300));
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		if (ae.getActionCommand().equals("SEND")) {
			if (!txtIn.getText().isEmpty()) {
				Command command = new Command();
				command.setName("message");
				command.addParameter("value", txtIn.getText());
				chatSession.sendCommand(command);
				txtOut.append(txtIn.getText() + "\n");
				txtIn.setText("");
			}
		} else if (ae.getActionCommand().equals("CLOSE")) {
			Command command = new Command();
			command.setName("exit");
			chatSession.sendCommand(command);
			System.exit(0);
		}
	}

	private void initMediator(Mediator mediator) {
		chatSession = new UIChatSession(mediator);
		chatSession.setTxtIn(txtIn);
		chatSession.setTxtOut(txtOut);
		mediator.addSession(chatSession);
	}
}
