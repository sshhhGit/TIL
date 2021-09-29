<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
table {
	width: 70%;
	margin: auto;
}
h2 {
	text-align: center;
}
</style>
</head>
<body>
<h2>글내용 보기</h2>
<table>
  <tr>
    <td height="40px" align="right">
      <a href="editForm.do?num=${boardDTO.num }">글수정</a>&nbsp;&nbsp;
      <a href="delete.do?num=${boardDTO.num }">글삭제</a>&nbsp;&nbsp;
      <a href="writeForm.do?num=${boardDTO.num }">글쓰기</a>&nbsp;&nbsp;
      <a href="list.do">리스트</a>&nbsp;&nbsp;
    </td>
  </tr>
  <table border="1" bgcolor="ivory">
    <tr>
      <td>글쓴이</td>
      <td>${boardDTO.writer }</td>
    </tr>
    <tr>
      <td>글제목</td>
      <td>${boardDTO.subject }</td>
    </tr>
    <tr>
      <td>글쓴이</td>
      <td><pre>${boardDTO.content }</pre></td>
    </tr>
    <tr>
      <td>날짜</td>
      <td><fmt:formatDate value="${boardDTO.wdate }" pattern="yyyy년MM월dd일"/></td>
    </tr>
    <tr>
      <td>조회수</td>
      <td>${boardDTO.readcount }</td>
    </tr>
  </table>
</table>
</body>
</html>