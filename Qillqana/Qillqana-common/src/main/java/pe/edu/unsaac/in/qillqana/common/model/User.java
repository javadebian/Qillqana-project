package pe.edu.unsaac.in.qillqana.common.model;

public class User {

    private int id;
    private String user;
    private String password;
    private String names;
    private String surnames;
    private String email;

    public User() {
    }

    public User(int id, String user, String password, String names, String surnames, String email) {
        this.id = id;
        this.user = user;
        this.password = password;
        this.names = names;
        this.surnames = surnames;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNames() {
        return names;
    }

    public void setNames(String names) {
        this.names = names;
    }

    public String getSurnames() {
        return surnames;
    }

    public void setSurnames(String surnames) {
        this.surnames = surnames;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
