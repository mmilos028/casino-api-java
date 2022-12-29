package api.casino.dao;

import java.util.List;

import api.casino.entity.User;

public interface UserDao {

	public Long addUser(User u);
	public void updateUser(User u);
	public List<User> listUsers();
	public User getUserById(int id);
	public void removeUser(int id);
}
