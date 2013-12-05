package pe.edu.unsaac.in.qillqana.common.command;

public class MessageCommand extends Command {
	public MessageCommand() {
		super();
		setName("message");
	}
	public void setBody(String body){
		parameters.put("body", body);
	}
	public String getBody(){
		return parameters.get("body").toString();
	}
}
