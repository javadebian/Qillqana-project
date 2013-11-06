package pe.edu.unsaac.in.qillqana.server.mediator;

import java.io.BufferedReader;
import java.io.PrintWriter;
import pe.edu.unsaac.in.qillqana.common.model.Teacher;

public class TeacherSession extends Session{
    private Teacher teacher;

    public TeacherSession(Mediator mediator, BufferedReader in, PrintWriter out) {
        super(mediator, in, out);
    }    

    @Override
    public void receive(String message) {
        
    }

    public Teacher getTeacher() {
        return teacher;
    }
    
}
