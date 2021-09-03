<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="mysqlboard.*"%>
<%--deletePro.jsp --%>

<%
request.setCharacterEncoding("UTF-8");
String pageNum = request.getParameter("pageNum");
int num = Integer.parseInt(request.getParameter("num"));
String pw = request.getParameter("pw");

BoardDAO dao = BoardDAO.getInstance();
int x = dao.deleteBoard(num, pw); //dao메서드 호출

if(x == 1){
	response.sendRedirect("list.jsp?pageNum="+pageNum);
}else if(x == 0){
	%>
	<script type="text/javascript">
	alert("암호가 일치하지않습니다")
	history.back();
	</script>
	<%
}
%>
