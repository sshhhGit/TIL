<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>     
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>content.jsp</title>

<style type="text/css">
 h2{text-align:center;}
 table{
 margin:auto; 
 background-color:ivory;
 width:70%;
 }
</style>

</head>
<body>
 <h2>글 내용 보기</h2>
  <table border="1">
    <tr>
       <td>글번호</td>
       <td>${dto.num}</td>
       <td>조회수</td>
       <td>${dto.readcount}</td>
    </tr>
    
    <tr>
      <td>이름</td>
      <td>${dto.writer}</td>
      <td>작성일</td>
      <td>
      <fmt:formatDate value="${dto.regdate}" pattern="yyyy-MM-dd"/>
      </td>
    </tr>
    
    <tr> 
      <td>글제목</td>
      <td colspan="3">${dto.subject}</td>
    </tr>
    
    <tr>
      <td>글내용</td>
      <td colspan="3"><pre>${content}</pre></td>
    </tr>
    
    <tr>
      <td colspan="4" align="center">
        <input type="button" value="글수정" onClick="location.href='updateForm.do?num=${num}&pageNum=${pageNum}'">
        <input type="button" value="글삭제" onClick="location.href='delete.do?num=${num}&pageNum=${pageNum}'">
        <input type="button" value="새글쓰기" onClick="location.href='writeForm.do'">
        
        <input type="button" value="답글쓰기" onClick="location.href='writeForm.do?num=${num}&pageNum=${pageNum}&ref=${dto.ref}&re_step=${dto.re_step}&re_level=${dto.re_level}'">
        <input type="button" value="글목록" onClick="location.href='list.do?num=${num}&pageNum=${pageNum}'">
         
      </td>
    </tr>
    
    
    
  </table>
</body>
</html>