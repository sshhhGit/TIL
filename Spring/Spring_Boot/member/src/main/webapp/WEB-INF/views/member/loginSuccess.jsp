<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>loginSuccess.jsp</title>

<script>
  function updateMember(){
	  document.updateForm.action="memUpdateForm.do";//내정보 수정 
	  document.updateForm.submit();//서버로 전송 
  }
  
  function deleteMember(){
	  document.delForm.action="deleteMember.do";//탈퇴
	  document.delForm.submit();
  }
</script>

</head>
<body>
<h2>${mdto.name}님 저희 홈페이지에 오신것을 환영합니다</h2>

<c:set var="id" value="${mdto.id}" scope="session"/>

<a href="list.do">게시판 목록</a>

<a href="javascript:updateMember()">내정보 수정</a>
<a href="javascript:deleteMember()">탈퇴</a>
<a href="logOut.do">로그아웃</a>

<form name="updateForm" method="post">
  <input type="hidden" name="id" value="${id}">
</form>

<form name="delForm" method="post">
  <input type="hidden" name="id" value="${id}">
</form>

<script>
if (self.name != 'reload') {
    self.name = 'reload';
    self.location.reload(true);
}
else {
	self.name = ''; 
}
</script>
</body>
</html>