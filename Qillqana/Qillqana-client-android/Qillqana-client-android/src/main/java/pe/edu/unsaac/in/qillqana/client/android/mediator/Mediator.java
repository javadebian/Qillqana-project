package pe.edu.unsaac.in.qillqana.client.android.mediator;

/**
 * Created by alexove on 12/11/13.
 */
public interface Mediator {
    public void addSuscriptor(Suscriptor suscriptor);
    public void sendMessage(String message,Suscriptor origin);
    public int size();
}
