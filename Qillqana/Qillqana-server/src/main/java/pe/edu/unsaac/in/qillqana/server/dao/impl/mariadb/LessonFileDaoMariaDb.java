package pe.edu.unsaac.in.qillqana.server.dao.impl.mariadb;

import java.sql.Connection;
import java.util.List;

import pe.edu.unsaac.in.qillqana.common.model.Lesson;
import pe.edu.unsaac.in.qillqana.common.model.LessonFile;
import pe.edu.unsaac.in.qillqana.server.dao.LessonFileDao;

public class LessonFileDaoMariaDb implements LessonFileDao {

	public LessonFileDaoMariaDb(Connection connection) {
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean save(LessonFile file) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(LessonFile file) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(LessonFile file) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<LessonFile> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Lesson findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Lesson findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Lesson findByLessonId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
