<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="jsp_header.jsp"%>
<%--index.jsp --%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

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
          <!-- 상품명을 클릭하면 상세보기 -->
          <td align="left"><a href="detail.html?item_id=${item.item_id }">
          ${item.item_name }</a></td>
          <td align="right">${item.price }원</td>
      </c:forEach>
    </table>
  </div>
</body>
</html>