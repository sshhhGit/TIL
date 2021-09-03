package oracleboard;

import java.sql.*;

import javax.sql.*;  	//DataSource
import javax.naming.*; 	//lookup

import java.util.*;		//List, ArrayList

//DAO : Data Access Object = 비지니스 로직 = back end
public class BoardDAO {
	Connection con = null;
	Statement stmt = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	String sql = "";
	
	//싱글톤
	private static BoardDAO dao = new BoardDAO(); //객체생성
	private BoardDAO(){}	//생성자
	public static BoardDAO getInstance(){
		return dao;
	}
	
	//커넥션 연결
	private Connection getConnection() throws Exception{
		Context ct = new InitialContext();
		DataSource ds = (DataSource)ct.lookup("java:comp/env/jdbc/oracle");
		return ds.getConnection();
	}
	
	//-------------------------------
	//글쓰기, 답글쓰기
	//------------------------------
	public void insertBoard(BoardDTO dto) throws Exception{
		int num = dto.getNum();
		int ref = dto.getRef();
		int re_step = dto.getRe_step();
		int re_level = dto.getRe_level();
		
		int number = 0; //글 그룹처리하기위한 변수 ref=number;
		
		try {
			con = getConnection();
			
			//최대 글번호 얻기
			pstmt = con.prepareStatement("select max(num) from board");
			rs = pstmt.executeQuery();
			
			if(rs.next()){ //글이 존재할 때
				number = rs.getInt(1)+1;
			}else{//글이 없을 때, 첫번째 글 일 때
				number = 1; //ref = number
			}
			
			if(num != 0){ //글번호가 존재하면 = 답글이면
				//답글 끼워 넣기 위치 확보
				sql = "update board set re_step=re_step+1 where ref=? and re_step>?";
				pstmt = con.prepareStatement(sql);
				
				pstmt.setInt(1, ref);
				pstmt.setInt(2, re_step);
				
				pstmt.executeUpdate();
				
				//ref = number;
				re_step = re_step+1;
				re_level = re_level+1;
				
				
			}else{ //원글일때
				ref = number;
				re_step = 0;
				re_level = 0;
			}
			
			//글쓰기
			//sql = "insert into board(writer,subject,pw,regdate,ref,re_step,re_level,content,ip) values(?,?,?,NOW(),?,?,?,?,?)";
			sql = "insert into board(num,writer,subject,pw,regdate,ref,re_step,re_level,content,ip) values(board_seq.NEXTVAL,?,?,?,sysdate,?,?,?,?,?)";
			//MySQL : NOW() = 년월일 시분초, curdate() = 년월일 시분초, 
			//Oracle : sysdate = 년월일 시분초	 
			
			pstmt = con.prepareStatement(sql);
			
			//'?' 값 채우기
			pstmt.setString(1, dto.getWriter());
			pstmt.setString(2, dto.getSubject());
			pstmt.setString(3, dto.getPw());
			
			pstmt.setInt(4, ref);
			pstmt.setInt(5, re_step);
			pstmt.setInt(6, re_level);
			
			pstmt.setString(7, dto.getContent());
			pstmt.setString(8, dto.getIp());
			
			pstmt.executeUpdate();
			
		} catch (Exception ex1) {
			System.out.println("insertBoard() 예외  : " + ex1);
		} finally{
			try {
				if(rs != null){rs.close();}
				if(pstmt != null){pstmt.close();}
				if(con != null){con.close();}
			} catch (Exception ex2) {}
		}//finally-end
	}//insertBoard()-end
	//-------------------------------
	//글쓰기, 답글쓰기
	//-------------------------------
	public int getBoardCount() throws Exception{
		int cnt = -100;
		try {
			con = getConnection();
			pstmt = con.prepareStatement("select count(*) from board");
			rs = pstmt.executeQuery();
					
			if(rs.next()){
				cnt = rs.getInt(1);
			}
			
		} catch (Exception ex1) {
			System.out.println("getBoardCount() 예외 : " +ex1);
		} finally{
			try {
				if(rs != null){rs.close();}
				if(pstmt != null){pstmt.close();}
				if(con != null){con.close();}
			} catch (Exception ex2) {}
		}//finally-end
		return cnt;
	}//getBoardCount()-end
	//-------------------------------
	//리스트 글을 10개씩만 클라이어늩로 넘긴다
	//-------------------------------
	public List getList(int startRow, int cnt) throws Exception{
		
		List<BoardDTO> list = null;
		
		try {
			//처리
			con = getConnection();
			//Oracle 서브쿼리
			sql = "select * from(select rownum rnum,num,writer,subject,pw,regdate,readcount,ref,re_step,re_level,content,ip from(select * from board order by ref desc,re_step asc)) where rnum>=? and rnum<?";
			
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, startRow); //1
			pstmt.setInt(2, startRow+cnt); //1+10=11
			
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				list = new ArrayList<BoardDTO>();
				
				do{
					BoardDTO dto = new BoardDTO(); //객체생성
					dto.setNum(rs.getInt("num"));
					dto.setWriter(rs.getString("writer"));
					dto.setSubject(rs.getString("subject"));
					dto.setPw(rs.getString("pw"));
					
					dto.setRegdate(rs.getDate("regdate"));
					
					dto.setReadcount(rs.getInt("readcount"));
					dto.setRef(rs.getInt("ref"));
					dto.setRe_step(rs.getInt("re_step"));
					dto.setRe_level(rs.getInt("re_level"));
					
					dto.setContent(rs.getString("content"));
					dto.setIp(rs.getString("ip"));
					
					list.add(dto);
					
				}while(rs.next());
			}
		} catch (Exception ex1) {
			System.out.println("getList() 예외 : " +ex1);
		} finally{
			try {
				if(rs != null){rs.close();}
				if(pstmt != null){pstmt.close();}
				if(con != null){con.close();}
			} catch (Exception ex2) {}
		}//finally-end
		return list;
	}//getList()-end
	
	/*	 MySQL
	public List getList(int startRow, int count) throws Exception{
		
		List<BoardDTO> list = null;
		
		try {
			con = getConnection();
			sql = "select * from board order by ref desc, re_step asc limit ?,?";
			
			//limit는 시작위치가 0부터
			
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, startRow-1); 
			pstmt.setInt(2, count);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				list = new ArrayList<BoardDTO>();
				
				do{
					BoardDTO dto = new BoardDTO(); //객체생성
					dto.setNum(rs.getInt("num"));
					dto.setWriter(rs.getString("writer"));
					dto.setSubject(rs.getString("subject"));
					dto.setPw(rs.getString("pw"));
					
					dto.setRegdate(rs.getDate("regdate"));
					
					dto.setReadcount(rs.getInt("readcount"));
					dto.setRef(rs.getInt("ref"));
					dto.setRe_step(rs.getInt("re_step"));
					dto.setRe_level(rs.getInt("re_level"));
					
					dto.setContent(rs.getString("content"));
					dto.setIp(rs.getString("ip"));
					
					list.add(dto);
					
				}while(rs.next());
			}
		} catch (Exception ex1) {
			System.out.println("getList() 예외 : " +ex1);
		} finally{
			try {
				if(rs != null){rs.close();}
				if(pstmt != null){pstmt.close();}
				if(con != null){con.close();}
			} catch (Exception ex2) {}
		}//finally-end
		return list;
	}//getList()-end
*/	
	//-------------------------------
	//글 내용 보기
	//-------------------------------
	public BoardDTO getBoard(int num) throws Exception{
		BoardDTO dto = null;
		
		try {
			con = getConnection();
			//조회수 증가
			sql = "update board set readcount=readcount+1 where num=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.executeUpdate(); //쿼리 수행
			//--------------------------------
			
			//글내용보기
			pstmt = con.prepareStatement("select * from board where num=?");
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				dto = new BoardDTO();
				
				dto.setNum(rs.getInt("num"));
				dto.setWriter(rs.getString("writer"));
				dto.setSubject(rs.getString("subject"));
				dto.setPw(rs.getString("pw"));
				
				dto.setRegdate(rs.getDate("regdate")); //***********
				
				dto.setReadcount(rs.getInt("readcount"));
				dto.setRef(rs.getInt("ref"));
				dto.setRe_step(rs.getInt("re_step"));
				dto.setRe_level(rs.getInt("re_level"));
				
				dto.setContent(rs.getString("content"));
				dto.setIp(rs.getString("ip"));
				
			}//if-end
			
		} catch (Exception ex1) {
			System.out.println("getBoard() 예외 : " + ex1);
		} finally{
			try {
				if(rs != null){rs.close();}
				if(pstmt != null){pstmt.close();}
				if(con != null){con.close();}
			} catch (Exception ex2) {}
		}//finally-end
		return dto;
	}//getBoard()-end
	
	//-------------------------
	//글수정 폼으로 
	//-------------------------
	public BoardDTO getUpdate(int num) throws Exception{
		BoardDTO dto = null;
		
		try {
			con = getConnection();
			
			pstmt = con.prepareStatement("select * from board where num=?");
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				dto = new BoardDTO();
				
				dto.setNum(rs.getInt("num"));
				dto.setWriter(rs.getString("writer"));
				dto.setSubject(rs.getString("subject"));
				dto.setPw(rs.getString("pw"));
				
				dto.setRegdate(rs.getDate("regdate")); //***********
				
				dto.setReadcount(rs.getInt("readcount"));
				dto.setRef(rs.getInt("ref"));
				dto.setRe_step(rs.getInt("re_step"));
				dto.setRe_level(rs.getInt("re_level"));
				
				dto.setContent(rs.getString("content"));
				dto.setIp(rs.getString("ip"));
				
			}//if-end
			
		} catch (Exception ex1) {
			System.out.println("getUpdate() 예외 : " + ex1);
		} finally{
			try {
				if(rs != null){rs.close();}
				if(pstmt != null){pstmt.close();}
				if(con != null){con.close();}
			} catch (Exception ex2) {}
		}//finally-end
		return dto;		
	}//getUpdate()-end
	
	//-------------------------
	//DB글 수정
	//-------------------------
	public int updateBoard(BoardDTO dto) throws Exception{
		String dbPw = "";
		int x = -100;
		
		try {
			con = getConnection();
			pstmt = con.prepareStatement("select pw from board where num=?");
			pstmt.setInt(1, dto.getNum());
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				dbPw = rs.getString("pw");
				if (dbPw.equals(dto.getPw())) {//dbPw와 입력 pw가 일치하면
					//글수정
					sql = "update board set writer=?,subject=?,content=? where num=?";
					pstmt = con.prepareStatement(sql); //생성시 인자 발생
					
					//'?' 값 넣기
					
					pstmt.setString(1, dto.getWriter());
					pstmt.setString(2, dto.getSubject());
					pstmt.setString(3, dto.getContent());
					pstmt.setInt(4, dto.getNum());
					
					pstmt.executeUpdate();
					x = 1;
				}else{//dbPw와 입력 pw가 일치하지 않다면
					x = 0; 
				}
			}
		} catch (Exception ex1) {
			System.out.println("updateBoard() 예외 : " + ex1);
		} finally{
			try {
				if(rs != null){rs.close();}
				if(pstmt != null){pstmt.close();}
				if(con != null){con.close();}
			} catch (Exception ex2) {}
		}//finally-end
		return x;
	}//updateBoard()-end
	//-------------------------
	//글 삭제
	//-------------------------
	public int deleteBoard(int num, String pw) throws Exception {
		String dbPw = "";
		int x = -100;
		
		try {
			con = getConnection();
			pstmt = con.prepareStatement("select pw from board where num=?");
			pstmt.setInt(1, num);
			
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				dbPw = rs.getString("pw");
				if(dbPw.equals(pw)){ //암호일치
					//글삭제
					pstmt = con.prepareStatement("delete from board where num=?");
					pstmt.setInt(1, num);
					pstmt.executeUpdate(); //쿼리수행
					x = 1;
				}else{
					x = 0;
				}	
			}//i-end
		} catch (Exception ex1) {
			System.out.println("deleteBoard() 예외 : " + ex1);
		} finally{
			try {
				if(rs != null){rs.close();}
				if(pstmt != null){pstmt.close();}
				if(con != null){con.close();}
			} catch (Exception ex2) {}
		}//finally-end
		return x;
	}//deleteBoard()-end
}//class-end
