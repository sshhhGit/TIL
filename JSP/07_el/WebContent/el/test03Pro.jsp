<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--test03Pro.jsp --%>
<%
request.setCharacterEncoding("UTF-8");
%>

<h3>표현식 : <%=session.getAttribute("adminId") %></h3>
<h3>표현언어 : ${sessionScope.adminId }</h3>

이름 : <%=request.getParameter("name") %>
이름 : ${param.name}
전화 : ${param.tel}
주소 : ${param.addr}
취미 : <br>
${paramValues.hobby[0]}<br>
${paramValues.hobbu[1]}<br>