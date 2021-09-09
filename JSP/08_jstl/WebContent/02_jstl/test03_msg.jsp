<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%-- test03_msg.jsp --%>
<%-- <fmt:setLocale value="en"/>
<fmt:setLocale value="ja"/> --%>
<fmt:setLocale value="ko"/>
<fmt:bundle basename="resource.testBundle">
  <html>
    <body>
    <%-- 직접출력 --%>
      <fmt:message key="name"></fmt:message><br>
      <fmt:message key="MSG"></fmt:message>
      <br>
    <%-- 변수출력 --%>
      <fmt:message var="mm" key="MSG"></fmt:message>
      <c:out value="${mm }"></c:out>
    </body>
  </html>
</fmt:bundle>