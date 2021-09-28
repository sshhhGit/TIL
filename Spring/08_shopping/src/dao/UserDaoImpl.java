package dao;

import logic.User;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;

public class UserDaoImpl implements UserDao {
	private SimpleJdbcTemplate template;
	
	//setter
	public void setTemplate(SimpleJdbcTemplate template) {
		this.template = template;
	}

	@Override
	public User findByUserIdAndPassword(String user_id, String password) {
		String sql = "select * from user_account where user_id=? and password=?";
		
		/**
		BeanPropertyRowMapper 클래스는 테이블의 컬럼이름과 User(DTO=VO).class 대응(매핑)시켜 값을 지정합니다.
		*/
		
		RowMapper<User> mapper = new BeanPropertyRowMapper<User>(User.class);
		
		return this.template.queryForObject(sql, mapper, user_id, password);
	}
}
