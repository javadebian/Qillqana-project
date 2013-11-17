package pe.edu.unsaac.in.qillqana.client.swing.ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import pe.edu.unsaac.in.qillqana.client.swing.ui.mediator.UIChatSession;
import pe.edu.unsaac.in.qillqana.common.command.Command;
import pe.edu.unsaac.in.qillqana.common.mediator.Mediator;

public class MainFrm extends JFrame implements ActionListener{
    /**
	 * 
	 */
	private static final long serialVersionUID = -8149721424455090374L;
	private JPanel pnlTitle;
    private JPanel pnlContent;
    private JPanel pnlButtons;
    
    private JTextArea txtOut;
    private JTextField txtIn;
    
    private JButton btnSend;
    private JButton btnClose;
    
    private JLabel lblTitle;
    
    private UIChatSession chatSession;

    public MainFrm(Mediator mediator){
        initGUI();
        initMediator(mediator);
    }
    private void initGUI(){
        getContentPane().setLayout(new BorderLayout());
        
        txtOut=new JTextArea();
        txtOut.setEditable(false);
        txtIn=new JTextField();
        txtIn.requestFocus();
        
        btnSend=new JButton("Send");
        btnSend.addActionListener(this);
        btnSend.setActionCommand("SEND");
        
        btnClose=new JButton("Close");
        btnClose.addActionListener(this);
        btnClose.setActionCommand("CLOSE");
        
        pnlTitle=new JPanel();
        pnlContent=new JPanel();
        pnlButtons=new JPanel();
        
        lblTitle=new JLabel("<html><big>Chat</big></html>");
        
        pnlTitle.add(lblTitle);
        
        pnlContent.setLayout(new BorderLayout(10, 10));
        pnlContent.add(txtOut,BorderLayout.CENTER);
        pnlContent.add(txtIn,BorderLayout.SOUTH);
        
        pnlButtons.add(btnSend);
        pnlButtons.add(btnClose);
        
        getContentPane().add(pnlTitle,BorderLayout.NORTH);
        getContentPane().add(pnlContent,BorderLayout.CENTER);
        getContentPane().add(pnlButtons,BorderLayout.SOUTH);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(200, 300));
        setLocationRelativeTo(null);
        pack();
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getActionCommand().equals("SEND")){
            if(!txtIn.getText().isEmpty()){
            	Command command=new Command();
            	command.setName("message");
            	command.addParameter("value", txtIn.getText());
                chatSession.sendCommand(command);
                txtOut.append(txtIn.getText()+"\n");
                txtIn.setText("");
            }
        }else if (ae.getActionCommand().equals("CLOSE")){
            System.exit(0);
        }
    }

    private void initMediator(Mediator mediator) {
        chatSession=new UIChatSession(mediator);
        chatSession.setTxtIn(txtIn);
        chatSession.setTxtOut(txtOut);
        mediator.addSession(chatSession);
    }   
}