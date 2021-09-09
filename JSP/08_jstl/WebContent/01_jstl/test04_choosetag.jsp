<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--test04_choosetag.jsp --%>

<%--
◆choose태그는 : java의 switch ~ case와 유사화다 (break)

◆형식
<c:choose>

  <c:when test="${조건1 }">
  조건1참일 때 처리
  </c:when>

  <c:when test="${조건2 }">
  조건2참일 때 처리
  </c:when>

  <c:when test="${조건3 }">
  조건3참일 때 처리
  </c:when>
  
  <c:otherwise>
  위의 사항의 만족한고건이 없을 때 처리(기타처리)
  </c:otherwise>
</c:choose>

 --%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:choose>

  <c:when test="${true }">
  조건1참일 때 처리
  </c:when>

  <c:when test="${true }">
  조건2참일 때 처리
  </c:when>

  <c:when test="${true }">
  조건3참일 때 처리
  </c:when>
  
  <c:otherwise>
  위의 사항의 만족한고건이 없을 때 처리(기타처리)
  </c:otherwise>
</c:choose>
</body>
</html>