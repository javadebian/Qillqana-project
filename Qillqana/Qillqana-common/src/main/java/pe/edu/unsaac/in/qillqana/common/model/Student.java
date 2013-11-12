package pe.edu.unsaac.in.qillqana.common.model;

public class Student extends User{
    private String level;

    public Student() {
    }

    public Student(String level, int id, String user, String password, String names, String surnames, String email) {
        super(id, user, password, names, surnames, email);
        this.level = level;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }    
}
