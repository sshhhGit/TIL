<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--test07_tokens.jsp --%>

<%--
forTokens 태그는 java.util.StringTokenizer 클래스는 같은 기능을 제공한다

형식
<c:forTokens var="변수" items="문자열:문자열,,," delims=":">
  ${변수 }<br>
</c:forTokens>
 --%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:forTokens var="str" items="빨강,노랑,파랑/초록/남색" delims=",/">
  ${str }<br>
</c:forTokens>
</body>
</html>