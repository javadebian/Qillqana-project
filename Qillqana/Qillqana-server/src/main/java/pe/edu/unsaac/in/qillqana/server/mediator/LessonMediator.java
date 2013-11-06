package pe.edu.unsaac.in.qillqana.server.mediator;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import pe.edu.unsaac.in.qillqana.common.model.Teacher;

/**
 * This is our concrete mediator
 */
public class LessonMediator implements Mediator {

    public static final Logger logger = Logger.getLogger(LessonMediator.class.getName());
    
    private String id;
    private String topic;
    private boolean hasTeacher;
    private List<Session> colleagues;

    public LessonMediator() {
        colleagues = new ArrayList<>();
        hasTeacher = false;
    }

    public LessonMediator(String id){
        colleagues=new ArrayList<>();
        hasTeacher=false;
        this.id=id;
    }
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Session> getColleagues() {
        return colleagues;
    }

    public void setColleagues(List<Session> colleagues) {
        this.colleagues = colleagues;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public Teacher getTeacher(){
        Teacher teacher = null;
        for (Session session : colleagues) {
            if(session instanceof TeacherSession){
                teacher=((TeacherSession)session).getTeacher();
                break;
            }
        }
        return teacher;
    }
    
    public void addColleague(Session colleague) {
        if (!hasTeacher && (colleague instanceof TeacherSession)) {
            hasTeacher = true;
            colleagues.add(colleague);
        }else if (colleague instanceof StudentSession){
            colleagues.add(colleague);
        }else{
            // TODO Send a error message because can't be a two teachers in the same 
            // room
        }
    }

    @Override
    public void send(String message, Session originator) {
        if (originator instanceof TeacherSession) {
            for (Session colleague : colleagues) {
                if (colleague != originator) {
                    colleague.receive(message);
                    logger.info(message);
                }
            }
        } else if (originator instanceof StudentSession) {
            // TODO If the student session is not enabled to send commands it will be
            // ignore
            for (Session colleague : colleagues) {
                if (colleague != originator) {
                    colleague.receive(message);
                    logger.info(message);
                }
            }
        }
    }
}
