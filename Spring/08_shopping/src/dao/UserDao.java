package dao;

import logic.User;

public interface UserDao {

	public User findByUserIdAndPassword(String user_id, String password);

}
