package pe.edu.unsaac.in.qillqana.client.swing;

import com.google.gson.Gson;
import java.io.IOException;
import org.apache.log4j.PropertyConfigurator;
import pe.edu.unsaac.in.qillqana.client.swing.mock.Client;
import pe.edu.unsaac.in.qillqana.common.command.Command;

public class App {

    public static void main(String[] args) throws IOException {
        PropertyConfigurator.configure("log4j.properties");

        Client c01 = new Client();
        Client c02 = new Client();
        Client c03 = new Client();

        c01.setId(1);
        c02.setId(2);
        c03.setId(3);

        c01.start();
        c02.start();
        c03.start();

        Gson gson = new Gson();
        Command cmd = new Command();
        cmd.setName("Mensaje");

        cmd.addParameter("msg", "Mensaje desde el Cliente 01");
        c01.enviarMensaje(gson.toJson(cmd));
        System.out.println(gson.toJson(cmd));

        cmd.addParameter("msg", "Mensaje desde el Cliente 02");
        c02.enviarMensaje(gson.toJson(cmd));
        System.out.println(gson.toJson(cmd));

        cmd.addParameter("msg", "Mensaje desde el Cliente 03");
        c03.enviarMensaje(gson.toJson(cmd));
        System.out.println(gson.toJson(cmd));
    }
}
