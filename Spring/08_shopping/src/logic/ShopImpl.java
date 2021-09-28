package logic;

public class ShopImpl implements Shop{
	private UserCatalog userCatalog;
	
	public void setUserCatalog(UserCatalog userCatalog) {
		this.userCatalog = userCatalog;
	}

	@Override
	public User getUserByIdandPwd(String user_id, String password) {
		// TODO Auto-generated method stub
		
		return userCatalog.getUserIdandPwd(user_id, password);
	}

}
