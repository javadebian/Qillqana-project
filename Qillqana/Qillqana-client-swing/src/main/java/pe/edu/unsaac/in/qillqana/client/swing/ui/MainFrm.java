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
import pe.edu.unsaac.in.qillqana.client.swing.ui.mediator.suscriptors.ChatSuscriptor;
import pe.edu.unsaac.in.qillqana.client.swing.ui.mediator.Mediator;

public class MainFrm extends JFrame implements ActionListener{
    private JPanel pnlTitle;
    private JPanel pnlContent;
    private JPanel pnlButtons;
    
    private JTextArea txtOut;
    private JTextField txtIn;
    
    private JButton btnSend;
    private JButton btnClose;
    
    private JLabel lblTitle;
    
    private ChatSuscriptor chatSuscriptor;

    public MainFrm(Mediator mediator){
        initGUI();
        initMediator(mediator);
    }
    private void initGUI(){
        getContentPane().setLayout(new BorderLayout());
        
        txtOut=new JTextArea();
        txtIn=new JTextField();
        
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
                chatSuscriptor.sendMessage(txtIn.getText());
                txtOut.append(txtIn.getText());
                txtIn.setText("");
            }
        }else if (ae.getActionCommand().equals("CLOSE")){
            System.exit(0);
        }
    }

    private void initMediator(Mediator mediator) {
        chatSuscriptor=new ChatSuscriptor(mediator);
        chatSuscriptor.setTxtIn(txtIn);
        chatSuscriptor.setTxtOut(txtOut);
        mediator.addSuscriptor(chatSuscriptor);
    }   
}