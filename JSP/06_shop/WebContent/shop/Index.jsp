<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--Index.jsp --%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<link href="style.css" rel="stylesheet" type="text/css">

<script src="//code.jquery.com/jquery-3.6.0.min.js">
</script>

<script type="text/javascript" src="script.js">
</script>
 
</head>
<body bgcolor="#996600" topmargin="100">
 <%@ include file="Top.jsp"%>
 
 <table bgcolor="#ffff99" height="100%" width="80%">
   <%
   userId=(String)session.getAttribute("userId");
   if(userId!=null){//로그인 상태이면
	   %>
	   <tr>
	     <td align="center"> 
	      <%=userId %>님 방문해 주셔서 감사 합니다
	     </td>
	   </tr>
	   
	   <tr>
	     <td align="center">
	      <a href="ProductList.jsp">상품목록보기</a>
	     </td>
	   </tr>
	   <%
	   
   }else{//로그인 상태가 아니면 
	   %>
	   <tr>
	     <td align="center">
	              로그인 하신 후에 이용해 주세요<br>
	      <a href="Login.jsp">로그인</a>
	     </td>
	   </tr>
	   <%
   }//else-end
   %>
 </table>
 
 
 
 <%@ include file="Bottom.jsp"%>
</body>
</html>