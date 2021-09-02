<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- deleteForm.jsp --%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>deleteForm.jsp</title>
<script type="text/javascript">
  function begin() {
	var ff = eval(document.delForm);
	ff.pw.focus()
}
  function check() {
	var ff = eval(document.delForm);
	if(!ff.pw.value){
		alert("암호를 입력하세요");
		ff.pw.focus()
		return false;
	}
	return true;
}
</script>
<style type="text/css">
h2 {
	text-align: center;
}
table {
	margin: auto;
	width: 30%;
}
</style>
</head>
<body onload="begin()">
  <form action="deletePro.jsp" name="delForm" method="post" onsubmit="return check()">
    <table border="1">
      <tr>
        <td>암호</td>
        <td><input type="password" name="pw" size="15">
        </td>
      </tr>
      <tr>
        <td colspan="2" align="center">
           <input type="submit" value="회원탈퇴">
           <input type="button" value="취소" onclick="location='main.jsp'">
        </td>
      </tr>
    </table>
  </form>
</body>
</html>