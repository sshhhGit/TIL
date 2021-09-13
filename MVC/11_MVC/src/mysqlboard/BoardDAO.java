package mysqlboard;
import java.sql.*;
import javax.sql.*;//DataSource
import javax.naming.*;//lookup
import java.util.*;//List, ArrayList
import java.sql.Timestamp;

//DAO : DB처리(비지니스 로직)
public class BoardDAO {
	Connection con=null;
	Statement stmt=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	
	String sql="";
	
	//싱글톤 객체 사용(메모리 절약 효과)
	private static BoardDAO dao=new BoardDAO();//객체생성
	
	private BoardDAO(){}//생성자 , private하면 외부에서 접근 못함 
	
	public static BoardDAO getInstance(){
		return dao;
	}
	
	//커넥션 연결하기 
	private Connection getCon() throws Exception{
		Context ct=new InitialContext();
		DataSource ds=(DataSource)ct.lookup("java:comp/env/jdbc/mysql");
		
		return ds.getConnection();
	}
	
	//-------------------------
	//  원글쓰기, 답글 쓰기 
	//-------------------------
	public void insertBoard(BoardDTO dto) throws Exception{
		int num=dto.getNum();
		int ref=dto.getRef();
		int re_step=dto.getRe_step();
		int re_level=dto.getRe_level();
		
		int number=0;//글 그룹 처리 하기 위한 변수
		try{
			//처리 
			con=getCon();//커넥션 얻기
			
			//최대 글번호 얻기 
			pstmt=con.prepareStatement("select max(num) from board");
			rs=pstmt.executeQuery();//쿼리 수행
			
			if(rs.next()){//글이 존재 하면 
				number=rs.getInt(1)+1;//최대글번호+1,  글 그룹에 사용하려고
			}else{//글이 없을때
				number=1;//처음 글  ref=number;
			}//else end---
			
			if(num!=0){//답글이면
				//답글 끼워넣을 위치 확보 
				sql="update board set re_step=re_step+1 where ref=? and re_step>?";
				pstmt=con.prepareStatement(sql);//생성시 인자 들어간다 
				
				pstmt.setInt(1, ref);//?값 채우기 
				pstmt.setInt(2, re_step);
				
				pstmt.executeUpdate();//쿼리 수행 
				
				//ref=number;
				re_step=re_step+1;
				re_level=re_level+1;
				
				
			}else{//원글이면, 첫번째 글이면
				ref=number;
				re_step=0;
				re_level=0;
			}//else -end
			
			//글쓰기
			sql="insert into board(writer,subject,pw,regdate,"+
			"ref,re_step,re_level,content,ip) "+
			"values(?,?,?,NOW(),?,?,?,?,?)";
			
			pstmt=con.prepareStatement(sql);//생성지 인자 들어간다 
			
			pstmt.setString(1, dto.getWriter());
			pstmt.setString(2, dto.getSubject());
			pstmt.setString(3, dto.getPw());
			
			pstmt.setInt(4, ref);//ref***********
			pstmt.setInt(5, re_step);//**********
			pstmt.setInt(6, re_level);//*********
			
			pstmt.setString(7, dto.getContent());
			pstmt.setString(8, dto.getIp());
			
			pstmt.executeUpdate();
			
		}catch(Exception ex1){
			System.out.println("insertBoard() 예외 :"+ex1);
		}finally{
			try{
				if(rs!=null){rs.close();}
				if(stmt!=null){stmt.close();}
				if(pstmt!=null){pstmt.close();}
				if(con!=null){con.close();}
			}catch(Exception ex2){}
		}//finally-end
		
		
	}//insertBoard() end
	//---------------------
	//글 갯수
	//---------------------
	public int getBoardCount() throws Exception{
		int cnt=-1;//초기화
		
		try{
			//처리
			con=getCon();//커넥션 얻기
			pstmt=con.prepareStatement("select count(*) from board");//생성시 인자 들어간다
			
			rs=pstmt.executeQuery();//쿼리 수행 
			
			if(rs.next()){
				cnt=rs.getInt(1);//1은 필드 번호, 글 갯수 
				System.out.println("cnt:"+cnt);
			}
		}catch(Exception ex1){
			System.out.println("getBoardCount() 예외 :"+ex1);
		}finally{
			try{
				if(rs!=null){rs.close();}
				if(pstmt!=null){pstmt.close();}
				if(con!=null){con.close();}
			}catch(Exception ex2){}
		}//finally end
		
		return cnt;
	}// getBoardCount()
	
