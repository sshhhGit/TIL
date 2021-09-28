package logic;

import dao.UserDao;

//구현클래스
public class UserCatalogImpl implements UserCatalog{
	private UserDao userDao;
	
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public User getUserIdandPwd(String user_id, String password) {
		// TODO Auto-generated method stub
		return userDao.findByUserIdAndPassword(user_id, password);
	}

}
