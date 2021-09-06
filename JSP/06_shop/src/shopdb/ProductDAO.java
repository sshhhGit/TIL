package shopdb;

//파일업로드
//jdk/jre/lib/ext/cos.jar
//tomcat/lib/cos.jar
//또는 현재프로젝트/WebContent/WEB-INF/lib/cos.jar
//cos.jar는 상품 없로드 할때 필요
import java.sql.*;

import javax.sql.*; //DataSource

import java.util.*;

import javax.naming.*;  //lookup

import java.io.*; //그림파일 삭제

import com.oreilly.servlet.*;
import com.oreilly.servlet.multipart.*;

import javax.servlet.http.*; //서블릿

public class ProductDAO {
	//싱글톤 객체사용
	private ProductDAO(){}//생성자
	
	private static ProductDAO dao = new ProductDAO(); //객체생성
	
	public static ProductDAO getInstance(){  //JSP에서 사용할 메서드
		return dao;
	}
	
	//--------------------------
	//커넥션 얻기
	//--------------------------
	private Connection getConnection() throws Exception{
		Context ct = new InitialContext();
		DataSource ds = (DataSource)ct.lookup("java:conp/env/jdbc/mysql");
		
		return ds.getConnection();
	}
	
	//--------------------------
	//상품 목록 리스트
	//--------------------------
	
	public List getGoodList() throws Exception{
		String sql = "";
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		List<ProductDTO> list = new ArrayList<ProductDTO>();
		
		try {
			con = getConnection();
			sql = "select * from shop_info";
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				ProductDTO dto = new ProductDTO();
				
				dto.setPro_no(rs.getInt("pro_no"));
				dto.setCode(rs.getString("code"));
				dto.setName(rs.getString("name"));
				
				dto.setPrice(rs.getInt("price"));
				dto.setStock(rs.getInt("stock"));
				
				dto.setDetail(rs.getString("detail"));
				dto.setComp(rs.getString("comp"));
				
				dto.setRegdate(rs.getDate("regdate"));
				dto.setImage(rs.getString("image"));
				
				list.add(dto);
			}//while-end
					
		} catch (Exception ex1) {
			System.out.println("getGoodList() 예외 : " + ex1);
		} finally{
			try {
				if(rs != null){rs.close();}
				if(stmt != null){stmt.close();}
				if(con != null){con.close();}
			} catch (Exception ex2) {}
		}//finally-end
		return list;
	}
	
	
}//class-end
