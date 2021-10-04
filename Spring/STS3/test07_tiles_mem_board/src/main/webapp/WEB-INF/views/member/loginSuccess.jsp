<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../module/jsp-header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
function updateMember() {
	document.updateForm.action="${ctxpath}/member/editForm.do";
	document.updateForm.submit();
}
function deleteMember() {
	document.delForm.action="deleteMember.do";
	document.updateForm.submit();
}
</script>
</head>
<body>
<h2>${mdto.name }님 저희 홈에 오신것을 환영합니다</h2>
<c:set var="id" value="${mdto.id }" scope="session"/>

<a href="list.do">게시판 목록</a>

<a href="javascript:updateMember()">내정보 수정</a>
<a href="javascript:deleteMember()">회원탈퇴</a>

<a href="logOut.do">로그아웃</a>

<form name="updateForm" method="post">
  <input type="hidden" name="id" value="${id }">
</form>
<form name="delForm" method="post">
  <input type="hidden" name="id" value="${id }">
</form>
</body>
</html>