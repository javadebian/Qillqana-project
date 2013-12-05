package pe.edu.unsaac.in.qillqana.server.dao;

import java.util.List;

import pe.edu.unsaac.in.qillqana.common.model.Lesson;

public interface LessonDao {
	public boolean save(Lesson lesson);
    public boolean update(Lesson lesson);
    public boolean delete(Lesson lesson);
    public List<Lesson> findAll();
    public Lesson findById(int id);
    public Lesson findByTitle(String name);
    public Lesson findByTeacherId(int id);
}
