package dao;
import logic.User;

//인터페이스 
public interface UserDao {
 public User findByUserIdAndPassword(String user_id, String password);//추상메서드
}//class-end
