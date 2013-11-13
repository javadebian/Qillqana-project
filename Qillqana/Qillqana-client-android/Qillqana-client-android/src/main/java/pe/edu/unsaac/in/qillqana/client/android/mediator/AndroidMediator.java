package pe.edu.unsaac.in.qillqana.client.android.mediator;

import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;

public class AndroidMediator implements Mediator {
    private List<Suscriptor> suscriptors;

    public AndroidMediator() {
        suscriptors =new ArrayList<Suscriptor>();
    }

    @Override
    public void addSuscriptor(Suscriptor suscriptor) {
        suscriptors.add(suscriptor);
    }

    @Override
    public void sendMessage(String message, Suscriptor origin) {
        for (Suscriptor suscriptor: suscriptors){
            if(origin!=suscriptor){
                suscriptor.receiveMessage(message);
            }
        }
    }

    @Override
    public int size() {
        return suscriptors.size();
    }
}
