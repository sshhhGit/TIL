<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--AdminLogin.jsp --%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="style.css" rel="stylesheet" type="text/css">
<script src="//code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript" src="Ascript.js"></script>
<script type="text/javascript">
	function admincheck() {
		if($('#admin_id').val()==''){
			alert("아이디를 입력하세요");
			$('#admin_id').focus();
			return false;
		}
		if($('#admin_pw').val()==''){
			alert("암호를 입력하세요");
			$('#admin_pw').focus();
			return false;
		}
		document.formName.submit(); //전송
	}
</script>
request.getRealPath: <%=request.getRealPath("/:") %><br>
request.getServletContext().getRealPath("/") : <%=request.getServletContext().getRealPath("/") %><br>
</head>
<body topmargin="20">
  <form action="AdminLoginPro.jsp" method="post" name="formName">
    <table width="50%" border="1">
      <tr>
        <td>관리자 ID</td>
        <td>
          <input type="text" name="admin_id" id="admin_id">
        </td>
      </tr>
      <tr>
        <td>관리자 암호</td>
        <td>
          <input type="password" name="admin_pw" id="admin_pw">
        </td>
      </tr>
      <tr>
        <td colspan="2" align="center">
          <input type="button" value="관리자 로그인" onclick="admincheck()" >
          <input type="reset">
        </td>
      </tr>
    </table>
  </form>

</body>
</html>