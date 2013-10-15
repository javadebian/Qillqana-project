package pe.edu.unsaac.in.qillqana.server.impl;

import java.io.BufferedReader;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.logging.Logger;

public class ServerThread extends Thread{
	
	private static Logger logger=Logger.getLogger(ServerThread.class.getName());
	
	private PrintWriter out;
	private BufferedReader in;
	private Socket socket;
	
	public ServerThread(Socket socket) {
		this.socket=socket;
	}

	@Override
	public void run() {
		initStreams();
		try {
			String line="";
			while((line=in.readLine())!=null){
				// Read the command and the process it
				
				System.out.println("Receiving: "+line);
				out.println("Returning: "+line);
			}
		}catch(EOFException e){
			logger.severe("The connection with client fails");
			logger.severe(e.getLocalizedMessage());
			closeStreams();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void closeStreams() {
		try {
			in.close();
			out.close();
			socket.close();
			join();
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}
		
	}

	private void initStreams() {
		try {
			out=new PrintWriter(socket.getOutputStream(), true);
			in=new BufferedReader(new InputStreamReader(socket.getInputStream()));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
}
