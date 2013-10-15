package pe.edu.unsaac.in.qillqana.common.commands;

public class LoginCommand extends Command {
	public LoginCommand() {
		name = "login";
	}

	public String getUser() {
		return parameters.get("user").toString();
	}

	public void setUser(String user) {
		parameters.put("user", user);
	}

	public String getPass() {
		return parameters.get("pass").toString();
	}

	public void setPass(String pass) {
		parameters.put("pass", pass);
	}

}
