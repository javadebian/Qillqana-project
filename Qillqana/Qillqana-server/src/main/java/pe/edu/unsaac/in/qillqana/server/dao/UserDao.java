package pe.edu.unsaac.in.qillqana.server.dao;

import java.util.List;

import pe.edu.unsaac.in.qillqana.common.model.User;

public interface UserDao {
	public boolean save(User user);
    public boolean update(User user);
    public boolean delete(User user);
    public List<User> findAll();
    public User findById(int id);
    public User findByUserName(String name);
}
