<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--Top.jsp --%>
<%
String memId = (String)session.getAttribute("memId");
String log = "";
String mem = "";

if(memId == null){
	log = "<a href='Login.jsp'>로그인</a>";
	mem = "<a href='inputForm.jsp'>회원가입</a>";
}else{
	log = "<a href='LogOut.jsp'>로그아웃</a>";
	mem = "<a href='updateForm.jsp'>회원정보수정</a>";
}
%>
<table width="80%" align="center">
  <tr bgcolor="#ffcc00">
    <td align="center"><b><%=log %></b></td>
    <td align="center"><b><%=mem %></b></td>
    
    <td align="center"><b><a href="ProductList.jsp">상품목록</a></b></td>
    <td align="center"><b><a href="CartList.jsp">장바구니</a></b></td>
    <td align="center"><b><a href="OrderList.jsp">구매목록</a></b></td>
  </tr>
</table>