package pe.edu.unsaac.in.qillqana.client.android.mediator;

import android.app.Activity;
import android.util.JsonWriter;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import pe.edu.unsaac.in.qillqana.client.android.commands.Command;

public class SocketSuscriptor extends Activity implements Suscriptor,Runnable {

    private BufferedReader in;
    private PrintWriter out;
    private Mediator mediator;
    private Socket socket;

    public SocketSuscriptor() {
    }

    public SocketSuscriptor(Mediator mediator) {
        this.mediator=mediator;
    }

    @Override
    public void run() {
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
            e.printStackTrace();
        }
    }

    //
    @Override
    public void receiveMessage(String message){
        String msg="{\"name\":\"message\",\"parameters\":{\"value\":\""+message+"\"}}";
        out.println(msg);
    }

    @Override
    public void sendMessage(String message) {
        mediator.sendMessage(message,this);
    }
}
