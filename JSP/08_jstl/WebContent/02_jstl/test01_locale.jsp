<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%-- test01_locate.jsp --%>
<%--
국제화 태그들이 사용 할 로케일을 지정한다
로케일 이란 : 각 나리의 언어 표기를 설정하는 것이다

로케일 지정 태그는 2가지가 있다

setLocale : 국제화 태그들이 사용 할 로케일을 지정한다
request.Encodint : 요청 파라미터의 캐릭터 인코디을 지정한다

 --%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>ko_kr</h2>
디폴트 locale : <%= response.getLocale() %><br>

<pre>
디폴트 locale : 현재 컴푸터에 국가별 설정에 되어있는 '언어_나라(ko_KR)'가 된다
'제어판 국가 및 언어' 확인 가능
</pre>

<br>
영어 로케일 설정<br>
<fmt:setLocale value="en"/>
locale : <%= response.getLocale() %><br>

일어 로케일 설정<br>
<fmt:setLocale value="ja"/>
locale : <%= response.getLocale() %><br>
</body>
</html>