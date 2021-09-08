<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"    
    import="shopdb.*"
    import="java.util.*"
    import="java.sql.Timestamp"
    %>
<%--ProductDetail.jsp 상세보기--%>
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
  <%
  ProductDAO productDAO = ProductDAO.getInstance();
  String code = request.getParameter("code");
  int pro_no = Integer.parseInt(request.getParameter("pro_no"));
  
  ProductDTO productDTO = productDAO.getDetail(code);
  %>
  <table width="80%">
    <tr>
      <td align="center">
        <table width="80%" bgcolor = "ivory">
          <tr>
            <td colspan="3" align="center">
              <font size="+1"><%=productDTO.getName() %></font><br>
            </td>
          </tr>
          
          <tr>
            <td>
              <img alt="" src="<%=request.getContextPath()%>/imgs/<%=productDTO.getImage()%>" height="160" width="150">
            </td>
            
            <td width="30%" valign="top">
              <table border="1" width="100%" height="100%" cellspacing="0">
                <tr>
                  <td>
                    <b>상품이름 : </b><%=productDTO.getName() %>
                  </td>
                </tr>
                <tr>
                  <td>
                    <b>가격 : </b><%=productDTO.getPrice() %>
                  </td>
                </tr>
                <tr>
                  <td>
                    <b>입고날짜 : </b><%=productDTO.getRegdate() %>
                  </td>
                </tr>
                <tr>
                  <td>
                    <b>남은물량 : </b>
                    <%
                    if(productDTO.getStock()>0){
                    	out.println(productDTO.getStock());
                    }else{
                    	out.println("품절");
                    }
                    %>
                    
                  </td>
                </tr>
              </table>
            </td>
            <td width="50%" valign="top"><b>상세설명</b>
            <br>
            <%=productDTO.getDetail() %>
            </td>
          </tr>
          <tr>
            <td colspan="3" align="center">
              <a href="javaScript:productUpdate('<%=productDTO.getPro_no()%>')">수정</a>
              <a href="javaScript:productDelete('<%=productDTO.getPro_no()%>')">삭제</a>
            </td>
          </tr>
        </table>
      </td>
    </tr> 
  </table>
  <form method="post" name="updateForm" action="ProductUpdate.jsp">
    <input type="hidden" name="pro_no">
  </form>
  <form name="delForm" method="post" action="ProductPro.jsp?flag=del">
    <input type="hidden" name="pro_no">
  </form>
  <%@ include file="Bottom.jsp" %>
</body>
</html>