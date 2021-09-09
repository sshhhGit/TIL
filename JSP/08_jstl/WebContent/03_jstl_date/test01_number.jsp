<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%-- test01_number.jsp --%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>숫자 출력</h2>
<fmt:formatNumber value="12345.678" type="number"/>

<h2>pattern</h2>
<fmt:formatNumber value="12345.678" pattern=".0"></fmt:formatNumber>
 
<h2>통화기호</h2>
<fmt:formatNumber value="12345.678" type="currency" currencySymbol="￦"></fmt:formatNumber>

<h2>퍼센트</h2>
<fmt:formatNumber value="12345.678" type="percent"></fmt:formatNumber>
</body>
</html>
