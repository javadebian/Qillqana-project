package pe.edu.unsaac.in.qillqana.server.mediator;

import java.io.BufferedReader;
import java.io.PrintWriter;

public abstract class Session {

    protected BufferedReader in;
    protected PrintWriter out;

    private Mediator mediator;

    public Session(Mediator mediator, BufferedReader in, PrintWriter out) {
        this.mediator = mediator;
        this.in = in;
        this.out = out;
    }

    public void send(String message) {
        mediator.send(message, this);
    }

    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    public Mediator getMediator() {
        return mediator;
    }

    public abstract void receive(String message);
}
