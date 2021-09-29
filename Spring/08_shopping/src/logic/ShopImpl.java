package logic;

//구현 클래스 
public class ShopImpl implements Shop{

	//변수
	private UserCatalog userCatalog;
	
	//setter메서드 
	public void setUserCatalog(UserCatalog userCatalog) {
		this.userCatalog = userCatalog;
	}

	
	@Override
	public User getUserByIdandPwd(String user_id, String password) {
		
		return userCatalog.getUserIdandPwd(user_id, password);
	}

	
}//class-end
