<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.util.*"%>
<%--test02.jsp--%>

 <%
 String userId = "kim";
 session.setAttribute("userId", userId);
 session.setAttribute("pw", "k123");
 %>
 
 표현식 : <%=session.getAttribute("userId")%>님<br>
 표현언어 : ${sessionScope.userId}님 환영합니다<br>