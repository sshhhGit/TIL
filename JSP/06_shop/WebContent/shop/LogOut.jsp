<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--LogOut.jsp --%>

<%
session.invalidate();
response.sendRedirect("Index.jsp");
%>