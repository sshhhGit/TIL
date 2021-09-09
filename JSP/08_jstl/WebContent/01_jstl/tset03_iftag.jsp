<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--test03_iftag --%>

<%--
<c:if test="조건">
 조건이 참일때 처리
</c:if>

예를 들어
<c:if test="${true}">
무조건 실행<br>
무조건 실행<br>
무조건 실행<br>
</c:if>

 --%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:if test="${true}">
무조건 실행<br>
무조건 실행<br>
무조건 실행<br>
</c:if>
<c:if test="${param.name=='park' }">
  ${param.name}님 환영합니다.<br>
</c:if>
<c:if test="${param.pw=='p123' }">
  암호는${param.pw }입니다.<br>
</c:if>
</body>
</html>