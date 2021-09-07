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
		DataSource ds = (DataSource)ct.lookup("java:comp/env/jdbc/mysql");
		
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
				
				dto.setRegdate(rs.getTimestamp("regdate"));
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
	}//getGoodList()-end
	//--------------------------
	//상품 상세보기
	//--------------------------
	public ProductDTO getDetail(String code) throws Exception{
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "";
		ProductDTO dto = new ProductDTO();
		
		try {
			con = getConnection();
			sql = "select * from shop_info where code='"+code+"'";
			stmt = con.createStatement();//Statement생성
			rs = stmt.executeQuery(sql); //쿼리수행
			
			while(rs.next()){
				//rs결과를 dto에 넣기
				dto.setPro_no(rs.getInt("pro_no"));
				dto.setCode(rs.getString("code"));
				dto.setName(rs.getString("name"));
				
				dto.setPrice(rs.getInt("price"));
				dto.setStock(rs.getInt("stock"));
				
				dto.setDetail(rs.getString("detail"));
				dto.setComp(rs.getString("comp"));
				
				dto.setRegdate(rs.getTimestamp("regdate"));
				dto.setImage(rs.getString("image"));
			}//while-end
			
		} catch (Exception ex1) {
			System.out.println("getDetail() 예외 : " + ex1);
		} finally{
			try {
				if(rs != null){rs.close();}
				if(stmt != null){stmt.close();}
				if(con != null){con.close();}
			} catch (Exception ex2) {}
		}//finally-end
		return dto;
	}//getDetail()-end
	//--------------------------
	//getProduct(int pro_no)
	//pro_no에 해당하는 값들을 frot-end로 보낸다
	//--------------------------
	public ProductDTO getProduct(int pro_no) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		ProductDTO dto = null;
		String sql = "";
		
		try {
			con = getConnection();
			sql = "select * from shop_info where pro_no=?";
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, pro_no);
			rs=pstmt.executeQuery();//쿼리 수행
			
			while(rs.next()){
				dto=new ProductDTO();
				
				//rs내용을 dto에 넣기
				dto.setPro_no(rs.getInt("pro_no"));
				dto.setCode(rs.getString("code"));
				dto.setName(rs.getString("name"));
				
				dto.setPrice(rs.getInt("price"));
				dto.setStock(rs.getInt("stock"));
				
				dto.setDetail(rs.getString("detail"));
				dto.setComp(rs.getString("comp"));
				
				dto.setRegdate(rs.getTimestamp("regdate"));
				dto.setImage(rs.getString("image"));
			}//while-end
		} catch (Exception ex1) {
			System.out.println("getProduct() 예외 : " + ex1);
		} finally{
			try {
				if(rs != null){rs.close();}
				if(pstmt != null){pstmt.close();}
				if(con != null){con.close();}
			} catch (Exception ex2) {}
		}//finally-end
		return dto;
	}//getProduct-end
	//-------------------------
	//남은 물량 계산
	//--------------------------
	public void reduceProduct(OrderDTO dto) throws Exception{
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = getConnection();
			String sql = "update shop_info set stock=(stock-?) where pro_no=?";
			pstmt = con.prepareStatement(sql); //생성 시 인자
			
			pstmt.setString(1, dto.getQuantity());
			pstmt.setInt(2, dto.getPro_no());
			
			pstmt.executeUpdate();
			
		} catch (Exception ex1) {
			System.out.println("reduceProduct() 예외 : " + ex1);
		} finally{
			try {
				if(pstmt != null){pstmt.close();}
				if(con != null){con.close();}
			} catch (Exception ex2) {}
		}//finally-end
	}//reduceProduct()-end
	//----------------------------
	//관리자가 하는 일, 상품등록, insert
	//그림파일 업로드
	//----------------------------
	public boolean insertProduct(HttpServletRequest request){
		boolean re = false;
		Connection con = null;
		PreparedStatement pstmt = null;
		
		//JSP일 경우 : 실제경로 얻기, 그림 등록하기 위해
		//<%=config.getServletContext().getRealPath("/")%>
		//<%=application.getRealPath("/")%>
		
		//서블릿에서 실제 경로 얻기
		//request.getRealPath("/");
		//request.getServletContext().getRealPath("/");
		
		//그림을 웹으로 출력할 때
		//<%=request.getContextPath() %>
		//프로젝트 이름 = 콘텍스트 이름
		try {
			con = getConnection();
			String real_path = request.getServletContext().getRealPath("/");
			String upload_path = real_path + "/imgs/"; //상품등록 경로
			
			//파일 업로드, cos.jar
			MultipartRequest mul = new MultipartRequest(request, upload_path, 5*1024*1024, "UTF-8", new DefaultFileRenamePolicy());
			
			//MySQL : NOW() : 년월일 시분초
			//MySQL : curdate() : 년월일
			//Oracle : sysdate : 년월일 시분초
			
		} catch (Exception ex1) {
			System.out.println("insertProduct() 예외 : " + ex1);
		} finally{
			try {
				if(pstmt != null){pstmt.close();}
				if(con != null){con.close();}
			} catch (Exception ex2) {}
		}//finally-end
		return re;
	}//insertProduct()-end
	//----------------------------
	//관리자가 하는 일, 상품update,
	//그림파일 수정
	//----------------------------

	//----------------------------
	//관리자가 하는 일, 삭제=row=record=행삭제
	//그림파일 삭제
	//----------------------------	
}//class-end
