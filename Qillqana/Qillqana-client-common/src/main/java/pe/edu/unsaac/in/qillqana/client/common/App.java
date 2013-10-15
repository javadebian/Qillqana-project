package pe.edu.unsaac.in.qillqana.client.common;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import com.google.gson.Gson;

import pe.edu.unsaac.in.qillqana.common.commands.MessageCommad;

public class App {
	public static void main(String[] args) throws UnknownHostException,
			IOException {
		MessageCommad cmd = new MessageCommad();
		cmd.setMessageBody("Hola mundo");
		Socket socket = new Socket("localhost", 1234);
		PrintWriter out = new PrintWriter(socket.getOutputStream(),true);
		BufferedReader in = new BufferedReader(new InputStreamReader(
				socket.getInputStream()));
		Gson translator = new Gson();
		out.println(translator.toJson(cmd));
		System.out.println(in.readLine());
		socket.close();
	}
}
