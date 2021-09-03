<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="mysqlboard.*"
    import="java.util.*"%>
<%-- list.jsp --%>
<%
request.setCharacterEncoding("UTF-8");
%>
<%!
//전역변수
int pageSize = 10;
SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:MM:ss");

%>

<%
String pageNum = request.getParameter("pageNum");
if(pageNum == null){
	pageNum = "1";
}
int currentPage = Integer.parseInt(pageNum); //현재페이지
int startRow = (currentPage-1)*pageSize+1;	 //페이지의 시작 글번호

/*
(currentPage-1)*pageSize+1
(1-1)*10+1=1
(2-1)*10+1=11
(3-1)*10+1=21 
*/

int endRow = currentPage*pageSize; //페이지의 끝 글번호

/* 
currentPage*pageSize
1*10=10
2*10=20
3*10=30
 */
 
 int count = 0; 	//총 글 갯수
 int number = 0;	//글 번호를 처리 할 변수
 List<BoardDTO> list = null;  //back-end에서 넘겨준 데이터를 받을 변수
 
 BoardDAO dao = BoardDAO.getInstance();
 
 count = dao.getBoardCount(); //글 갯수 받기
 
 if(count>0){ //글이 존재 할 때
	 list = dao.getList(startRow, pageSize);
	 //					시작위치,    글 갯수
 }//if-end
 
 number = count-(currentPage-1)*pageSize;//보여준 글 번호
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>list.jsp</title>
<style type="text/css">
h2 {
	text-align: center;
}
table {
	margin: auto;
	width: 70%;
}
</style>
</head>
<body>
<h2>글목록(전체 글 수 : <%=count %>)</h2>
<table>
  <tr>
    <td align="right">
      <a href="writeForm.jsp">글쓰기</a>
    </td>
  </tr>
</table>

	<%
	if(count == 0){//글이 없다면
		out.println("<h2>등록된 글이 없습니다</h2>");
	}else{
		%>
		<table border="1">
		  <tr>
		    <th>글번호</th>
		    <th>글제목</th>
		    <th>글쓴이</th>
		    <th>작성일</th>
		    <th>조회수</th>
		    <th>ip</th>
		  </tr>
		  <%
		  for(int i=0;i<list.size();i++){
			  BoardDTO dto = (BoardDTO)list.get(i);
			  %>
			  <tr>
			    <td><%=number-- %></td>
			    <%--글제목 시작 --%>
			    <td>
			    <%
			    //답글 들여쓰기
			    int wid = 0;
			    if(dto.getRe_level()>0){
			    	wid=5*dto.getRe_level();
			    %>
			    <img alt="" src="../imgs/level.gif" width="<%=wid%>" height="16">
			    <img alt="" src="../imgs/re.gif">
			    <%
			    }else{ //원글일 때
			    	%>
			    	<img alt="" src="../imgs/level.gif" width="<%=wid%>" height="16">
			    	<%
			    }//else-end
			    %>
			    <%-- 제목을 클릭하면 글내용보기 --%>
			    <a href="content.jsp?num=<%=dto.getNum()%>&pageNum=<%=pageNum%>">
			    <%=dto.getSubject() %>
			    </a>
			    <%
			    //조회수가 20번 이상이면 hot.gif 출력
			    if(dto.getReadcount()>=20){
			    	%>
			    	<img alt="" src="../imgs/hot.gif" height="10" border="0">
			    	<%
			    }//if-end
			    %>
			    </td>
			    <%--글제목 끝 --%>
			    <td><%=dto.getWriter() %></td>
			    <td><%=sdf.format(dto.getRegdate()) %></td>
			    <td><%=dto.getReadcount() %></td>
			    <td><%=dto.getIp() %></td>
			  </tr>
			  <%
		  }//for-end
		  //1차실행
		  %>
		</table>
		<%
	}//else-end
	%>
	<%
	//블럭처리, 페이지처리
	if(count>0){
		%>
		<table border="1">
		  <tr>
		    <td align="center">
		      <%
		      int pageCount = count/pageSize+(count%pageSize==0?0:1);
		      int pageBlock = 10; //블럭당 페이지 수 10개
		      
		      int startPage = (int)(currentPage/pageBlock)*10+1; //시작페이지 구하기
		      //(currentPage/pageBlock)*10+1;
		      //(1/10)*10+1=1
		      //(5/10)*10+1=1
		      //(9/10)*10+1=1
		      
		      //(10/10)*10+1=11
		      //(15/10)*10+1=11
		      //(19/10)*10+1=11
		      
		      //(20/10)*10+1=21
		      //(29/10)*10+1=21
		      
		      int endPage = startPage+pageBlock-1; //끝 페이지
		      //startPage+pageBlock-1
		      //1+10-1=10
		      //11+10-1=20
		      //21+10-1=30
		      
		      //에러 방지
		      if(endPage>pageCount){
		    	  endPage = pageCount;
		      }
		      
		      //이전블록
		      if(startPage>10){
		       %>
		       <a href="list.jsp?pageNum=<%=startPage-10%>">
		       [이전블럭]
		       </a>
		       <%
		      }//if-end
		      
		      //페이지 처리
		      for(int i=startPage; i<=endPage; i++){
		    	  %>
		    	  <a href="list.jsp?pageNum=<%=i%>">
		    	  [<%=i %>]
		    	  </a>
		    	  <%
		      }//for-end
		      
		      //다음 블럭
		      if(endPage<pageCount){
		    	  %>
		    	  <a href="list.jsp?pageNum=<%=startPage+10%>">
		       	   [다음블럭]
		          </a>
		    	  <%
		      }//if-end
		      %>
		      
		      
		    </td>
		  </tr>
		</table>
		<%
	}
	%>
</body>
</html>