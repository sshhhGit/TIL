<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%-- test03_timeZone.jsp --%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
  <h2>timeZone</h2>
  <c:set var="date" value="<%=new java.util.Date() %>"></c:set>
  Korea KST : 
  <fmt:formatDate value="${date }" type="both" dateStyle="full" timeStyle="full"/>
  <br>
  UK GMT : 
  <fmt:timeZone value="GMT">
    <fmt:formatDate value="${date }" type="both" dateStyle="full" timeStyle="full"/>
  </fmt:timeZone>
  
  <%--
  timeZone이란 각 나라별 시간대를 나타낸다
  <fmt:formatDate value="${date }" ..../> 이렇게 사용하여 우리나라 시간을 표시
  
  <fmt:timeZone value="GMT">를 사용하여 영국 시간대를 표시한다
  
  화이트박스 테스트 프로그램 로직 테스트
  블랙박스 테스트 기능 테스트
  
   --%>
</body>
</html>