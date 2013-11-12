package pe.edu.unsaac.in.qillqana.client.swing.ui.mediator.suscriptors;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.logging.Level;
import org.apache.log4j.Logger;
import pe.edu.unsaac.in.qillqana.client.swing.ui.mediator.Mediator;
import pe.edu.unsaac.in.qillqana.common.command.Command;

public class SocketClient extends Thread implements Suscriptor{
    public static final Logger logger=Logger.getLogger(SocketClient.class.getName());
    
    private int id;
    private Mediator mediator;
    private BufferedReader in;
    private PrintWriter out;

    public SocketClient(String address,int port,Mediator mediator) {
        initStreams(address, port);
        this.mediator=mediator;
    }

    @Override
    public void run() {
        String line="";
        try {
            while ((line=in.readLine())!=null) {
                sendMessage(line);
            }
        } catch (IOException ex) {
            java.util.logging.Logger.getLogger(SocketClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Here we will to send the message to the mediator
    @Override
    public void sendMessage(String msg) {
        mediator.sendMessage(msg, this);
    }
    
    // Here the client will send the message by Socket
    @Override
    public void receiveMessage(String msg) {
        logger.info("sending message: "+msg);
        Gson g=new Gson();
        Command cmd=new Command();
        cmd.setName("message");
        cmd.addParameter("value",msg);
        out.println(g.toJson(cmd));
    }

    private void initStreams(String address,int port) {
        try {
            Socket socket=new Socket("", port);
            in=new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out=new PrintWriter(socket.getOutputStream(),true);
        } catch (IOException ex) {
            logger.error(ex);
        }
    }
    
}
