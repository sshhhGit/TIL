<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="insertProc.do" method="post">
  <table border="1" align="center" width="50%">
    <tr>
      <td colspan="2" align="center">
      <font size="5">[글쓰기]</font>
      </td>
    </tr>
    <tr>
      <td>글제목</td>
      <td><input type="text" name="subject" placeholder="글제목 입력"></td>
    </tr>
    <tr>
      <td>작성자</td>
      <td><input type="text" name="writer" placeholder="글쓴이 입력"></td>
    </tr>
    <tr>
      <td>글내용</td>
      <td><textarea rows="10" cols="50" name="content"></textarea></td>
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