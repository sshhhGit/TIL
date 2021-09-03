<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="mysqlboard.*"
    import="java.text.SimpleDateFormat"
    
    %>
<%-- content.jsp --%>
<%
request.setCharacterEncoding("UTF-8");

int num = Integer.parseInt(request.getParameter("num"));
String pageNum = request.getParameter("pageNum");

SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:MM:ss");

BoardDAO dao = BoardDAO.getInstance();
BoardDTO dto = dao.getBoard(num); //dao메서드 호출, num을 넘긴다, dto를 받는다

int ref = dto.getRef();
int re_step = dto.getRe_step();
int re_level = dto.getRe_level();
%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
h2 {
	text-align: center;
}
table {
	margin: auto;
	width: 50%;
	background-color: ivory;
}
</style>
</head>
<body>
<h2>글내용</h2>
  <table border="1">
    <tr>
      <td>글번호</td>
      <td><%=dto.getNum() %></td>

      <td>조회수</td>
      <td><%=dto.getReadcount() %></td>
    </tr>
    <tr>
	  <td>글쓴이</td>
      <td><%=dto.getWriter() %></td>

      <td>작성일</td>
      <td><%=sdf.format(dto.getRegdate()) %></td>

    </tr>
    <tr>
      <td>글제목</td>
      <td colspan="3"><%=dto.getSubject() %></td>
    </tr>
    <tr>
      <td>글내용</td>
      <td colspan="3">
      <textarea rows="10" cols="50" readonly="readonly"><%=dto.getContent() %>
      </textarea>
      </td>
    </tr>
    <tr>
    <td colspan="4" align="center">
      <input type="button" value="글수정" onclick="location='updateForm.jsp?num=<%=num%>&pageNum=<%=pageNum%>'">
      <input type="button" value="글삭제" onclick="location='deleteForm.jsp?num=<%=num%>&pageNum=<%=pageNum%>'">
      
      <input type="button" value="글쓰기" onclick="location='writeForm.jsp?pageNum=<%=pageNum%>'">
      <input type="button" value="답글쓰기" onclick="location='writeForm.jsp?num=<%=num%>&pageNum=<%=pageNum%>&ref=<%=ref%>&re_step=<%=re_step%>&re_level=<%=re_level%>'">
      <input type="button" value="리스트" onclick="location='list.jsp?pageNum=<%=pageNum%>'">
    </td>
    </tr>
  </table>
</body>
</html>