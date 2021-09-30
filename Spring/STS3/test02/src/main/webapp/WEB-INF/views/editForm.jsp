<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>editForm</title>
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
<h2>글수정 하기</h2>
<form method="post" action="editPro.do">
  <table border="1">
    <tr>
      <td>글쓴이</td>
      <td>
        <input type="text" name="writer" id="writer" value="${boardDTO.writer }">
        <input type="hidden" name="num" value="${boardDTO.num }">
      </td>
    </tr>
    <tr>
      <td>글제목</td>
      <td>
        <input type="text" name="subject" value="${boardDTO.subject }">
      </td>
    </tr>
    <tr>
      <td>글내용</td>
      <td>
        <textarea name="content" rows="10" cols="50">${boardDTO.content }</textarea>
      </td>
    </tr>
    <tr>
      <td>암호</td>
      <td>
        <input type="password" name="pwd" size="15">
      </td>
    </tr>
    <tr>
      <td colspan="2" align="center">
        <input type="submit" value="글수정">
        <input type="reset">
      </td>
    </tr>
  </table>
</form>
</body>
</html>