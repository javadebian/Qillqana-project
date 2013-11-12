package pe.edu.unsaac.in.qillqana.client.swing.ui.mediator;

import pe.edu.unsaac.in.qillqana.client.swing.ui.mediator.suscriptors.Suscriptor;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import pe.edu.unsaac.in.qillqana.common.command.Command;

public class MessageMediator implements Mediator{
    private final Logger logger=Logger.getLogger(MessageMediator.class.getName());
    
    private List<Suscriptor> suscriptors;

    public MessageMediator() {
        suscriptors=new ArrayList<>();
    }
    

    @Override
    public void addSuscriptor(Suscriptor suscriptor) {
        suscriptors.add(suscriptor);
    }

    @Override
    public void sendMessage(String message, Suscriptor origin) {
        for (Suscriptor suscriptor : suscriptors) {
            if(suscriptor!=origin){
                suscriptor.receiveMessage(message);
            }
        }
    }

    @Override
    public void removeSuscriptor(Suscriptor suscriptor) {
        boolean remove = suscriptors.remove(suscriptor);
    }
    
}