	//---------------------
	//리스트
	//---------------------
	public List getList(int startRow, int pageSize) throws Exception{
		//System.out.println("startRow:"+startRow);
		//System.out.println("pageSize:"+pageSize);
		List<BoardDTO> list=null;//변수
        try{
        	//처리
        	con=getCon();
        	sql="select * from board order by ref desc,re_step asc limit ?,?";
        	//                                                          시작,갯수
        	//limit 시작 위치는  0부터 할 것
        	
        	pstmt=con.prepareStatement(sql);//생성시 인자 들어간다 
        	
        	pstmt.setInt(1,startRow-1);//?값채우기 ,0부터 시작
        	pstmt.setInt(2,pageSize);//?값채우기 
        	
        	rs=pstmt.executeQuery();//쿼리 수행 
        	
        	if(rs.next()){
        		list=new ArrayList<BoardDTO>();
        		do{
        			BoardDTO dto=new BoardDTO();//객체 생성
        			
        			dto.setNum(rs.getInt("num"));
        			dto.setWriter(rs.getString("writer"));
        			dto.setSubject(rs.getString("subject"));
        			dto.setPw(rs.getString("pw"));
        			dto.setRegdate(rs.getTimestamp("regdate"));//*****
        			//년월일 시분초: getTimestamp
        			
        			dto.setReadcount(rs.getInt("readcount"));//조횟수 
        			dto.setRef(rs.getInt("ref"));//글 그룹
        			dto.setRe_step(rs.getInt("re_step"));//글 순서
        			dto.setRe_level(rs.getInt("re_level"));//글 깊이
        			
        			dto.setContent(rs.getString("content"));
        			dto.setIp(rs.getString("ip"));
        			
        			list.add(dto);/////////******** 스레드 기능이 없고
        			//vec.add(dto); 스레드 기능이 있다 (채팅에서 사용)
        			
        		}while(rs.next());
        	}//if
        	
        }catch(Exception ex1){
        	System.out.println("getList() 예외 :"+ex1);
        }finally{
        	try{
				if(rs!=null){rs.close();}
				if(pstmt!=null){pstmt.close();}
				if(con!=null){con.close();}
			}catch(Exception ex2){}
        }//finally-end
		
		return list;
	}//getList() - end
	
	//-----------------------
	//글내용보기
	//-----------------------
	public BoardDTO getBoard(int num) throws Exception{
		BoardDTO dto=null;
		try{
			//처리
			con=getCon();
			
			//조횟수 증가
			sql="update board set readcount=readcount+1 where num=?";
			pstmt=con.prepareStatement(sql);
			
			pstmt.setInt(1, num);
			pstmt.executeUpdate();//쿼리 수행 
			//-----------------------------
			
			//글 내용보기
			pstmt=con.prepareStatement("select * from board where num=?");
			pstmt.setInt(1, num);
			rs=pstmt.executeQuery();//쿼리 수행
			
			if(rs.next()){
				//rs내용을 dto넣고 dto를 클라이언트로 보낸다 
				dto=new BoardDTO();//객체생성
				dto.setNum(rs.getInt("num"));
				dto.setWriter(rs.getString("writer"));
				dto.setSubject(rs.getString("subject"));
				dto.setPw(rs.getString("pw"));
				dto.setRegdate(rs.getTimestamp("regdate"));
				
				dto.setReadcount(rs.getInt("readcount"));
				dto.setRef(rs.getInt("ref"));
				dto.setRe_step(rs.getInt("re_step"));
				dto.setRe_level(rs.getInt("re_level"));
				
				dto.setContent(rs.getString("content"));
				dto.setIp(rs.getString("ip"));
				
			}//if-end
		}catch(Exception ex1){
        	System.out.println("getBoard() 예외 :"+ex1);
        }finally{
        	try{
				if(rs!=null){rs.close();}
				if(pstmt!=null){pstmt.close();}
				if(con!=null){con.close();}
			}catch(Exception ex2){}
        }//finally-end
		
		return dto;
	}//getBoard() end
	
