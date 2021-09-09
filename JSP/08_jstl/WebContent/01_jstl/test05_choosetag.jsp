<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--test05_choosetag.jsp --%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>choose 태그 실습</h2>

<c:choose>
  <c:when test="${param.id=='park' }">
    <li> ID : ${param.id }
  </c:when>
  <c:when test="${param.name=='박문수' }">
    <li> 이름 : ${param.name }
  </c:when>
  <c:otherwise>
    <li>당신의 ID는 park도 아니고<br>
    <li>이름도 틀립니다<br>
    <li>파라미터값이 없습니다<br>
  </c:otherwise>
</c:choose>
<%-- http://localhost:9000/08_jstl/01_jstl/test05_choosetag.jsp?id=park&name=박문수 --%>
</body>
</html>