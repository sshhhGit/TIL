<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--test05_requestScope.jsp --%>

<%
request.setAttribute("name", "박문수");
%>

${requestScope.name}<br>
${requestScope['name']}<br>
<%=request.getAttribute("name")%><br>