package pe.edu.unsaac.in.qillqana.client.swing.test;

import org.apache.log4j.PropertyConfigurator;

import pe.edu.unsaac.in.qillqana.client.swing.ui.mediator.ConsoleSession;
import pe.edu.unsaac.in.qillqana.client.swing.ui.mediator.MessageMediador;
import pe.edu.unsaac.in.qillqana.client.swing.ui.mediator.SocketSession;
import pe.edu.unsaac.in.qillqana.common.command.Command;
import pe.edu.unsaac.in.qillqana.common.command.LoginCommand;
import pe.edu.unsaac.in.qillqana.common.mediator.Mediator;

public class ClientAppTest {
	public static void main(String[] args) {
		PropertyConfigurator.configure("log4j.properties");
		
		Test01();
	}
	public static void Test01(){
		
		Mediator mediator=new MessageMediador();
		
		SocketSession client=new SocketSession("localhost", 1234, mediator);
		ConsoleSession console=new ConsoleSession(mediator);
		
		client.start();
		console.start();
		
		mediator.addSession(client);
		mediator.addSession(console);
		
		LoginCommand loginCommand=new LoginCommand();
		loginCommand.setUser("alexove");
		loginCommand.setPassword("alexove");
		
		console.sendCommand(loginCommand);
		
	}
	public static void Test(){
		SocketSession client01;
		SocketSession client02;
		
		ConsoleSession console01;
		ConsoleSession console02;

		String host = "localhost";
		int port = 1234;

		Mediator mediator01;
		Mediator mediator02;
		
		mediator01 = new MessageMediador();
		mediator02 = new MessageMediador();

		client01 = new SocketSession(host, port, mediator01);
		client02 = new SocketSession(host, port, mediator02);
		
		console01=new ConsoleSession(mediator01);
		console02=new ConsoleSession(mediator02);

		mediator01.addSession(client01);
		mediator02.addSession(client02);
		
		mediator01.addSession(console01);
		mediator02.addSession(console02);
		

		client01.start();
		client02.start();
		
		Command command=new Command();
		command.setName("message");
		command.addParameter("value", "Hola");
		console01.sendCommand(command);
		command.addParameter("value", "Adios");
		console02.sendCommand(command);
		
		command.setName("exit");
		command.setName("exit");
		
		console01.sendCommand(command);
		console02.sendCommand(command);

	}
}