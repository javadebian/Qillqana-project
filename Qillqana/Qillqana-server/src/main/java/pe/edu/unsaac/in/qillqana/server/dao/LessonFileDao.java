package pe.edu.unsaac.in.qillqana.server.dao;

import java.util.List;

import pe.edu.unsaac.in.qillqana.common.model.Lesson;
import pe.edu.unsaac.in.qillqana.common.model.LessonFile;

public interface LessonFileDao {
	public boolean save(LessonFile file);
    public boolean update(LessonFile file);
    public boolean delete(LessonFile file);
    public List<LessonFile> findAll();
    public Lesson findById(int id);
    public Lesson findByName(String name);
    public Lesson findByLessonId(int id);
}
