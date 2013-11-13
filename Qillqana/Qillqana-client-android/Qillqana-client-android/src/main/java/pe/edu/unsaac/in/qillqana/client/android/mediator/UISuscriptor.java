package pe.edu.unsaac.in.qillqana.client.android.mediator;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.TextView;

public class UISuscriptor extends AsyncTask implements Suscriptor{

    private Mediator mediator;
    private TextView txtIn;
    private TextView txtOut;

    public UISuscriptor(Mediator mediator,TextView txtIn,TextView txtOut){
        this.txtIn=txtIn;
        this.txtOut=txtOut;
        this.mediator=mediator;
    }
    @Override
    public void receiveMessage(String message) {
        txtOut.append(message+"\n");
    }

    @Override
    public void sendMessage(String message) {
        mediator.sendMessage(message,this);
    }

    @Override
    protected Object doInBackground(Object[] objects) {
        while(!isCancelled()){
            
        }
        return "OK";
    }
}
