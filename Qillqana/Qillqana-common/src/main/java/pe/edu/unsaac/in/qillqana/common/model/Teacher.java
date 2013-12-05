package pe.edu.unsaac.in.qillqana.common.model;

import java.util.ArrayList;
import java.util.List;

public class Teacher extends User{
    private List<Lesson> lessons;
    
    public Teacher() {
    	lessons=new ArrayList<>();
    }
    
    public void addLesson(Lesson lesson){
    	lessons.add(lesson);
    }
    
    public void removeLesson(Lesson lesson){
    	lessons.remove(lesson);
    }
    public Lesson getLesson(int i){
    	return lessons.get(i);
    }
}
