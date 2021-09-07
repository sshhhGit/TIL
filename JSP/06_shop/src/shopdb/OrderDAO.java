package shopdb;

import java.sql.*;

import javax.sql.*; //DataSource
import javax.naming.*; //lookup

import com.sun.org.apache.xpath.internal.operations.Or;

import java.util.Vector;

//상품 주문 처리
public class OrderDAO {

	public OrderDAO() {}

	public Connection getConnection() throws Exception{
		Context ct = new InitialContext();
		DataSource ds = (DataSource)ct.lookup("java:comp/env/jdbc/mysql");
		return ds.getConnection();
	}
	
	//----------------------------
	//1. 주문하기, insert
	//----------------------------
	public void insertOrder(OrderDTO dto) throws Exception{
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = getConnection();
			String sql = "insert into shop_order(ordno,userid,pro_no,quantity,orddate,state) values(0,?,?,?,NOW(),?)";
			
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, dto.getUserid());
			pstmt.setInt(2, dto.getPro_no());
			pstmt.setString(3, dto.getQuantity());
			pstmt.setString(4, "1");
			
			pstmt.executeUpdate();
		} catch (Exception ex1) {
			System.out.println("insertOrder() 예외 : " + ex1);
		} finally{
			try {
				if (pstmt != null) {pstmt.close();}
				if (con != null) {con.close();}
			} catch (Exception ex2) {}
		}//finally-end
	}//inserOrder()-end
	//-------------------------
	//2. userid에 해당하는 주문 목록 얻기 
	//-------------------------
	public Vector<OrderDTO> getOrder(String userid) throws Exception{
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "";
		
		Vector<OrderDTO> vec = new Vector<OrderDTO>();
		try {
			con = getConnection();
			sql = "select * from shop_order where userid=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, userid);
			
			rs = pstmt.executeQuery();
			OrderDTO dto = null;
			
			while (rs.next()) {
				dto = new OrderDTO();
				
				//rs내용을 dto넣고, dto는 vec에 넣는다
				dto.setUserid(rs.getString("userid"));
				dto.setQuantity(rs.getString("quantity"));
				dto.setOrddate(rs.getTimestamp("orddate"));
				
				dto.setOrdno(rs.getInt("ordno"));
				dto.setState(rs.getString("state"));
				dto.setPro_no(rs.getInt("pro_no"));
				
				vec.add(dto);
			}//while-end
			
		} catch (Exception ex1) {
			System.out.println("getOrder() 예외 : " + ex1);
		} finally{
			try {
				if (rs != null) {rs.close();}
				if (pstmt != null) {pstmt.close();}
				if (con != null) {con.close();}
			} catch (Exception ex2) {}
		}//finally-end
		return vec;
	}//getOrder-end
	//-------------------------
	//3. 모든 주문 정보 
	//-------------------------
	public Vector getOrderList() throws Exception{
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "";
		
		Vector<OrderDTO> vec = new Vector<OrderDTO>();
		
		try {
			con = getConnection();
			sql = "select * from shop_order order by ordno asc";
			pstmt = con.prepareStatement(sql); //생성시 인자 삽입
			rs = pstmt.executeQuery();
			OrderDTO dto = null;
			
			while (rs.next()) {
				dto = new OrderDTO();
				
				//rs내용을 dto넣고, dto는 vec에 넣는다
				dto.setUserid(rs.getString("userid"));
				dto.setQuantity(rs.getString("quantity"));
				dto.setOrddate(rs.getTimestamp("orddate"));
				
				dto.setOrdno(rs.getInt("ordno"));
				dto.setState(rs.getString("state"));
				dto.setPro_no(rs.getInt("pro_no"));
				
				vec.add(dto);
			}//while-end
			
		} catch (Exception ex1) {
			System.out.println("getOrderList() 예외 : " + ex1);
		} finally{
			try {
				if (rs != null) {rs.close();}
				if (pstmt != null) {pstmt.close();}
				if (con != null) {con.close();}
			} catch (Exception ex2) {}
		}//finally-end
		return vec;
	}//getOrderList()-end
}//class-end
