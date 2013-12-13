package pe.edu.unsaac.in.qillqana.server.dao.impl.mariadb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;

import pe.edu.unsaac.in.qillqana.common.model.Lesson;
import pe.edu.unsaac.in.qillqana.common.model.LessonFile;
import pe.edu.unsaac.in.qillqana.server.dao.LessonDao;
import pe.edu.unsaac.in.qillqana.server.dao.LessonFileDao;

public class LessonDaoMariaDb implements LessonDao {
	public static final Logger logger = Logger.getLogger(UserDaoMariaDb.class
			.getName());

	private Connection connection;

	private PreparedStatement insertStatement;
	private PreparedStatement updateStatement;
//	private PreparedStatement deleteStatement;
//	private PreparedStatement findAllStatement;
//	private PreparedStatement findByIdStatement;
//	private PreparedStatement findByTitleStatement;
//	private PreparedStatement findByTeacherIdStatement;

	public LessonDaoMariaDb(Connection connection) {
		this.connection = connection;
		initStatements();
	}
	@Override
	public boolean save(Lesson lesson) {
		boolean result = true;
		try {
			insertStatement.setString(1, lesson.getTitle());
			insertStatement.setString(2, lesson.getState());
			
			insertStatement.executeUpdate();
			
			if(lesson.getFiles().size()>0){
				LessonFileDao lfd=new LessonFileDaoMariaDb(connection);
				for (LessonFile file : lesson.getFiles()) {
					// TODO Update this statement for insert the lesson id too
					lfd.save(file);
				}
			}
			result=true;
		} catch (SQLException e) {
			result = false;
			logger.error(e);
		}
		return result;
	}

	@Override
	public boolean update(Lesson lesson) {
		boolean result = true;
		try {
			updateStatement.setInt(1, lesson.getId());
			updateStatement.setString(2, lesson.getTitle());
			updateStatement.setString(3, lesson.getState());
			updateStatement.executeUpdate();
			result = true;
		} catch (SQLException e) {
			result = false;
			logger.error(e);
		}
		return result;
	}

	@Override
	public boolean delete(Lesson lesson) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Lesson> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Lesson findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Lesson findByTitle(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Lesson findByTeacherId(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	private void initStatements() {
		try {
			insertStatement = this.connection
					.prepareStatement("INSERT INTO lesson(title,state,id_user) VALUES (?,?,?)");
			updateStatement = this.connection
					.prepareStatement("UPDATE lesson(id,title,state,id_user) SET(?,?,?,?) where id=?");
//			deleteStatement = this.connection
//					.prepareStatement("DELETE lesson WHERE id=?");
//			findAllStatement = this.connection
//					.prepareStatement("SELECT * FROM lesson");
//			findByIdStatement = this.connection
//					.prepareStatement("SELECT * FROM lesson WHERE id=?");
//			findByTitleStatement = this.connection
//					.prepareStatement("SELECT * FROM lesson WHERE title=?");
//			findByTitleStatement = this.connection
//					.prepareStatement("SELECT * FROM lesson WHERE id_user=?");
		} catch (SQLException e) {
			logger.error(e.getLocalizedMessage());
		}
	}
}
