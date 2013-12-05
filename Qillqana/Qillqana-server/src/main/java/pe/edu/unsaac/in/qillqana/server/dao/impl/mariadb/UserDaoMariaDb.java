package pe.edu.unsaac.in.qillqana.server.dao.impl.mariadb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import pe.edu.unsaac.in.qillqana.common.model.User;
import pe.edu.unsaac.in.qillqana.server.dao.UserDao;

public class UserDaoMariaDb implements UserDao {
	public static final Logger logger = Logger.getLogger(UserDaoMariaDb.class
			.getName());

	private Connection connection;

	private PreparedStatement insertStatement;
	private PreparedStatement updateStatement;
	private PreparedStatement deleteStatement;
	private PreparedStatement findAllStatement;
	private PreparedStatement findByIdStatement;
	private PreparedStatement findByUserNameStatement;

	public UserDaoMariaDb(Connection connection) {
		this.connection = connection;
		initStatements();
	}

	@Override
	public boolean save(User user) {
		boolean result = true;
		try {
			insertStatement.setString(1, user.getUser());
			insertStatement.setString(2, user.getPassword());
			insertStatement.setString(3, user.getNames());
			insertStatement.setString(4, user.getSurnames());
			insertStatement.setString(5, user.getEmail());
			insertStatement.setString(6, user.getType());
			insertStatement.executeUpdate();
			result = true;
		} catch (SQLException e) {
			result = false;
			logger.error(e);
		}
		return result;
	}

	@Override
	public boolean update(User user) {
		boolean result = true;
		try {
			updateStatement.setInt(1, user.getId());
			updateStatement.setString(2, user.getUser());
			updateStatement.setString(3, user.getPassword());
			updateStatement.setString(4, user.getNames());
			updateStatement.setString(5, user.getSurnames());
			updateStatement.setString(6, user.getEmail());
			updateStatement.setString(7, user.getType());
			updateStatement.executeUpdate();
			result = true;
		} catch (SQLException e) {
			result = false;
			logger.error(e);
		}
		return result;
	}

	@Override
	public boolean delete(User user) {
		boolean result = true;
		try {
			deleteStatement.setInt(1, user.getId());
			deleteStatement.executeUpdate();
			result = true;
		} catch (SQLException e) {
			result = false;
			logger.error(e);
		}
		return result;
	}

	@Override
	public List<User> findAll() {
		List<User> users=new ArrayList<User>();
		try {
			ResultSet result=findAllStatement.executeQuery();
			while (result.next()) {
				User user=new User();
				user.setId(result.getInt("id"));
				user.setUser(result.getString("user"));
				user.setPassword(result.getString("password"));
				user.setNames(result.getString("names"));
				user.setSurnames(result.getString("surname"));
				user.setEmail(result.getString("email"));
				user.setType(result.getString("type"));
				users.add(user);
			}
		} catch (SQLException e) {
			users=null;
			logger.error(e.getLocalizedMessage());
		}
		return users;
	}

	@Override
	public User findById(int id) {
		User user=null;
		try {
			findByIdStatement.setInt(1, id);
			ResultSet result=findByIdStatement.executeQuery();
			if(result.next()){
				user=new User();
				user.setId(result.getInt("id"));
				user.setUser(result.getString("user"));
				user.setPassword(result.getString("password"));
				user.setNames(result.getString("names"));
				user.setSurnames(result.getString("surname"));
				user.setEmail(result.getString("email"));
				user.setType(result.getString("type"));
			}else{
				user=null;
			}
		} catch (SQLException e) {
			user=null;
			logger.error(e.getLocalizedMessage());
		}
		return user;
	}

	@Override
	public User findByUserName(String name) {
		User user=null;
		try {
			findByUserNameStatement.setString(1, name);
			ResultSet result=findByUserNameStatement.executeQuery();
			if(result.next()){
				user=new User();
				user.setId(result.getInt("id"));
				user.setUser(result.getString("user"));
				user.setPassword(result.getString("password"));
				user.setNames(result.getString("names"));
				user.setSurnames(result.getString("surname"));
				user.setEmail(result.getString("email"));
				user.setType(result.getString("type"));
			}else{
				user=null;
			}
		} catch (SQLException e) {
			user=null;
			logger.error(e.getLocalizedMessage());
		}
		return user;
	}
	private void initStatements() {
		try {
			insertStatement = this.connection
					.prepareStatement("INSERT INTO user(user,password,names,surname,email,type) VALUES (?,?,?,?,?,?)");
			updateStatement = this.connection
					.prepareStatement("UPDATE user(id,user,password,names,surname,email,type) SET(?,?,?,?,?,?,?) where id=?");
			deleteStatement = this.connection
					.prepareStatement("DELETE user WHERE id=?");
			findAllStatement = this.connection
					.prepareStatement("SELECT * FROM user");
			findByIdStatement = this.connection
					.prepareStatement("SELECT * FROM user WHERE id=?");
			findByUserNameStatement = this.connection
					.prepareStatement("SELECT * FROM user WHERE user=?");
		} catch (SQLException e) {
			logger.error(e.getLocalizedMessage());
		}
	}
}
