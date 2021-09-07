<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="shopdb.*"
    import="java.util.*"
    import="java.sql.Timestamp"
    %>
<%--ProductList.jsp 상품목록보기--%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="style.css" rel="stylesheet" type="text/css">
<script src="//code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript" src="script.js"></script>
</head>
<%!
//선언부:변수선언,메서드 선언 
List list;//전역변수는 자동으로 초기화 된다 

%>
<body bgcolor="#996600" topmargin="20">
<%@ include file="Top.jsp"%>
<%
ProductDAO dao=ProductDAO.getInstance();//객체얻기
list=dao.getGoodList();//dao메서드 호출 , list를 받는다

if(list.isEmpty()){//상품이 없으면
	out.println("등록된 상품이 없습니다");
}else{//상품이 있으면 
	%>
	<table border="1" width="80%" cellpadding="3">
	 <tr>
	 <%
	 for(int i=0; i<list.size(); i++){
		 if(i%3==0){
			 out.println("</tr><tr>");
		 }//if-end
		 
		 ProductDTO dto=(ProductDTO)list.get(i);
		 %>
		 <td>
		  <table border="0">
		  
		    <tr align="center" bgcolor="#d0d0d0" height="120%">
		      <td colspan="2">
		        <%=dto.getName() %>
		      </td>
		    </tr>
		    
		    <tr>
		     <td colspan="2" align="center">
		      <%
		       if(dto.getStock()>0){//상품 수량이 있으면
		    	   %>
		    	   <a href="javaScript:productDetail('<%=dto.getCode()%>')">
		    	     <img src="<%=request.getContextPath()%>/imgs/<%=dto.getImage()%>" width="300" height="300">
		    	     <br>
		    	     <%=request.getContextPath()%>
		    	   </a>
		    	   <%
		       }else{//상품 수량이 없으면
		    	   %>
		    	   <script>
		    	     alert("<%=dto.getName()%>품절")
		    	   </script>
		    	   <%
		       }//else-end
		      %>
		     </td>
		    </tr>
		    
		    <tr>
		     <td>상품코드</td>
		     <td><%=dto.getCode() %></td>
		    </tr>
		    
		    <tr>
		     <td>가격</td>
		     <td><%=dto.getPrice() %></td>
		    </tr>
		    
		    <tr>
		     <td>출시날짜</td>
		     <td><%=dto.getRegdate() %></td>
		    </tr>
		    
		    <tr>
		     <td>제조회사</td>
		     <td><%=dto.getComp() %></td>
		    </tr>
		    
		    <tr>
		     <td>물량,stock</td>
		     <td>
		     <%
		     if(dto.getStock()>0){
		    	 %>
		    	 <%=dto.getStock() %>
		    	 <%
		     }else{
		    	out.println("품절"); 
		     }//else-end
		     %>
		     
		     </td>
		    </tr>
	 	  </table>
 		 </td>
		 <%
	 }//for-end
	 %>
	 </tr>
	</table>
	
	<%
}//else-end
%>
<form name="detail" method="post" action="ProductDetail.jsp">
 <input type="hidden" name="code">
</form>
<%@ include file="Bottom.jsp"%>
</body>
</html>