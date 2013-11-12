package pe.edu.unsaac.in.qillqana.client.swing.ui.mediator;

import pe.edu.unsaac.in.qillqana.client.swing.ui.mediator.suscriptors.Suscriptor;

public interface Mediator {
    public void addSuscriptor(Suscriptor suscriptor);
    public void removeSuscriptor(Suscriptor suscriptor);
    public void sendMessage(String message,Suscriptor suscriptor);
}
