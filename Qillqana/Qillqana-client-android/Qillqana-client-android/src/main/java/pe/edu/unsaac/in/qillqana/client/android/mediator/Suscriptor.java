package pe.edu.unsaac.in.qillqana.client.android.mediator;

import org.json.JSONException;

public interface Suscriptor {
    public void receiveMessage(String message);
    public void sendMessage(String message);
}
