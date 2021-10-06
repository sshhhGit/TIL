<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../module/jsp-header.jsp" %>
<%--list.jsp --%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<!-- <script src="//code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript" src="script.js"></script>
<link rel="stylesheet" type="text/css" href="../static/style.css"> -->
</head>
<body>
	<c:if test="${'admin' ne userId}">
		<h1>관리자 권한이 필요합니다</h1>
	</c:if>
	<c:if test="${'admin' eq userId}">
		<h2>회원정보 목록</h2>
		<table border="1">
			<tr>
				<td>번호</td>
				<td>아이디</td>
				<td>비밀번호</td>
				<td>이름</td>
				<td>이메일</td>
				<td>전화번호</td>
				<td>우편번호</td>
				<td>주소</td>
				<td>상세주소</td>
				<td>가입일</td>
				<td>이메일인증</td>
				<td>탈퇴상태</td>
				<td>탈퇴</td>
				<td>복구</td>
			</tr>
			<c:set var="num" value="${1 }" />
			<c:forEach items="${mdto }" var="mdto" varStatus="i">
				<tr>
					<td>${num}</td>
					<td>${mdto.id}</td>
					<td>${mdto.pw}</td>
					<td>${mdto.name}</td>
					<td>${mdto.email}</td>
					<td>${mdto.tel}</td>
					<td>${mdto.zipcode}</td>
					<td>${mdto.addr}</td>
					<td>${mdto.addr2}</td>
					<td>${mdto.regdate}</td>
					<td>${mdto.authStatus}</td>
					<td>${mdto.isDelete}</td>
					<td><input type="button" value="Y" onclick="location.href='adminMemberListPro.do?id=${mdto.id}&isDelete=${mdto.isDelete}'" ></td>
					<td><input type="submit" value="N"></td>
				</tr>
				<c:set var="num" value="${num+1}" />
			</c:forEach>
		</table>
	</c:if>
</body>
</html>