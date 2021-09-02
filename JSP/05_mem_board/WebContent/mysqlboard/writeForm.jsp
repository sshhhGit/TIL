<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--writeForm.jsp --%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="//code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript" src="script.js"></script>
<style type="text/css">
h2 {
	text-align: center;
}
table {
	margin: auto;
	width: 70%;
}
</style>
</head>
<%
int num = 0;
int ref = 0;
int re_step = 0;
int re_level = 0;
String regdate = ""; //날짜

if(request.getParameter("num") != null){ //답글이면
	num = Integer.parseInt(request.getParameter("num"));
	ref = Integer.parseInt(request.getParameter("ref"));
	re_step = Integer.parseInt(request.getParameter("re_step"));
	re_level = Integer.parseInt(request.getParameter("re_level"));
	
}//if-end

%>
<body>
<%
if(num != 0){
	%>
	<h2>답글쓰기</h2>
	<%
}else{
	%>
	<h2>글쓰기</h2>
	<%
}
%>

<form action="writePro.jsp" method="post" name="writeForm" onsubmit="return check()">

	<input type="hidden" name="num" value="<%=num%>">
	<input type="hidden" name="ref" value="<%=ref%>">
	<input type="hidden" name="re_step" value="<%=re_step%>">
	<input type="hidden" name="re_level" value="<%=re_level%>">
	
	
	<table>
	  <tr>
	    <td align="right">
	      <a href="list.jsp">글목록</a>
	    </td>
	  </tr>
	</table>
	
	<table border="1">
	  <tr>
	    <td>글쓴이</td>
	    <td><input type="text" name="writer" id="writer" size="30"></td>
	  </tr>
	  
	  <tr>
	    <td>글제목</td>
	    <td>
	    <%
	    if(num==0){ //원글이면
	    	%>
	    	<input type="text" name="subject" id="subject" size="50">
	    	<% 
	    }else{  //답글이면
	    	%>
	    	<input type="text" name="subject" id="subject" size="50" value="[답글]">
	    	<% 
	    } //else end
	    %>
	    </td>
	  </tr>
	  
	  <tr>
	    <td>글내용</td>
	    <td>
	      <textarea rows="10" cols="50" name="content" id="content"></textarea>
	    </td>
	  </tr>
	  
	  <tr>
	    <td>암호</td>
	    <td><input type="password" name="pw" id="pw" size="15"></td>
	  </tr>
	  
	  <tr>
	    <td colspan="2" align="center">
	    <%
	    if(num==0){
	    	%>
	    	<input type="submit" value="글쓰기">
	    	<%
	    }else{
	    	%>
	    	<input type="submit" value="답글쓰기">
	    	<%
	    }//else-end
	    %>
	    
	    <input type="reset">
	    <input type="button" value="글목록" onclick="location='list.jsp'">
	    </td>
	  </tr>
	</table>
</form>

</body>
</html>