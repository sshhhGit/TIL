<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ include file="header.jsp" %>
<%--deletePro.jsp --%>

<c:if test="${check==1}">
 <meta http-equiv="Refresh" content="0; url=${ctxpath}/board/list.do">
</c:if>

<c:if test="${check==0}">
  <script>
    alert("암호틀림");
    history.back();
  </script>
</c:if>
 