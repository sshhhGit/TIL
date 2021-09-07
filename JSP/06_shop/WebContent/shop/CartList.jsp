<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="shopdb.*"
    import="java.util.*"
    %>
<%--CartList.jsp 장바구니 내용 보여주기 --%>
<jsp:useBean id="cartMgr" class="shopdb.CartMgr" scope="session">
</jsp:useBean>

<%
OrderDTO orderDTO = null;
ProductDTO productDTO = null;
ProductDAO productDAO = null;
Hashtable cart = null;

try{
	productDAO = ProductDAO.getInstance();
	if(session.getAttribute("userId") == null){ //로그인 상태가 아니라면
		response.sendRedirect("Login.jsp");
	}else{ //로그인 상태라면
		
		
	

%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="style.css" rel="stylesheet" type="text/css">
<script src="//code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript" src="script.js"></script>
</head>
<body bgcolor="#996600" topmargin="100">
<%@ include file="Top.jsp" %>
  <table width="80%" bgcolor="#ffff99">
    <tr>
      <td align="center" bgcolor="#ffffcc">
        <table width="95%" bgcolor="#ffff99" border="1">
         <tr>
           <td><font>제품</font></td>
           <td><font>수량</font></td>
           <td><font>가격</font></td>
           <td><font>수정/삭제</font></td>
           <td><font>조회</font></td>
           </tr>
             <%
             int totalPrice = 0;
             cart = cartMgr.getCartList(); //장바구니 내용 모두 가져오기
             
             if(cart.size()==0){
            	 out.println("장바구니의 내용이 없습니다");
            	 
             }else{
            	 out.println("<tr><td height='50' align='center' colspan='5'><font size='5'>장바구니에 들어있는 상품 내역</font></td>");
            	 
            	 Enumeration cartKeys = cart.keys(); // key값을 얻는다
            	 
            	 while(cartKeys.hasMoreElements()){ //자료가 있는동안 반복수행
            		 
            		 // key에 해당하는 값을 얻는다
            		 orderDTO = (OrderDTO)cart.get(cartKeys.nextElement());
            		 
            	 	 //getProduct(pro_no);
            		 productDTO = productDAO.getProduct(orderDTO.getPro_no());
            		 
            		 int price = productDTO.getPrice(); //가격
            		 int quantity = Integer.parseInt(orderDTO.getQuantity()); //수량
            		 int subTotal = price*quantity;
            		 totalPrice += subTotal; //총금액
            		 
            		 java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd H:mm:ss");
            		 %>
            		 
            		 <form method="post" action="CartPro.jsp">
            		   <input type="hidden" name="pro_no" value="<%=productDTO.getPro_no()%>">
            		   <input type="hidden" name="flag">
            		   <input type="hidden" name="state" value="2">
            		
            		   <tr>
            		     <td><%=productDTO.getName() %></td>
            		     <td>
            		       <input type="text" name="quantity" value="<%=orderDTO.getQuantity()%>" size="5">
            		     </td>
            		     <td>
            		       <%=subTotal %>
            		     </td>
            		     <td>
            		       <input type="button" value="cart수정" onclick="javaScript:cartUpdate(this.form)">
            		       <input type="button" value="cart삭제" onclick="javaScript:cartDelete(this.form)">
            		     </td>
            		     <td>
            		       <a href="javaScript:productDetail('<%=productDTO.getCode()%>')">상세보기</a>
            		     </td>
            		   </tr>
            		 </form>
            		 
            		 <%
            	 }//while-end
            	 %>
            	 <tr>
            	   <td colspan="4" align="right">
            	   	<strong>총금액 : <%=totalPrice %></strong>
            	   </td>
            	   
            	   <td>
            	     <a href="OrderPro.jsp"><strong>주문하기</strong></a>
            	   </td>
            	 </tr>
            	 <%
             }//else-end
             %>
        </table>
      </td>
    </tr>
  </table>
<form name="detail" method="post" action="ProductDetail.jsp">
  <input type="hidden" name="code">
</form>
<%@ include file="Bottom.jsp" %>
</body>
</html>
<%
}//else-end

}catch(Exception ex){
	out.println("CartList.jsp 예외 : " + ex);
}
%>