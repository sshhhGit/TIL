<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--test01.jsp--%>

 표현식 : <%=request.getMethod()%><br>
 표현언어 : ${pageContext.request.method}<br><br>
 
 표현식 : <%=request.getHeader("host")%><br>
 표현언어 : ${header.host}<br><br>
