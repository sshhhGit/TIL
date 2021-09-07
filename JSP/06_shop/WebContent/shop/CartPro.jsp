<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="shopdb.*"
    %>
<%--CartPro.jsp --%>

<jsp:useBean id="cartMgr" class="shopdb.CartMgr" scope="session">
</jsp:useBean>

<%--ProductDetail.jsp에서 넘겨준 내용을 orderDTO에 넣는다 --%>
<jsp:useBean id="orderDTO" class="shopdb.OrderDTO">
  <jsp:setProperty name="orderDTO" property="*"/>
</jsp:useBean>

<%
//지역변수, 자바구문
String state = request.getParameter("state");
orderDTO.setState(state);

String flag = request.getParameter("flag"); //update, del
String userId = (String)session.getAttribute("userId");

if(userId == null){ //로그인이 안된 상태
	response.sendRedirect("Login.jsp");
}else{ //로그인 상태
	if(flag == null){ //장바구니에 넣기
		orderDTO.setUserid(userId);
		cartMgr.addCart(orderDTO); //장바구니에 넣기
		%>
		<script>
		alert("장바구니에 추가되었습니다");
		location.href = "CartList.jsp";
		</script>		
		<%
	}else if(flag.equals("update")){
		orderDTO.setUserid(userId);
		cartMgr.updateCart(orderDTO); //장바구니 내용 수정
		%>
		<script>
		alert("장바구니가 수정되었습니다");
		location.href = "CartList.jsp";
		</script>
		<%
	}else if(flag.equals("del")){
		cartMgr.deleteCart(orderDTO);
		%>
		<script>
		alert("장바구니에서 삭제되었습니다");
		location.href = "CartList.jsp";
		</script>
		<%
	}//else if-end
}//else-end
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>