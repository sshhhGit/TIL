package logic;
import dao.UserDao;

//구현 클래스
public class UserCatalogImpl implements UserCatalog{
    private UserDao userDao;//변수

    //setter 메서드 
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}


	@Override
	public User getUserIdandPwd(String user_id, String password) {
		
		return userDao.findByUserIdAndPassword(user_id, password);
	}

}
