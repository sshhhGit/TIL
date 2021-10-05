<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../module/jsp-header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
h2{
	text-align: center;
}
table {
	margin: auto;
	line-height: 30px;
	background-color: #FFEFD5;
}
</style>
<script type="text/javascript">
  function check() {
	  if (document.loginForm.id.value=='') {
		  alert("ID를 입력하세요");
		  document.loginForm.id.focus();
		  return false;
	}
	  if (document.loginForm.pw.value=='') {
		  alert("암호를 입력하세요");
		  document.loginForm.pw.focus();
		  return false;
	}
	return true;
}
</script>
</head>
<body>
<h2>로그인</h2>

  <c:if test="${!msg.equals(null) }">
    <font color="red">
      ${msg }
    </font>
  </c:if>

  <form name="loginForm" method="post" action="loginPro.do" onsubmit="return check()">
    <table border="1">
      <tr>
        <td>ID</td>
        <td>
          <input type="text" name="id" id="id" size="20">
        </td>
      </tr>
      <tr>
        <td>암호</td>
        <td>
          <input type="password" name="pw" id="pw" size="20">
        </td>
      </tr>
      <tr>
        <td colspan="2" align="center">
          <input type="submit" value="로그인">
          <input type="reset" value="다시입력">
        </td>
      </tr>
    </table>
  </form>
</body>
</html>