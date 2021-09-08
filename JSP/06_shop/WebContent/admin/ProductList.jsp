<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="shopdb.*"
    import="java.util.*"
    import="java.sql.Timestamp"
    %>
<%--ProductList.jsp --%>
<% ProductDAO productDAO = ProductDAO.getInstance(); %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="style.css" rel="stylesheet" type="text/css">
<script src="//code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript" src="Ascript.js"></script>
</head>
<body topmargin="20">
 <%@ include file="Top.jsp" %>
 <table width="80%" bgcolor="ivory">
   <tr>
     <td>
       <table width="100%" border="1" >
         <tr bgcolor="pink">
           <td>상품명</td>
           <td>가격</td>
           <td>입고날짜</td>
           <td>남은수량</td>
           <td>&nbsp;</td>
         </tr>
         <%
         List <ProductDTO> list = productDAO.getGoodList();
         if(list.size() == 0){
        	 out.println("상품이 없습니다");
         }else{
        	 for(int i=0; i<list.size(); i++){
        		 ProductDTO pdto = (ProductDTO)list.get(i);
        		 %>
        		 <tr>
        		   <td><%=pdto.getName() %></td>
        		   <td><%=pdto.getPrice() %></td>
        		   <td><%=pdto.getRegdate() %></td>
        		   <td>
        		   <%
        		   if(pdto.getStock()>0){
        			   out.println(pdto.getStock());
        		   }else{
        			   out.println("품절");
        		   }
        		   %>
        		   </td>
        		   <td align="center">
        		     <a href="javaScript:productDetail('<%=pdto.getCode()%>','<%=pdto.getPro_no()%>')">
        		     상세보기</a>
        		   </td>
        		 </tr>
        		 <%
        	 }//for-end
         }//else-end
         %>
         <tr>
           <td colspan="5" align="center">
             <a href="ProductInsertForm.jsp"><strong>상품등록</strong></a>
           </td>
         </tr>
       </table>
     </td>
   </tr>
 </table>
 <form action="ProductDetail.jsp" name="detail" method="post">
   <input type="hidden" name="code">
   <input type="hidden" name="pro_no" value="">
 </form>
  <%@ include file="Bottom.jsp" %>
</body>
</html>