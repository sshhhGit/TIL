<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="member.*"%>
<%-- loginPro.jsp --%>
<%
request.setCharacterEncoding("UTF-8");
String id = request.getParameter("id");
String pw = request.getParameter("pw");

MemberDAO dao = MemberDAO.getInstance();

int check = dao.loginCheck(id, pw); //dao 메서드 호출

if(check == 1){
	session.setAttribute("id", id);
	response.sendRedirect("main.jsp");
}else if(check == 0){
	%>
	<script type="text/javascript">
	alert("암호가 일치하지않습니다");
	history.back();
	</script>
	<%
}else if(check == -1){
	%>
	<script type="text/javascript">
	alert("존재하지 않는 ID입니다");
	history.back();
	</script>
	<%
}
%>
