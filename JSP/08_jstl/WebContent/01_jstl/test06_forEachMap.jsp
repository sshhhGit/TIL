<%@page import="java.util.HashMap"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--test06_forEachMap.jsp --%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
  <c:set var="map" value="<%=new HashMap() %>"></c:set>
  
  <c:set target="${map }" property="name" value="홍길동"></c:set>
  <c:set target="${map }" property="id" value="hong"></c:set>
  <c:set target="${map }" property="addr" value="서울 구로구"></c:set>
  <c:forEach var="dto" items="${map }">
    <li>${dto.key } : ${dto.value }
  </c:forEach>
</body>
</html>