<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="shopdb.*"
    import="java.util.*"
    import="java.sql.Timestamp"
    %>
<%
request.setCharacterEncoding("UTF-8");
ProductDAO productDAO = ProductDAO.getInstance();
%>
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
int im_pro_no = Integer.parseInt(request.getParameter("pro_no"));
//String imcode = request.getParameter("code");
ProductDTO productDTO = productDAO.getProduct(im_pro_no);
%>

<form action="ProductPro.jsp?flag=update" method="post" enctype="multipart/form-data">
  <table width="80%" border="1">
    <tr>
      <td colspan="2" align="center">
        <font size="5">상품 수정</font>
      </td>
    </tr>
    <tr>
      <td>상품이름</td>
      <td>
        <input type="text" name="name" id="name" value="<%=productDTO.getName()%>" size="30">
      </td>
    </tr>
    <tr>
      <td>상품코드</td>
      <td>
        <input type="text" name="code" id="code" value="<%=productDTO.getCode()%>" size="15">
      </td>
    </tr>
    <tr>
      <td>상품가격</td>
      <td>
        <input type="text" name="price" id="price" value="<%=productDTO.getPrice()%>" size="20">원
      </td>
    </tr>
    <tr>
      <td>상품설명</td>
      <td>
        <textarea rows="10" cols="50" name="detail" id="detail"><%=productDTO.getDetail() %></textarea>
      </td>
    </tr>
    <tr>
      <td>입고수량</td>
      <td>
        <input type="text" name="stock" id="stock" value="<%=productDTO.getStock()%>" size="10">개
      </td>
    </tr>
    <tr>
      <td>상품이미지</td>
      <td>
        <img alt="" src="<%=request.getContextPath()%>/imgs/<%=productDTO.getImage()%>" height="160" width="150">
        <br>
        <input type="file" name="image">
      </td>
    </tr>
    <tr>
      <td>제조회사</td>
      <td>
        <input type="text" name="comp" id="comp" value="<%=productDTO.getComp()%>" size="30">
      </td>
    </tr>
    <tr>
      <td colspan="2" align="center">
        <input type="submit" value="수정">&nbsp;&nbsp;
        <input type="reset">
        <input type="hidden" name="pro_no" value="<%=productDTO.getPro_no()%>">
      </td>
    </tr>
  </table>

</form>

<%@ include file="Bottom.jsp" %>
</body>
</html>