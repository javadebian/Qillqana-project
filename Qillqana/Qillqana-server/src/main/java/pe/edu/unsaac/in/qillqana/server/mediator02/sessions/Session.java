package pe.edu.unsaac.in.qillqana.server.mediator02.sessions;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import org.apache.log4j.Logger;
import pe.edu.unsaac.in.qillqana.common.command.Command;
import pe.edu.unsaac.in.qillqana.server.mediator02.LessonMediator;

public class Session extends Thread{
    
    public static final Logger LOGGER=Logger.getLogger(Session.class.getName());
    
    private int idSession;
    private LessonMediator mediator;
    private BufferedReader in;
    private PrintWriter out;
    

    public Session(int id, LessonMediator mediator, Socket socket) throws IOException {
        this.idSession = id;
        this.mediator = mediator;
        this.in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        this.out = new PrintWriter(socket.getOutputStream(),true);
    }

    public int getIdSession() {
        return idSession;
    }
    
    @Override
    public void run() {
        try {
            String line=null;
            Command cmd=null;
            Gson gson=new Gson();
            boolean _break=false;
            
            do{
                line=in.readLine();
                LOGGER.info("Message received"+line);
                if(line!=null){
                    cmd=gson.fromJson(line, Command.class);
                    // TODO Change the "exit" string with a constant or something like
                    // TODO Fix this part to process the protocol better
                    if(!cmd.getName().equals("exit")){
                        LOGGER.info("Sending message to mediator...");
                        mediator.sendMessage(line, this);
                    }else{
                        _break=true;
                    }
                }else{
                    _break=true;
                }
            }while(!_break);
        } catch (IOException ex) {
            Logger.getLogger(Session.class.getName()).error(ex);
        }
    }
    
    public void sendMessage(String message){
        mediator.sendMessage(message, this);
    }

    public void sendRemoteMessage(String message) {
        LOGGER.info("Sending message using socket...");
        out.println(message);
    }
}
