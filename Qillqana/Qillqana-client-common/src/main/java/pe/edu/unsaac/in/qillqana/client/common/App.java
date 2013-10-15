package pe.edu.unsaac.in.qillqana.client.common;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import pe.edu.unsaac.in.qillqana.common.command.Command;

import com.google.gson.Gson;

public class App {
	@SuppressWarnings("unused")
	public static void main(String[] args) throws UnknownHostException,
			IOException, InterruptedException {
		Command cmd = new Command();
		cmd.setName("message");
		cmd.addParameter("body", "Hola mundo");
		Socket socket = new Socket("localhost", 1234);
		PrintWriter out = new PrintWriter(socket.getOutputStream(),true);
		BufferedReader in = new BufferedReader(new InputStreamReader(
				socket.getInputStream()));
		Gson translator = new Gson();
		out.println(translator.toJson(cmd));
		Thread.sleep(5000);
		cmd.setName("exit");
		out.println(translator.toJson(cmd));
		socket.close();
	}
}
