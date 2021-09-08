<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%--AdminLoginPro.jsp --%>
<%
String admin_id = request.getParameter("admin_id");
String admin_pw = request.getParameter("admin_pw");
//DB작업
session.setAttribute("admin_id", admin_id); //세션에 등록
%>
<script>
  location.href="Index.jsp"; //ID:admin PW:12345
</script>