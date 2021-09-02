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
MemberDAO dao= MemberDAO.getInstance();//객체생성

int check=dao.confirmID(id);
//check==1 : 존재하는 id
//check==-1 : 없는 id
%>
{
"check":<%=check%>
}
