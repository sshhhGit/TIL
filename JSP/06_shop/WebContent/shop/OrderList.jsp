<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="shopdb.*"
    import="java.util.*"%>
<%--OrderList.jsp --%>
<%--
<jsp:useBean id="orderDAO" class="shopdb.OrderDAO"></jsp:useBean>
 --%>
 <%
 shopdb.OrderDAO orderDAO = new shopdb.OrderDAO(); //객체생성
 ProductDAO productDAO = ProductDAO.getInstance(); //dao객체 얻기
 %>
<%@ include file="Top.jsp" %>
<%
if(session.getAttribute("userId") == null){
	//로그인 상태가 아니라면
	response.sendRedirect("Login.jsp");
}else{
	//로그인 상태라면
	userId = (String)session.getAttribute("userId");
}
%> 
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="style.css" rel="stylesheet" type="text/css">
<script src="//code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript" src="script.js"></script>
</head>
<body topmargin="20">
 <table width="80%">
   <tr>
     <td colspan="5" align="center">
       <h3><%=userId %>님의 구매목록</h3>
     </td>
   </tr>
   <tr>
     <td align="center">
       <table width="95%">
         <tr bgcolor="pink">
           <td>주문번호</td>
           <td>제품명</td>
           <td>주문수량</td>
           <td>주문날짜</td>
           <td>주문상태</td>
         <tr>
         <%
         Vector vec = orderDAO.getOrder(userId); //dao메서드 호출, vec를 받는다
         if(vec.size() == 0){
        	 out.println("구매목록 없음");
         }else{//구매목록이 있을때
        	 for(int i=0; i<vec.size(); i++){
        		 OrderDTO orderDTO = (OrderDTO)vec.get(i);
        		 int pro_no = orderDTO.getPro_no();
        		 ProductDTO productDTO = productDAO.getProduct(pro_no);
        		 %>
        		 <tr>
        		   <td><%=orderDTO.getOrdno() %></td>
        		   <td>
        		   <!-- 상품이름을 클릭하면 상세 보기로 간다 -->
        		   <a href="javaScript:productDetail('<%=productDTO.getCode()%>')">
        		   <%=productDTO.getName() %>
        		   </a>
        		   </td>
        		   <td><%=orderDTO.getQuantity() %></td>
        		   <td><%=orderDTO.getOrddate() %></td>
        		   <td>
        		   <%
        		   switch(Integer.parseInt(orderDTO.getState())){
	        		   case 1 : 
	        			   out.println("접수중");	 break;
	        		   case 2 : 
	        			   out.println("접수");     break;
	        		   case 3 : 
	        			   out.println("입금확인");  break;
	        		   case 4 : 
	        			   out.println("배송준비");  break;
	        		   case 5 : 
	        			   out.println("배송중");    break;
	        		   default : 
	        			   out.println("배송완료");

        		   }//switch-end
        		   %>
        		   </td>
        		 </tr>
        		 <%
        	 }//for-end
         }//else-end
         %>
       </table>
     </td>
   </tr>
 </table>
 <form method="post" name="detail" action="ProductDetail.jsp">
   <input type="hidden" name="code">
 </form>
<%@ include file="Bottom.jsp" %>
</body>
</html>