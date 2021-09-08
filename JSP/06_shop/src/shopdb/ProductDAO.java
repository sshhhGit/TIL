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
			String upload_path = real_path + "/imgs/";
			
			//파일 업로드, cos.jar
			MultipartRequest mul = new MultipartRequest(request, upload_path, 5*1024*1024, "UTF-8", new DefaultFileRenamePolicy());
			
			//MySQL : NOW() : 년월일 시분초
			//MySQL : curdate() : 년월일
			//Oracle : sysdate : 년월일 시분초
			
			String sql = "insert into shop_info (pro_no,code,name,price,stock,detail,comp,regdate,image) values(0,?,?,?,?,?,?,NOW(),?)";
			
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, mul.getParameter("code"));
			pstmt.setString(2, mul.getParameter("name"));
			pstmt.setInt(3, Integer.parseInt(mul.getParameter("price")));
			pstmt.setInt(4, Integer.parseInt(mul.getParameter("stock")));
			pstmt.setString(5, mul.getParameter("detail"));
			pstmt.setString(6, mul.getParameter("comp"));
			
			System.out.println("image: "+mul.getParameter("image"));
			
			if(mul.getFilesystemName("image") != null){ //이미지가 있으면
				pstmt.setString(7, mul.getFilesystemName("image"));
			}else{  //이미지가 없으면
				pstmt.setString(7, "ready.gif");
			}
			//pstmt.setString(7, mul.getParameter("image"));
			
			
			int count = pstmt.executeUpdate();
			
			if(count == 1){
				re = true;
			}
			
			
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
	public boolean updateProduct(HttpServletRequest request){
		Connection con = null;
		PreparedStatement pstmt = null;
		boolean re = false;
		String sql = "";
		
		try {
			con = getConnection();
			String real_path = request.getServletContext().getRealPath("/");
			String upload_path = real_path + "/imgs/";
			int size = 5*1024*1024;
			
			//그림파일 올리기 = 파일 업로드
			MultipartRequest mul = new MultipartRequest(request, upload_path, size, "UTF-8", new DefaultFileRenamePolicy());
			
			if(mul.getFilesystemName("image") == null){
				//그림파일이 없으면
				sql = "update shop_info set code=?,name=?,stock=?,detail=?,price=?,comp=? where pro_no=?";
				
				pstmt = con.prepareStatement(sql);
				
				//'?'값 채우기
				pstmt.setString(1, mul.getParameter("code"));
				pstmt.setString(2, mul.getParameter("name"));
				pstmt.setInt(3, Integer.parseInt(mul.getParameter("stock")));
				pstmt.setString(4, mul.getParameter("detail"));
				pstmt.setInt(5, Integer.parseInt(mul.getParameter("price")));
				pstmt.setString(6, mul.getParameter("comp"));
				pstmt.setInt(7, Integer.parseInt(mul.getParameter("pro_no")));
				
				
				
			}else{
				//새로운 이미지로 바꿀 때, 이전 이미지 삭제
				int im = Integer.parseInt(mul.getParameter("pro_no"));
				
				String sql2 = "select image from shop_info where pro_no="+im;
				
				Statement stmt = con.createStatement(); //생성
				ResultSet rs = stmt.executeQuery(sql2);
				
				if(rs.next()){ //이미지가 존재하면, 이미지 삭제
					File f = new File(upload_path+rs.getString("image"));
					if(f.isFile()){ //파일이 존재한다면 삭제
						f.delete(); //삭제
					}//if-end
				}//if-end
				
				rs.close();
				stmt.close();
				
				//update구문 작성
				sql = "update shop_info set code=?,name=?,stock=?,price=?,detail=?,comp=?,image=? where pro_no=?";
				
				pstmt = con.prepareStatement(sql); //생성시 인자 들어감
				
				pstmt.setString(1, mul.getParameter("code"));
				pstmt.setString(2, mul.getParameter("name"));
				pstmt.setInt(3, Integer.parseInt(mul.getParameter("stock")));
				pstmt.setInt(4, Integer.parseInt(mul.getParameter("price")));
				pstmt.setString(5, mul.getParameter("detail"));
				pstmt.setString(6, mul.getParameter("comp"));
				pstmt.setString(7, mul.getFilesystemName("image"));
				pstmt.setInt(8, Integer.parseInt(mul.getParameter("pro_no")));
			
			}//else-end
			
			int count = pstmt.executeUpdate(); //쿼리수행
			
			if(count == 1){
				re = true;
			}
		} catch (Exception ex1) {
			System.out.println("updateProduct() 예외 : " + ex1);
		} finally{
			try {
				if(pstmt != null){pstmt.close();}
				if(con != null){con.close();}
			} catch (Exception ex2) {}
		}//finally-end
		return re;
	}//updateProduct()-end

	//----------------------------
	//관리자가 하는 일, 삭제=row=record=행삭제
	//그림파일 삭제
	//----------------------------
	public boolean deleteProduct(HttpServletRequest request, int pro_no){
		Connection con = null;
		PreparedStatement pstmt = null;
		boolean re = false;
		//String sql = "";
		
		try {
			con = getConnection();
			//그림파일 삭제
			String sql2 = "select image from shop_info where pro_no="+pro_no;
			String real_path = request.getServletContext().getRealPath("/");
			String upload_path = real_path+"/imgs/";
			
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql2);
			
			if(rs.next()){
				File f = new File(upload_path+rs.getString("image"));
				if(f.isFile()){
					f.delete();
				}
			}
			rs.close();
			stmt.close();
			//그림파일 삭제 - end
			//DB테이블 row = record 삭제
			
			String sql = "delete from shop_info where pro_no=?";
			pstmt = con.prepareStatement(sql);
			
			//'?'값 채우기
			pstmt.setInt(1, pro_no);
			
			int count = pstmt.executeUpdate();
			
			if(count==1){
				re = true;
			}
			
		} catch (Exception ex1) {
			System.out.println("deleteProduct() 예외 : " + ex1);
		} finally{
			try {
				if(pstmt != null){pstmt.close();}
				if(con != null){con.close();}
			} catch (Exception ex2) {}
		}//finally-end
		return re;
	}//deleteProduct()-end
}//class-end
