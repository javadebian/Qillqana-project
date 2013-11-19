package pe.edu.unsaac.in.qillqana.server.dao.impl.mariadb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import pe.edu.unsaac.in.qillqana.common.model.Student;
import pe.edu.unsaac.in.qillqana.server.dao.StudentDao;

public class StudentDaoMariaDb implements StudentDao {
	public static final Logger logger = Logger.getLogger(StudentDaoMariaDb.class);

	private Connection connection;
	
	private PreparedStatement insertStatement;
	private PreparedStatement updateStatement;
	private PreparedStatement deleteStatement;
	private PreparedStatement findAllStatement;
	private PreparedStatement findByIdStatement;
	private PreparedStatement findByUserNameStatement;
	
	public StudentDaoMariaDb(Connection connection) {
		this.connection=connection;
		initStatements();
	}
	private void initStatements() {
		try {
			insertStatement = this.connection
					.prepareStatement("INSERT INTO user(user,password,names,surname,email,type) VALUES (?,?,?,?,?,?)");
			updateStatement = this.connection
					.prepareStatement("UPDATE user(id,user,password,names,surname,email) SET(?,?,?,?,?,?) where id=?");
			deleteStatement = this.connection
					.prepareStatement("DELETE user WHERE id=?");
			findAllStatement = this.connection
					.prepareStatement("SELECT * FROM user WHERE type='STUDENT'");
			findByIdStatement = this.connection
					.prepareStatement("SELECT * FROM user WHERE id=?");
			findByUserNameStatement = this.connection
					.prepareStatement("SELECT * FROM user WHERE user=?");
		} catch (SQLException e) {
			logger.error(e.getLocalizedMessage());
		}
	}

	@Override
	public boolean save(Student student) {
		boolean result = true;
		try {
			insertStatement.setString(1, student.getUser());
			insertStatement.setString(2, student.getPassword());
			insertStatement.setString(3, student.getNames());
			insertStatement.setString(4, student.getSurnames());
			insertStatement.setString(5, student.getEmail());
			insertStatement.setString(6, "STUDENT");
			insertStatement.executeUpdate();
			result = true;
		} catch (SQLException e) {
			result = false;
			logger.error(e);
		}
		return result;
	}

	@Override
	public boolean update(Student student) {
		boolean result = true;
		try {
			updateStatement.setString(1, student.getUser());
			updateStatement.setString(2, student.getPassword());
			updateStatement.setString(3, student.getNames());
			updateStatement.setString(4, student.getSurnames());
			updateStatement.setString(5, student.getEmail());
			updateStatement.executeUpdate();
			result = true;
		} catch (SQLException e) {
			result = false;
			logger.error(e);
		}
		return result;
	}

	@Override
	public boolean delete(Student student) {
		boolean result = true;
		try {
			deleteStatement.setInt(1, student.getId());
			deleteStatement.executeUpdate();
			result = true;
		} catch (SQLException e) {
			result = false;
			logger.error(e);
		}
		return result;
	}

	@Override
	public Student findByName(String name) {
		Student student=null;
		try {
			findByUserNameStatement.setString(1, name);
			ResultSet result=findByUserNameStatement.executeQuery();
			if(result.next()){
				student=new Student();
				student.setId(result.getInt("id"));
				student.setUser(result.getString("user"));
				student.setPassword(result.getString("password"));
				student.setNames(result.getString("names"));
				student.setSurnames(result.getString("surname"));
				student.setEmail(result.getString("email"));
			}else{
				student=null;
			}
		} catch (SQLException e) {
			student=null;
			logger.error(e.getLocalizedMessage());
		}
		return student;
	}

	@Override
	public List<Student> findAll() {
		List<Student> students=new ArrayList<Student>();
		try {
			ResultSet result=findAllStatement.executeQuery();
			while (result.next()) {
				Student student=new Student();
				student.setId(result.getInt("id"));
				student.setUser(result.getString("user"));
				student.setPassword(result.getString("password"));
				student.setNames(result.getString("names"));
				student.setSurnames(result.getString("surname"));
				student.setEmail(result.getString("email"));
				
				students.add(student);
			}
		} catch (SQLException e) {
			students=null;
			logger.error(e.getLocalizedMessage());
		}
		return students;
	}

	@Override
	public Student findById(int id) {
		Student student=null;
		try {
			findByIdStatement.setInt(1, id);
			ResultSet result=findByIdStatement.executeQuery();
			if(result.next()){
				student=new Student();
				student.setId(result.getInt("id"));
				student.setUser(result.getString("user"));
				student.setPassword(result.getString("password"));
				student.setNames(result.getString("names"));
				student.setSurnames(result.getString("surname"));
				student.setEmail(result.getString("email"));
			}else{
				student=null;
			}
		} catch (SQLException e) {
			student=null;
			logger.error(e.getLocalizedMessage());
		}
		return student;
	}
}
