package pe.edu.unsaac.in.qillqana.server.impl;

import java.io.BufferedReader;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.logging.Logger;

import pe.edu.unsaac.in.qillqana.common.command.Command;

import com.google.gson.Gson;
import pe.edu.unsaac.in.qillqana.common.command.LoginCommand;
import pe.edu.unsaac.in.qillqana.server.mediator.SessionSingleton;
import pe.edu.unsaac.in.qillqana.server.mediator.StudentSession;

public class ServerThread extends Thread {

    /**
     * Logger for this class
     */
    public static final Logger logger = Logger.getLogger(ServerThread.class
            .getName());

    private PrintWriter out;
    private BufferedReader in;
    private Socket socket;

    public ServerThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        logger.info("Thread inicialized");
        initStreams();
        try {
            String line = "";
            Command prototype;
            Gson translator = new Gson();
            boolean _break = false;
            while (!_break && (line = in.readLine()) != null) {
                // Read the command and the process it
                prototype = translator.fromJson(line, Command.class);
                // Here begins the protocol implementation
                switch (prototype.getName()) {
                    // We will to process the control commands here
                    case "login":
                        // Create a query for the database
                        // if the user is a valid student put him to the transitory list
                        // if the user is a valid teacher put him to the session list directly
                        LoginCommand login=(LoginCommand)prototype;
                        // This line simulates the login process for a teacher
                        if(login.getUser().equals("profesor")){
                            SessionSingleton.getInstance().createMediator("1");
                        }
                        if(login.getUser().equals("alumno")){
                            // By now we put all students to first session
                            SessionSingleton.getInstance().addStudentSession("1", new StudentSession(null, in, out));
                        }
                        break;
                    case "session_list":
                        // Return the list session from the server, often retrieve to student sessions
                        String list=translator.toJson(SessionSingleton.getInstance().getAllTeachers());
                        out.println(list);
                        break;
                    case "session":
                        // Change a user from the temp list to Correct session list
                        break;
                    case "exit":
                        logger.info("EXIT command was received");
                        _break = true;
                        break;
                    default:
                        // Here we will to resend other commands types to the
                        // clients connected like shape commands, message commands, etc
                        System.out.println(prototype.toString());
                        break;
                }
            }
            // This two methods will be execute when a exit command is received or the connection fails 
            disposeSession();
            closeStreams();
        } catch (EOFException e) {
            logger.severe("The connection with client fails");
            logger.severe(e.getLocalizedMessage());
            closeStreams();
        } catch (IOException e) {
            logger.severe(e.getMessage());
        }
    }

    private void disposeSession() {
        // TODO notify to the system that this session is killed
        // clean the session from all lists
    }

    private void closeStreams() {
        try {
            logger.info("Killing streams and connection");
            in.close();
            out.close();
            socket.close();
            join();
        } catch (IOException | InterruptedException e) {
            logger.severe(e.getMessage());
        }
    }

    private void initStreams() {
        try {
            out = new PrintWriter(socket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(
                    socket.getInputStream()));
        } catch (IOException e) {
            logger.severe(e.getMessage());
        }
    }
}
