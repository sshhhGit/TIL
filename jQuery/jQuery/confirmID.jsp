<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- confirmID.jsp --%>
<%
String id = request.getParameter("id");
/* MemberDAO dao = MemberDAO.getInstance(); //dao객체 얻기
int check = dao.confirmID(id); */

//check == 1이면 사용중인 id
//check == -1이면 사용가능한 id

int check = 1;

%>
{
"check" : <%=check%>
}