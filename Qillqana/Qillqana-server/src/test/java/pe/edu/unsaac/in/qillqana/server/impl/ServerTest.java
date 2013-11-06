package pe.edu.unsaac.in.qillqana.server.impl;

import com.google.gson.Gson;
import junit.framework.TestCase;
import pe.edu.unsaac.in.qillqana.common.command.Command;

import java.net.Socket;
import java.io.*;
import java.util.logging.Logger;
import pe.edu.unsaac.in.qillqana.common.command.LoginCommand;

public class ServerTest extends TestCase {

    public final static Logger logger = Logger.getLogger(ServerTest.class.getName());

    // Throught this socket we will send the data
    private Socket socket;
    // These object are comming from common package
    private Command command;

    private PrintWriter out;
    private BufferedReader in;

    protected void setUp() throws Exception {
        super.setUp();
        // Then init a client connection
        socket = new Socket("localhost", 1234);

        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        out = new PrintWriter(socket.getOutputStream(), true);

        command = new Command();

    }

    protected void tearDown() throws Exception {
        super.tearDown();
    }

    public void testInitServer() throws Exception {
        // Primero vamos a probar comofunciona los comandos de login con un profesor y un alumno
        Command aCommand=null;
        Command pCommand=null;
        
        aCommand=new LoginCommand("alumno","alumno");
        pCommand=new LoginCommand("profesor","profesor");
        //
        Gson gson = new Gson();
        String string_command = gson.toJson(command);
        logger.info(string_command);
        logger.info("Sending a test command");
        out.println(string_command);
    }

    public void testRun() throws Exception {

    }
}
