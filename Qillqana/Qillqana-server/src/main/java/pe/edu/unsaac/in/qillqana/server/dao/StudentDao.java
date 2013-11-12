package pe.edu.unsaac.in.qillqana.server.dao;

import java.util.List;
import pe.edu.unsaac.in.qillqana.common.model.Student;

public interface StudentDao {
    public boolean save(Student student);
    public boolean update(Student student);
    public boolean delete(Student student);
    public List<Student> findAll();
    public Student findById(int id);
    public Student findByName(String name);
}
