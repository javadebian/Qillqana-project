package pe.edu.unsaac.in.qillqana.client.swing.ui.mediator.suscriptors;

import com.google.gson.Gson;
import javax.swing.JTextArea;
import javax.swing.text.JTextComponent;
import pe.edu.unsaac.in.qillqana.client.swing.ui.mediator.Mediator;
import pe.edu.unsaac.in.qillqana.common.command.Command;

public class ChatSuscriptor implements Suscriptor{
    public JTextArea txtOut;
    public JTextComponent txtIn;
    public Mediator mediator;

    public ChatSuscriptor(Mediator mediator) {
        this.mediator=mediator;
    }

    public JTextComponent getTxtOut() {
        return txtOut;
    }

    public void setTxtOut(JTextArea txtOut) {
        this.txtOut = txtOut;
    }

    public JTextComponent getTxtIn() {
        return txtIn;
    }

    public void setTxtIn(JTextComponent txtIn) {
        this.txtIn = txtIn;
    }

    // Send the message to mediator
    @Override
    public void sendMessage(String msg) {
        mediator.sendMessage(msg, this);
    }

    @Override
    public void receiveMessage(String msg) {
        Gson g=new Gson();
        Command c=g.fromJson(msg, Command.class);
        txtOut.append(c.getParameter("value").toString()+"\n");
    }   
}
