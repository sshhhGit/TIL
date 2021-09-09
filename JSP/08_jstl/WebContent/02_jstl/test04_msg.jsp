<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!-- #messege_ko.properties
TITLE = 홍길동의 JSP 3.0 배우기
GREETING = 안녕하세요. 홍길동입니다.
VISITOR = 당신의 아이디는 {0}입니다. -->
<%-- test03_msg.jsp --%>
<html>
<head>
</head>
<body>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<fmt:bundle basename="resource.message">
 <fmt:message var="title" key="TITLE"></fmt:message>
  <h2>${title }</h2><br>
  <fmt:message key="GREETING"></fmt:message><br>
  <c:if test="${!empty param.id }">
    <fmt:message key="VISITOR">
      <fmt:param value="${param.id}"></fmt:param>  
    </fmt:message><br>
  </c:if>
</fmt:bundle>
</body>
</html>