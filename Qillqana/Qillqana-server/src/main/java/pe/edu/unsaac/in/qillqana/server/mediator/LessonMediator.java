package pe.edu.unsaac.in.qillqana.server.mediator;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import pe.edu.unsaac.in.qillqana.common.command.Command;
import pe.edu.unsaac.in.qillqana.common.mediator.Mediator;
import pe.edu.unsaac.in.qillqana.common.mediator.Session;
import pe.edu.unsaac.in.qillqana.common.model.Teacher;

public class LessonMediator implements Mediator{
    public static final Logger LOGGER=Logger.getLogger(LessonMediator.class.getName());
    
    private String idLM;
    private Teacher teacher;
    private String topic;
    private List<Session> sessions;

    public LessonMediator() {
        sessions=new ArrayList<>();
    }

    public LessonMediator(String idLM, Teacher teacher) {
        this.idLM = idLM;
        this.teacher = teacher;
    }

    public String getIdLM() {
        return idLM;
    }

    public void setIdLM(String idLM) {
        this.idLM = idLM;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }
    
    public void addSession(Session session){
        LOGGER.info("Adding a new Session");
        sessions.add(session);
    }
    
    public synchronized void sendMessage(Command command,Session originator){
        for (Session session : sessions) {
            if(session!=originator){
                LOGGER.info("Sending message to: "+session.getIdSession());
                // TODO Revisitar esta parte para depurar esto
                session.receiveCommand(command);
//                session.sendRemoteMessage(GsonUtils.toJson(command));
            }
        }
    }
    
    public void removeSession(Session session){
        sessions.remove(session);
    }
}
