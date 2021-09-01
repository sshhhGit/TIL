<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="member.*"
    %>
<%--confirmID.jsp --%>
<%
request.setCharacterEncoding("UTF-8");
%>

<%
String id=request.getParameter("id");
MemberDAO dao=new MemberDAO();//객체생성
int x=dao.confirmID(id);
//x==1 : 존재하는 id
//x==-1 : 없는 id
%>
{
"x":<%=x%>
}
