package pe.edu.unsaac.in.qillqana.client.android.mediator;

import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class SocketSuscriptorAT extends AsyncTask<Void,String,Boolean> implements Suscriptor{
    private BufferedReader in;
    private PrintWriter out;
    private Mediator mediator;
    private Socket socket;

    public SocketSuscriptorAT(Mediator mediator){
        this.mediator=mediator;
    }

    @Override
    public void receiveMessage(String message) {
        String msg="{\"name\":\"message\",\"parameters\":{\"value\":\""+message+"\"}}";
        out.println(msg);
    }

    @Override
    public void sendMessage(String message) {
        mediator.sendMessage(message,this);
    }

    @Override
    protected Boolean doInBackground(Void... voids) {
        try {
            socket=new Socket("10.10.7.167",1234);
            //socket=new Socket("192.168.1.39",1234);
            in=new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
            out=new PrintWriter(this.socket.getOutputStream(),true);

            String line="";
            while ((line=in.readLine())!=null){
                sendMessage(line);
            }
        } catch (IOException e) {
            Log.e("Qillqana",e.getMessage());
        }
        return true;
    }
}
