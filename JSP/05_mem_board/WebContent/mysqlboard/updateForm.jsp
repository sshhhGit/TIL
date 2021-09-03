<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="mysqlboard.*"
    %>
<%--updateForm.jsp --%>

<%
request.setCharacterEncoding("UTF-8");
int num = Integer.parseInt(request.getParameter("num"));
String pageNum =request.getParameter("pageNum");
BoardDAO dao = BoardDAO.getInstance();		//dao 객체 얻기
BoardDTO dto = dao.getUpdate(num);			//dao 메서드 호출, num 넘기, dto받는기
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>updateForm.jsp</title>
<script src="//code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
	function check() {
		if($('#pw').val()==''){
			alert("암호를 입력해주세요");
			$('#pw').focus();
			return false;
		}
		return true;
	}
</script>
<style type="text/css">
h2 {
	text-align: center;
}
table {
	width: 50%;
	margin: auto;
	background-color: ivory;
}
</style>
</head>
<body>
<h2>글 수정</h2>
  <form name="updateForm" method="post" action="updatePro.jsp" onsubmit="return check()">
    <table border="1">
      <tr>
        <td>글쓴이</td>
        <td>
        <input type="text" name="writer" size="40" value="<%=dto.getWriter()%>">
        <input type="hidden" name="num" value="<%=num%>">
        <input type="hidden" name="pageNum" value="<%=pageNum%>">
        </td>
      </tr>
      <tr>
        <td>글제목</td>
        <td><input type="text" name="subject" size="50" value="<%=dto.getSubject()%>"></td>
      </tr>
      <tr>
        <td>글내용</td>
        <td>
        <textarea rows="10" cols="50" name="content"><%=dto.getContent()%></textarea>
        </td>
      </tr>
      <tr>
        <td>암호</td>
        <td><input type="password" name="pw" id="pw" size="15"></td>
      </tr>
      <tr>
        <td colspan="2" align="center">
          <input type="submit" value="수정하기">&nbsp;
          <input type="reset" value="취소">&nbsp;
          <input type="button" value="글목록" onclick="location='list.jsp?pageNum=<%=pageNum%>'">&nbsp;
        </td>
      </tr>
    </table>
  
  </form>
</body>
</html>