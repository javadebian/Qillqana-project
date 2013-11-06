package pe.edu.unsaac.in.qillqana.client.swing.mock;

import java.io.BufferedReader;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import org.apache.log4j.Logger;

public class Client extends Thread {

    public static final Logger LOGGER=Logger.getLogger(Client.class.getName());
    
    private int id;
    private BufferedReader in;
    private PrintWriter out;

    public Client() throws IOException {
        Socket socket = new Socket("localhost", 1234);
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        out = new PrintWriter(socket.getOutputStream(), true);
    }

    @Override
    public synchronized void run() {
        try {
            String linea="";
            while (true) {
                linea=in.readLine();
                LOGGER.info("Cliente " + id + ": desde el servidor: " + linea);
            }
        } catch(EOFException ex){
            
        }
        catch (IOException ex) {
            LOGGER.error(ex);
        }
    }

    public void enviarMensaje(String mensaje) {
        out.println(mensaje);
    }

    public int getId_() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
