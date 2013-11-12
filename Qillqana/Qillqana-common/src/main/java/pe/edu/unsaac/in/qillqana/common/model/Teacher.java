package pe.edu.unsaac.in.qillqana.common.model;

public class Teacher extends User{
    private String especiality;

    public Teacher() {
    }

    public Teacher(String especiality, int id, String user, String password, String names, String surnames, String email) {
        super(id, user, password, names, surnames, email);
        this.especiality = especiality;
    }

    public String getEspeciality() {
        return especiality;
    }

    public void setEspeciality(String especiality) {
        this.especiality = especiality;
    }
    
}
