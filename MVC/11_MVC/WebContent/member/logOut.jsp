<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/module/header.jsp" %>
<%-- logOut.jsp --%>

<c:remove var="userId" scope="session"/>
<meta http-equiv="Refresh" content="0; url=${ctxpath }/member/main.do">
