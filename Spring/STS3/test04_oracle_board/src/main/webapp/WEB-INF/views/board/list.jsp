<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style type="text/css">
h2{text-align: center}
table{margin: auto;
width:50%
}
</style>

</head>
<body>

<h2>글 목록</h2>
<table border="1">

  <tr>
    <td>번호</td>
    <td>이름</td>
    <td>글제목</td>
    <td>날짜</td>
    <td>조회수</td>
  </tr>
  
  <c:forEach var="dto" items="${list}">
    <tr>
      <td>${dto.bId}</td>
      <td>${dto.bName}</td>
      <td>
          <!-- 답글 들여 쓰기  -->
          <c:forEach begin="1" end="${dto.bIndent}">☞</c:forEach>
          
	      <a href="content.do?bId=${dto.bId}">
	         ${dto.bTitle}
	      </a>
	      
      </td>
      <td>${dto.bDate}</td>
      <td>${dto.bHit}</td>
    </tr>
  </c:forEach>
  
   <tr>
      <td colspan="5">
        <a href="writeForm.do">새글쓰기</a>
      </td>
    </tr>
    
</table>


</body>
</html>