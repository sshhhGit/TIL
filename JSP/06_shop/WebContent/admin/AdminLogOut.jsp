<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--AdminLogOut.jsp --%>
<%
session.invalidate();
%>

<script>
  location.href="Index.jsp"; //ID:admin PW:12345
</script>