<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--index.jsp --%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/shopping3-1.css">
</head>
<body>
  <div align="center" class="body">
    <h2>상품목록 화면</h2>
    <table border="1" width="500">
      <tr class="header">
        <th align="center">상품ID</th>
        <th align="center">상품명</th>
        <th align="center">상품가격</th>
      </tr> 
      
      <c:forEach var="item" items="${itemList }">
        <tr class="record">
          <td align="center">${item.item_id }</td>
          <td align="left">${item.item_name }</td>
          <td align="right">${item.price }</td>
      </c:forEach>
    </table>
  </div>
</body>
</html>