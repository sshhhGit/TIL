<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../module/jsp-header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- <script type="text/javascript">
function updateMember() {
	document.updateForm.action="${ctxpath}/member/editForm.do";
	document.updateForm.submit();
}
function deleteMember() {
	document.delForm.action="${ctxpath}/member/deleteMember.do";
	document.delForm.submit();
}
</script> -->
</head>
<body>
  <table>
    <tr>
      <td>
        <form action="editForm.do" name="editForm" method="post">
        <input type="hidden" name="id" value="${userId }">
        <input type="submit" value="개인정보 변경">
        </form>
      </td>
      <td>
        <form action="${ctxpath }/member/pwEditForm.do" name="pwEditForm" method="post">
        <input type="hidden" name="id" value="${userId }">
        <input type="submit" value="비밀번호 변경">
        </form>
      </td>
      <td>
        <form action="${ctxpath }/member/deleteForm.do" name="deleteForm" method="post">
          <input type="hidden" name="id" value="${iduserId}">
          <input type="submit" value="회원 탈퇴">
        </form>
      </td>
    </tr>
  </table>
</body>
</html>