<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="member.*"%>
<%-- deletePro.jsp --%>
<%
String id = (String)session.getAttribute("id");
String pw = request.getParameter("pw");

MemberDAO dao = MemberDAO.getInstance();
int check = dao.deleteMember(id, pw); //dao 메서드 호출

//x = 1 삭제 성공
//x = -1 암호 틀림
//x = 0 없는 id

if(check == 1){
	session.invalidate();
	%>
	<form method="post" action="main.jsp">
	  <table width="30%">
	    <tr height="40">
	      <td>
	        <font size="+2">
	          <b>회원 탈퇴 완료</b>
	        </font>
	      </td>
	    </tr>
	    <tr>
	      <td>
	      2초후에 메인으로 이동합니다
	      <meta http-equiv="Refresh" content="2;url=main.jsp">
	      <input type="submit" value="메인으로">
	      </td>
	    </tr>
	  </table>
	</form>
	<%
}else if(check == -1){
	%>
	<script type="text/javascript">
	alert("암호가 일치하지 않습니다");
	history.back();
	</script>
	<%
	
}else if(check == 0){
	%>
	<script type="text/javascript">
	alert("존재하지 않는 ID입니다");
	history.back();
	</script>
	<%
}
%>