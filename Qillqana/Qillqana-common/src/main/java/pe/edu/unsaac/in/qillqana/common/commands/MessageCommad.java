package pe.edu.unsaac.in.qillqana.common.commands;


public class MessageCommad extends Command {
	public MessageCommad() {
		name="message";
	}
	public void setMessageBody(String message){
		if(parameters.size()==0){
			parameters.put("body", message);
		}
	}
	public String getMessageBody(){
		return parameters.get("body").toString();
	}
}
