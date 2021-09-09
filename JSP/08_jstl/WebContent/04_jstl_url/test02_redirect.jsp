<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--test02_redirect.jsp --%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
//response.sendRedirect(request.getContextPath()+"/tset03_iftag.jsp");

%>
<c:redirect url="/01_jstl/tset03_iftag.jsp">
  <c:param name="name" value="hong"/>
  <c:param name="pw" value="p123"/>
</c:redirect>
</body>
</html>