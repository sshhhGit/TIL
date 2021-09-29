<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2><center>게시판 글쓰기</center></h2>

<form method="post" action="writePro.do">
  <table border="1" align="center" width="60%">
    <tr>
      <td>글쓴이</td>
      <td><input type="text" name="writer" id="writer" size="30"></td>
    </tr>
    <tr>
      <td>글제목</td>
      <td><input type="text" name="subject" id="subject" size="50"></td>
    </tr>
    <tr>
      <td>글내용</td>
      <td><textarea name="content" id="content" rows="10" cols="50"></textarea></td>
    </tr>
    <tr>
      <td>암호</td>
      <td><input type="password" name="pwd" id="pwd" size="15"></td>
    </tr>
 	<tr>
 	<td colspan="2" align="center">
 	  <input type="submit" value="글쓰기">
 	  <input type="reset">
 	</td>
 	</tr>
  </table>
</form>
</body>
</html>