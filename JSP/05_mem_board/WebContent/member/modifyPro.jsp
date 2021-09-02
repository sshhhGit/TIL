<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="member.*"%>
<%-- modifyPro.jsp --%>
<%
request.setCharacterEncoding("UTF-8");
%>

<jsp:useBean id="dto" class="member.MemberDTO">
  <jsp:setProperty name="dto" property="*"/>
</jsp:useBean>

<%
String id = (String)session.getAttribute("id");
dto.setId(id);

//email
String email = request.getParameter("email");
String email2 = request.getParameter("email2");
email = email+email2;
dto.setEmail(email);

//tell
String tel = request.getParameter("tel");
String tel2 = request.getParameter("tel2");
String tel3 = request.getParameter("tel3");
tel = tel+tel2+tel3;
dto.setTel(tel);

MemberDAO dao = MemberDAO.getInstance();
dao.updateMember(dto);
%>

<html>
  <body>
    <table>
      <tr>
        <td align="center">
          <font size=+2>
            <b>회원정보가 수정되었습니다</b>
          </font>
        </td>
      </tr>
      <tr>
        <td>
          <form action="">
            <input type="button" value="메인으로" onclick="location='main.jsp'">
          </form>
          2초후에 메인으로 이동합니다
          <meta http-equiv="Refresh" content="2;url=main.jsp">
        </td>
      </tr>
    </table>
  </body>
</html>