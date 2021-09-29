<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>list.jsp</title>
</head>
<body>
</body>
<h2><center>글목록</center></h2>
<table border="1" align="center">
    <tr bgcolor="yellow">
      <td>글쓴이</td>
      <td>글제목</td>
      <td>날짜</td>
      <td>조회수</td>
    </tr>
  <c:forEach var="dto" items="${list }">
    <tr>
      <td>${dto.writer}</td>
      <td>
        <a href="content.do?num=${dto.num }">
        ${dto.subject}
        </a>
      </td>
      <td>
        <fmt:formatDate value="${dto.wdate}" type="date"/>
      </td>
      <td>${dto.readcount}</td>
      
    </tr>
  </c:forEach>
</table>
</html>