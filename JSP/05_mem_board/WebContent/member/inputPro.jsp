<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="member.*"
    %>
<%--inputPro.jsp --%>
<%
request.setCharacterEncoding("UTF-8");
%>

<jsp:useBean id="dto" class="member.MemberDTO">
  <jsp:setProperty name="dto" property="*"/>
</jsp:useBean>

<%
String email = request.getParameter("email");
String email2 = request.getParameter("email2");

email = email + email2;
dto.setEmail(email);

String tel = request.getParameter("tel");
String tel2 = request.getParameter("tel2");
String tel3 = request.getParameter("tel3");

tel = tel + tel2 + tel3;
dto.setTel(tel);

MemberDAO dao = MemberDAO.getInstance(); //dao객체얻기
dao.insertMember(dto);		//dao메서드 호출, dto를 넘긴다

response.sendRedirect("main.jsp");
%>