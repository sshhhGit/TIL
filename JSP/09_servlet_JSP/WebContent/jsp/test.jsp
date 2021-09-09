<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--test.jsp --%>
<h3>${user }님 정보</h3>
Id : ${map.id}<br>
Name : ${map.name}<br>
Addr : ${map.addr}<br>
<br>
<br>
<c:forEach var="m" items="${map }">
  ${m.key } : ${m.value }<br>
</c:forEach>