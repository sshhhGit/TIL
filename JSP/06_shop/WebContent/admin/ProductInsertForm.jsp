<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--ProductInsertForm.jsp --%>

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
  <br>
  <form method="post" action="ProductPro.jsp?flag=insert" encType="multipart/form-data">
    <table width="80%">
      <tr>
        <td>
          <table width="95%" >
            <tr>
              <td colspan="2" align="center">
                <font size="5">상품등록</font>
              </td>
            </tr>
            <tr>
              <td>상품이름</td>
              <td>
                <input type="text" name="name" id="name" size="30">
              </td> 
            </tr>
            <tr>
              <td>상품코드</td>
              <td>
                <input type="text" name="code" id="code" size="20">
              </td> 
            </tr>
            <tr>
              <td>상품가격</td>
              <td>
                <input type="text" name="price" id="price" size="30">원
              </td> 
            </tr>
            <tr>
              <td>상품살명</td>
              <td>
                <textarea rows="10" cols="50" name="detail" id="detail"></textarea>
              </td> 
            </tr>
            <tr>
              <td>상품입고 수량</td>
              <td><input type="text" name="stock" id="stock" size="10">개</td>
            </tr>
            <tr>
              <td>상품이미지</td>
              <td>
                <input type="file" name="image">
              </td>
            </tr>
            <tr>
              <td>제조회사</td>
              <td><input type="text" name="comp" id="comp" size="30"></td>
            </tr>
            <tr>
              <td colspan="2" align="center">
                <input type="submit" value="상품등록">
                <input type="reset">
              </td>
            </tr>
          </table>
        </td>
      </tr>
    
    </table>
  </form>
  <%@ include file="Bottom.jsp" %>
</body>
</html>