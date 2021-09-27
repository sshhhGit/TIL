package dao;

import java.util.List;

import logic.ItemDTO;
import javax.sql.DataSource;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;

public class ItemDaoImpl implements ItemDao{
	private SimpleJdbcTemplate template; //변수 : DB연결, PreparedStatment, DB끊는것, 예외처리 담당
	
	public void setDataSource(DataSource dataSource) {
		this.template = new SimpleJdbcTemplate(dataSource);
		
	}

	@Override
	public List<ItemDTO> findAll() {
		String select_ALL = "select * from item";
		
		RowMapper<ItemDTO> mapper = new BeanPropertyRowMapper<ItemDTO>(ItemDTO.class);
		
		return this.template.query(select_ALL, mapper);
	}

	
}
