<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- main.jsp --%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
if(session.getAttribute("id")==null){
	//로그인 하지 않은 상태
	%>
	<table width="90%" height="90%" align="center" cellspacing="0">
	  <tr bgcolor="ivory">
	    <td align="left">
	      <a href="main.jsp"><img src="../imgs/logo.jpg" width="100"></a>
	    </td>
	    
	    <td>
	    <a href="">상품목록</a>&nbsp;
	    <a href="">구매목록</a>&nbsp;
	    <a href="">Q&A</a>&nbsp;
	    <a href="">FAQ</a>&nbsp;
	    </td>
	    
	    <td height="15%" align="right">
	      <jsp:include page="loginForm.jsp"></jsp:include>
	    </td>
	  </tr>
	  
	  <tr>
	    <td colspan="2">
	        메인
	    </td>
	  </tr>
	</table>
	<%
}else{
	%>
	<table width="90%" height="90%" align="center" cellspacing="0">
	  <tr height="10%" bgcolor="ivory">
	    <td align="left">
	      <a href="main.jsp"><img src="../imgs/logo.jpg" width="100"></a>
	    </td>
	    
	    <td>
	    <a href="">상품목록</a>&nbsp;
	    <a href="">구매목록</a>&nbsp;
	    <a href="">Q&A</a>&nbsp;
	    <a href="">FAQ</a>&nbsp;
	    </td>
	    <td width="30%" colspan="2" valign="top">
	    <%
	    String id=(String)session.getAttribute("id");
	    %>
	    <%=id %>님 방문을 환영합니다<br>
	      <form method="post" action="logOut.jsp">
	        <input type="submit" value="로그아웃">
	        <input type="button" value="회원정보변경" onclick="location='modify.jsp'">
	      </form>
	    </td>
	  </tr>
	  
	  <tr>
	    <td colspan="2">
	      	메인
	    </td>
	  </tr>
	</table>
	<%	
}//else-end
%>
</body>
</html>