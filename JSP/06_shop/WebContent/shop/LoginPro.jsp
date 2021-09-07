<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--LoginPro.jsp --%>
<%
//입력폼에서 보내준 데이터 받기
request.setCharacterEncoding("UTF-8");
String userId = request.getParameter("userId");
String pw = request.getParameter("pw");

if(userId != null || userId.length()>0){
	session.setAttribute("userId", userId);
	response.sendRedirect("Index.jsp");
}
%>
