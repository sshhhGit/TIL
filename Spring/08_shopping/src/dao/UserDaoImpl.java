package dao;

import logic.User;

import javax.sql.DataSource;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;

//dao 구현 클래스 
public class UserDaoimpl implements UserDao{
	
	private SimpleJdbcTemplate template;//변수
 	
	//setter메서드 
	public void setTemplate(SimpleJdbcTemplate template) {
		this.template = template;
	}



	@Override
	public User findByUserIdAndPassword(String user_id, String password) {
		String sql="select * from user_account where user_id=? and password=?";
		
		//BeanPropertyRowMapper클래스는 
		//테이블의 칼럼이름과 User(DTO=VO)클래스 필드이름이 대응(맵핑)시켜
		//값을 지정합니다 
		
		RowMapper<User> mapper=
				new BeanPropertyRowMapper<User>(User.class);
		
		
		
		return this.template.queryForObject(sql, mapper, user_id,password);
	}

}//class-end
