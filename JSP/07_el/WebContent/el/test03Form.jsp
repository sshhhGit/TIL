<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--test03Form.jsp --%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
session.setAttribute("adminId", "admin");
%>
<form action="test03Pro.jsp" method="post">
  <table border="1" align="center">
    <tr>
      <td>이름</td>
      <td><input type="text" name="name" size="30" value="홍길동"></td>
    </tr>
    <tr>
      <td>전화</td>
      <td><input type="text" name="tel" size="14" value="010-1234-1234"></td>
    </tr>
    <tr>
      <td>주소</td>
      <td><input type="text" name="addr" size="50" value="서울시 강남구"></td>
    </tr>
    <tr>
      <td>취미</td>
      <td>
        <input type="checkbox" name="hobby" value="트레킹">트레킹<br>
        <input type="checkbox" name="hobby" value="등산">등산<br>
        <input type="checkbox" name="hobby" value="축구">축구<br>
        <input type="checkbox" name="hobby" value="걷기">걷기<br>
        <input type="checkbox" name="hobby" value="농구">농구<br>
        <input type="checkbox" name="hobby" value="야구">야구<br>
      </td>
    </tr>
    <tr>
      <td colspan="2" align="center">
        <input type="submit" value="전송">
        <input type="reset" value="취소">
      </td>
    </tr>
  </table>
</form>
</body>
</html>