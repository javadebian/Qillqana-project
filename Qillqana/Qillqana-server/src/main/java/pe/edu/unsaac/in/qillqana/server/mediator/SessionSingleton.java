package pe.edu.unsaac.in.qillqana.server.mediator;

public class SessionSingleton {
    private static final SessionController instance=null;
    
    public static SessionController getInstance(){
        if(instance==null)
            return new SessionController();
        else
            return instance;
    }
}
