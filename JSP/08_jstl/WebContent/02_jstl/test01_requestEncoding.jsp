<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%-- test01_requsetEncoding.jsp --%>
<%
//request.setCharacterEncoding("UTF-8");
%>
<fmt:requestEncoding value="UTF-8"/>

<c:out value="out태그로 웹 출력하기"></c:out>
<br>

파라미터 값 :  <c:out value="${param.name }"></c:out>
<!-- http://localhost:9000/08_jstl/02_jstl/test01_requestEncoding.jsp -->

<form method="post" action="test01_requestEncoding.jsp">
 이름 : <input type="text" name="name" value="">
 <input type="submit" value="전송">
</form>