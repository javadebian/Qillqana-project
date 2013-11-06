package pe.edu.unsaac.in.qillqana.server.mediator;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import pe.edu.unsaac.in.qillqana.common.model.Teacher;

public class SessionController {

    public static final Logger logger = Logger
            .getLogger(SessionController.class);

    private List<LessonMediator> mediators;

    public SessionController() {
        mediators = new ArrayList<>();
    }

    public List<LessonMediator> getMediators() {
        return mediators;
    }

    public void setMediators(List<LessonMediator> mediators) {
        this.mediators = mediators;
    }

    public List<String> getSessionsTopics() {
        List<String> topics = new ArrayList<>();
        for (LessonMediator mediator : mediators) {
            topics.add(mediator.getTopic());
        }
        return topics;
    }

    public List<Teacher> getAllTeachers() {
        List<Teacher> teachers = new ArrayList<>();
        for (LessonMediator mediator : mediators) {
            teachers.add(mediator.getTeacher());
        }
        return teachers;
    }

    public void createMediator(String id) {
        mediators.add(new LessonMediator(id));
    }

    public void addStudentSession(String idSessionMediator, StudentSession session) {
        getSessionMediator(idSessionMediator).addColleague(session);
    }

    public LessonMediator getSessionMediator(String idSessionMediator) {
        LessonMediator sm=null;
        for (LessonMediator mediator : mediators) {
            if(mediator.getId().equals(idSessionMediator)){
                sm=mediator;
                break;
            }
        }
        return sm;
    }
}
