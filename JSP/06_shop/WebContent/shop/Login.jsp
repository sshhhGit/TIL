<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--Login.jsp --%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="style.css" rel="stylesheet" type="text/css">
<script src="//code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript" src="script.js"></script>
</head>
<body bgcolor="#996600" topmargin="100">
  <table width="80%" align="center" bgcolor="#ffff99">
    <tr>
      <td height="190">
        <form action="LoginPro.jsp" name="loginForm" method="post">
          <h2>로그인</h2>
          <table width="60%" align="center" border="1" bgcolor="ivory">
            <tr>
              <td>아이디</td>
              <td><input type="text" name="userId" id="userId"></td>
            </tr>
            <tr>
              <td>패스워드</td>
              <td><input type="password" name="pw" id="pw"></td>
            </tr>
            
            <tr>
              <td colspan="2" align="center">
                <input type="button" value="로그인" onclick="loginCheck()">
                <input type="reset">
              </td>
            </tr>
          </table>
        </form>
      </td>
    </tr>
  </table>

</body>
</html>