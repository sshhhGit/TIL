<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--test06_forEach.jsp --%>

<%--
forEach태그는 배열이나 Collection, Map에 저장된 값들을 순차적으로 처리할 때 사용

자바의 for문이나 while, do while등을 대신해서 사용할 수 있다.

형식

<c:forEach var="변수" items="map의 변수">
반복 처리할 내용
</c:forEach>

items에 올 수 있는 것들은 : Map, Colletion등이 있다.
배열인 경우는 기본데이터는 Wrapper class사용하여 처리하게 된다.

Wrapper 클래스 : 기본자료형의 클래스를 말한다
int : Integet
long : Long
double : Double
char : Chracter
short : Short
 --%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>1~10까지 출력</h2>
<c:forEach var="i" begin="1" end="10" step="1">
  ${i }&nbsp;
</c:forEach>
<h2>1~20까지 짝수 출력</h2>
<c:forEach var="j" begin="2" end="20" step="2">
  ${j }&nbsp;
</c:forEach>
<br>
<h2>1~10까지 합구하기</h2>
<c:set var="sum" value="0"></c:set>
<c:forEach var="i" begin="1" end="10">
  ${sum += i }&nbsp;
</c:forEach>

</body>
</html>