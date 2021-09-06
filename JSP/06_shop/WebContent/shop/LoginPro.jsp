<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--LoginPro.jsp --%>
<%
//입력폼에서 보내준 데이터 받기
request.setCharacterEncoding("UTF-8");
String memId = request.getParameter("memId");
String pw = request.getParameter("pw");

if(memId != null || memId.length()>0){
	session.setAttribute("memId", memId);
	response.sendRedirect("Index.jsp");
}
%>
