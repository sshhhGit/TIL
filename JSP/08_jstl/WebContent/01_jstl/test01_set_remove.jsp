<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--test01_set_remove.jsp --%>

<%--

변수선언
<c:set var="변수이름" value="정수, 실수, 문자열" scope="page"/>

<c:set var="변수이름" scope="page">
  정수, 실수, 문자열
</c:set>

scope="page" : page는 디폴트이다. page는 생략가능하다

 --%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:set var="num1" value="${20 }"/><br>
<c:set var="num2" value="${30 }"/><br>
<c:set var="num3">
50
</c:set><br>
<c:set var="num4">
5.5
</c:set><br>
<c:set var="str5">
박문수
</c:set><br>
<c:set var="date" value="<%=new Date() %>"/>
<h2>변수값 출력</h2>
num1:${num1 }<br>
num2:${num2 }<br>
num3:${num3 }<br>
num4:${num4 }<br>
str5:${str5 }<br>
날짜:${date }<br>
연산:${num1+num2 }<br><br>

<%--변수 제거 시 반드시 scope부분을 명시 --%>
<c:remove var="num1" scope="page"/>
연산:${num1+num2 }<br><br>
</body>
</html>
