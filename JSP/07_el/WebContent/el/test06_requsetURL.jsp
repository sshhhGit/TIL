<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--test06_requsetURL.jsp --%>
<html>
<body>
  파라미터 값 (ID) : ${param.id }<br>
  파라미터 값 (PW) : ${param.pw }<br><br>
  
  요청 URI : ${pageContext.request.requestURI }<br>
  요청 URL : ${pageContext.request.requestURL }<br><br>
</body>
</html>
<%--
http://localhost:9000/07_el/el/test06_requsetURL.jsp
http://localhost:9000/07_el/el/test06_requsetURL.jsp?id=kim
http://localhost:9000/07_el/el/test06_requsetURL.jsp?id=kim&pw=123
--%>