package pe.edu.unsaac.in.qillqana.server.dao;

import java.util.List;
import pe.edu.unsaac.in.qillqana.common.model.Teacher;

public interface TeacherDao{
    public boolean add(Teacher teacher);
    public boolean delete(Teacher teacher);
    public boolean update(Teacher teacher);
    public List<Teacher> findAll();
    public Teacher findById(int id);
    public Teacher findByName(String name);
    
}
