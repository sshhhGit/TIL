<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--deleteForm.jsp --%>

<%
request.setCharacterEncoding("UTF-8");
int num = Integer.parseInt(request.getParameter("num"));
String pageNum = request.getParameter("pageNum");
%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
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
	text-align: center;
}
</style>
</head>
<body>
<h2>글삭제</h2>
  <form name="deleteForm" method="post" action="deletePro.jsp" onsubmit="return check()">
    <table border="1">
      <tr>
        <td>
          <b>암호를 입력하세요</b>
        </td>
      </tr>
      
      <tr>
        <td>
          <input type="password" name="pw" id="pw" size="15">
          <input type="hidden" name="num" value="<%=num%>">
          <input type="hidden" name="pageNum" value="<%=pageNum%>">
        </td>
      </tr>
      <tr>
        <td align="center">
          <input type="submit" value="글삭제">&nbsp;
          <input type="button" value="글목록" onclick="location='list.jsp?pageNum=<%=pageNum%>'">&nbsp;
        </td>
      </tr>
    </table>
  </form>
</body>
</html>