	//-----------------------------
	// 글수정 클라이언트로 보낼 데이터 
	//-----------------------------
	public BoardDTO getUpdate(int num) throws Exception{
		BoardDTO dto=null;
		
		try{
		con=getCon();
		//글 내용보기
		pstmt=con.prepareStatement("select * from board where num=?");
		pstmt.setInt(1, num);
		rs=pstmt.executeQuery();//쿼리 수행
		
		if(rs.next()){
			//rs내용을 dto넣고 dto를 클라이언트로 보낸다 
			dto=new BoardDTO();//객체생성
			dto.setNum(rs.getInt("num"));
			dto.setWriter(rs.getString("writer"));
			dto.setSubject(rs.getString("subject"));
			dto.setPw(rs.getString("pw"));
			dto.setRegdate(rs.getTimestamp("regdate"));
			
			dto.setReadcount(rs.getInt("readcount"));
			dto.setRef(rs.getInt("ref"));
			dto.setRe_step(rs.getInt("re_step"));
			dto.setRe_level(rs.getInt("re_level"));
			
			dto.setContent(rs.getString("content"));
			dto.setIp(rs.getString("ip"));
			
		}//if-end
	}catch(Exception ex1){
    	System.out.println("getBoard() 예외 :"+ex1);
    }finally{
    	try{
			if(rs!=null){rs.close();}
			if(pstmt!=null){pstmt.close();}
			if(con!=null){con.close();}
		}catch(Exception ex2){}
    }//finally-end
	
	return dto;
	}//getUpdate() end
	
	//-------------------
	//DB 글수정
	//-------------------
	public int updateBoard(BoardDTO dto) throws Exception{
		String dbPw="";
		int x=-1;
		try{
			//처리
			con=getCon();
			pstmt=con.prepareStatement("select pw from board where num=?");
			pstmt.setInt(1, dto.getNum());//?값 채우기 
			rs=pstmt.executeQuery();//쿼리 수행 
			
			if(rs.next()){
				dbPw=rs.getString("pw");
				String pw=dto.getPw();
				
				if(dbPw.equals(pw)){//암호가 일치하면 글 수정
				  sql="update board set writer=?,subject=?,content=? where num=?";
				  pstmt=con.prepareStatement(sql);//생성시 인자 들어간다 
				  
				  pstmt.setString(1, dto.getWriter());
				  pstmt.setString(2, dto.getSubject());
				  pstmt.setString(3, dto.getContent());
				  pstmt.setInt(4, dto.getNum());
				  
				  pstmt.executeUpdate();//쿼리 수행
				  x=1;//정상적인 수정
				}else{
					//암호가 틀릴때 
					x=0;
				}
			}//if
			
			
		}catch(Exception ex1){
	    	System.out.println("updateBoard() 예외 :"+ex1);
	    }finally{
	    	try{
				if(rs!=null){rs.close();}
				if(pstmt!=null){pstmt.close();}
				if(con!=null){con.close();}
			}catch(Exception ex2){}
	    }//finally-end
		
		return x;
	}//updateBoard() end
	
	//--------------------
	// 글삭제
	//--------------------
	public int deleteBoard(int num,String pw) throws Exception{
		String dbPw="";
		int x=-1;
		
		try{
			//처리
			con=getCon();
			pstmt=con.prepareStatement("select pw from board where num=?");
			pstmt.setInt(1, num);
			
			rs=pstmt.executeQuery();//쿼리 수행 
			if(rs.next()){
				dbPw=rs.getString("pw");
				if(dbPw.equals(pw)){//암호가 일치하면 글 삭제 
					pstmt=con.prepareStatement("delete from board where num=?");
					
					pstmt.setInt(1, num);
					pstmt.executeUpdate();//쿼리 수행
					x=1;//정상적으로 삭제 
					
				}else{//암호가 일치하지 않으면
					x=0;//삭제 실패
				}
			}
			
		}catch(Exception ex1){
			System.out.println("deleteBoard() 예외 :"+ex1);
		}finally{
	    	try{
				if(rs!=null){rs.close();}
				if(pstmt!=null){pstmt.close();}
				if(con!=null){con.close();}
			}catch(Exception ex2){}
	    }//finally-end
		
		return x;
	}//deleteBoard() -end
	
}//class end
