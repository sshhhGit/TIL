<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="shopdb.*"
    import="java.util.*"
    %>
<%--Order.Pro --%>

<jsp:useBean id="cartMgr" class="shopdb.CartMgr" scope="session"></jsp:useBean>
<jsp:useBean id="orderDAO" class="shopdb.OrderDAO"></jsp:useBean>

<%
ProductDAO productDAO = ProductDAO.getInstance();
Hashtable cart = cartMgr.getCartList();//장바구니 내용

Enumeration cartKeys = cart.keys();//cart의 모든 key들을 받는다
if(cart.size() != 0){ //장바구니의 내용이 있다면
	while(cartKeys.hasMoreElements()){
		
		//key에 해당하는 값을 얻는다
		OrderDTO orderDTO = (OrderDTO)cart.get(cartKeys.nextElement());
		
		orderDAO.insertOrder(orderDTO);//주문 insert
		productDAO.reduceProduct(orderDTO); //물량계산
		cartMgr.deleteCart(orderDTO);
		
	}//while-end
	%>
	<script>
	 alert("주문을 처리 하였습니다");
	 location.href="OrderList.jsp"; //주문목록보기
	</script>
	<%
}else{ //장바구니의 내용이 없다면
	%>
	<script>
	 alert("장바구니가 비어있습니다");
	 location.href="ProductList.jsp"; //상품목록보기
	</script>
	<%
}
%>