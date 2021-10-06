<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../module/jsp-header.jsp" %>
<%--deleteForm.jsp --%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
function pwCheck() {
	if(document.delForm.pw.value==''){
		alert("암호를 입력하세요");
		document.delForm.pw.focus();
		return false;
	}
	return true;
}
</script>
<link rel="stylesheet" type="text/css" href="../static/style.css">
</head>
<body>
<h2>회원탈퇴</h2>
<form action="deleteMember.do" onsubmit="return pwCheck()" name="delForm" method="post">
  <table width="260" border="1">
    <tr height="30">
      <td>비밀번호</td>
      <td>
        <input type="password" name="pw" id="pw" size="15">
        <input type="hidden" name="id" value="${userId }">
      </td>
    </tr>
    <tr>
      <td colspan="2" align="center">
        <input type="submit" value="회원탈퇴">
        <input type="reset" value="취소 " onclick="location='${ctxpath}'">
      </td> 
    </tr>
  </table>

</form>
</body>
</html>