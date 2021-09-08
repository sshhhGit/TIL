<%@page import="com.sun.org.apache.xpath.internal.operations.Or"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.util.*"
    import="shopdb.*"
    %>
<%-- ProductPro.jsp --%>

<%
request.setCharacterEncoding("UTF-8");
ProductDAO productDAO = ProductDAO.getInstance();
OrderDAO orderDAO = new OrderDAO();

String flag = request.getParameter("flag");
boolean result = false;

int iti = 0;

if(flag.equals("insert")){
	result = productDAO.insertProduct(request); //dao메서드 호출, 정상처리 true, 실패 false
	response.sendRedirect("ProductList.jsp");
	
}else if(flag.equals("update")){
	result = productDAO.updateProduct(request); //dao메서드 호출, 정상처리 true, 실패 false
	response.sendRedirect("ProductList.jsp");
	
}else if(flag.equals("del")){ //삭제
	
	Vector vec = orderDAO.getOrderList();
	if(vec.size()==0){ //주문 목록이 없으면 삭제
		int im_pro_no = Integer.parseInt(request.getParameter("pro_no"));
		result = productDAO.deleteProduct(request, im_pro_no); //삭제
		response.sendRedirect("ProductList.jsp");
		
	}else{ //주문 목록이 있으면
		for(int i=0; i<vec.size();i++){
			OrderDTO orderDTO = (OrderDTO)vec.get(i);
			int pro_no = orderDTO.getPro_no();
			
			if(pro_no == Integer.parseInt(request.getParameter("pro_no"))){
				iti++;
			}
		}//for-end
		if(iti==0){
			int im_pro_no2 = Integer.parseInt(request.getParameter("pro_no"));
			result = productDAO.deleteProduct(request, im_pro_no2);
			response.sendRedirect("ProductList.jsp");
		}else{ //주문 상황일 경우
			result = false;
			%>
			<script type="text/javascript">
				alert("주문상태입니다");
				location.href = "ProductList.jsp"
			</script>
			<%
			
		}
	}//else-end
}else{ //위의 조건에 맞지 않을 때
	response.sendRedirect("ProductList.jsp");
}
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>