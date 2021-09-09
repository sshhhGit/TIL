<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--test03_url.jsp --%>

<c:url var="u1" value="../shopping.do"/>

<c:url var="u2" value="../shopping.do">
  <c:param name="id" value="hong"></c:param>
</c:url>

<c:url var="u3" value="../01_jstl/test03_iftag.jsp">
  <c:param name="id" value="hong"></c:param>
  <c:param name="pw" value="p123"></c:param>
</c:url>

<li>${u1}
<li>${u2}
<li>${u3}