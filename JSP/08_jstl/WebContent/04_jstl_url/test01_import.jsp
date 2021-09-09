<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--test01_import.jsp --%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%-- <h2>import</h2>
<c:import var="mem_board" url="http://localhost:9000/05_mem_board/mysqlboard/list.jsp"></c:import>
${mem_board }
 --%>
<h3>외부사이트 import</h3>
<c:import var="naver" url="https://www.naver.com/"></c:import>
<div style="height: 500px;overflow: scroll">
${naver }
</div>
</body>
</html>