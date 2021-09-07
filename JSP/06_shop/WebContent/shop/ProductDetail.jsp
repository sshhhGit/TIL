<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="shopdb.*"
    import="java.util.*"
    import="java.sql.Timestamp"
    %>
<%-- ProductDetail.jsp --%>

<%
 request.setCharacterEncoding("UTF-8");
 java.util.Date date = new java.util.Date();
 java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy/MM/dd HH:mm:ss"); 
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
  <%@ include file="Top.jsp" %>
  <%
  
  ProductDAO dao = ProductDAO.getInstance();
  String code = request.getParameter("code");
  ProductDTO dto = dao.getDetail(code); //dao메소드 호출, code넘기고 dto를 받는다
  %>
  <h2>상세보기</h2>
  <%--장바구니에 담기로 이동 --%>
  <form method="post" action="CartPro.jsp">
    <table width="80%" cellpadding="3" bgcolor="ivory">
      <tr align="center" bgcolor="#d0d0d0" height="120%">
        <td colspan="2">
          <font size="+2"><%=dto.getName() %></font>
        </td>
      </tr>
      <tr>
        <td colspan="2" align="center">
          <img alt="" src="<%=request.getContextPath()%>/imgs/<%=dto.getImage()%>">
        </td>
      </tr>
      <tr>
        <td>상품코드</td>
        <td>
          <input type="text" name="code" id="code" value="<%=dto.getCode()%>" readonly="readonly">
        </td>
      </tr>
      <tr>
        <td>상품가격</td>
        <td>
          <input type="text" name="price" id="price" value="<%=dto.getPrice()%>" readonly="readonly">
        </td>
      </tr>
      <tr>
        <td>출시날짜</td>
        <td>
        <%=sdf.format(dto.getRegdate()) %>
        </td>
      </tr>
      <tr>
        <td>제조회사</td>
        <td>
          <input type="text" name="comp" id="comp" value="<%=dto.getComp()%>" readonly="readonly">
        </td>
      </tr>
      <tr>
        <td>수량</td>
        <td>
          <select name="quantity" id="quantity">
            <option value="1">1</option>
            <option value="2">2</option>
            <option value="3">3</option>
            <option value="4">4</option>
            <option value="5">5</option>
          </select>
        </td>
      </tr>
      <tr>
        <td colspan="2" align="center">
          <input type="submit" value="담기">
          <input type="reset" value="취소">
          
          <input type="hidden" name="pro_no" value="<%=dto.getPro_no()%>">
          <input type="hidden" name="userid" value="<%=session.getAttribute("userId")%>">
          <input type="hidden" name="state" value="1"> 
        </td>
      </tr>
    </table>
  </form>
  <%@ include file="Bottom.jsp" %>
</body>
</html>