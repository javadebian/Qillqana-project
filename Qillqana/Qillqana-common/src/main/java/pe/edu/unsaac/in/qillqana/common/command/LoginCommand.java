package pe.edu.unsaac.in.qillqana.common.command;

public class LoginCommand extends Command {

    public LoginCommand() {
        super();
        setName("login");
    }

    public LoginCommand(String user, String password) {
        super();
        setName("login");
        setUser(user);
        setPassword(password);
    }

    public void setUser(String user) {
        parameters.put("user", user);
    }

    public void setPassword(String password) {
        parameters.put("password", password);
    }

    public String getUser() {
        return parameters.get("user").toString();
    }

    public String getPassword() {
        return parameters.get("password").toString();
    }
}
