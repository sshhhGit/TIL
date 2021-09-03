<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="mysqlboard.*"
    %>
<%--updatePro.jsp --%>
<%
request.setCharacterEncoding("UTF-8");
String pageNum =request.getParameter("pageNum");
%>
<jsp:useBean id="dto" class="mysqlboard.BoardDTO">
  <jsp:setProperty name="dto" property="*"/>
</jsp:useBean>

<%
BoardDAO dao = BoardDAO.getInstance();
int x = dao.updateBoard(dto); //dao메서드 호출, dto넘기기 , 정수값 받기

if(x == 1){ //정상적으로 수정
	response.sendRedirect("list.jsp?pageNum="+pageNum);	
}else if(x == 0){
	%>
	<script>
	alert("암호가 일치하지않습니다")
	history.back();
	</script>
	<%
}
%>