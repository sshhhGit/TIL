<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>content.jsp</title>

<style type="text/css">
h2{text-align: center}
table{margin: auto;
width:50%
}
</style>


</head>
<body>
 <h2>글내용,글 수정 폼</h2>
 
 <form method="post" action="modifyPro.do">
   <table border="1">
   
     <tr>
       <td>글번호</td>
       <td>
       ${bdto.bId}
       <input type="hidden" name="bId" value="${bdto.bId}">
       </td>
     </tr>
     
     <tr>
       <td>조회수</td>
       <td>${bdto.bHit}</td>
     </tr>
     
     <tr>
       <td>이름</td>
       <td><input type="text" name="bName" value="${bdto.bName}"></td>
     </tr>
     
     
     <tr>
       <td>글제목</td>
       <td><input type="text" name="bTitle" value="${bdto.bTitle}"></td>
     </tr>
     
     <tr>
       <td>글내용</td>
       <td>
        <textarea name="bContent" rows="10" cols="50">${bdto.bContent}</textarea>
       </td>
     </tr>
     
     <tr>
       <td colspan="2" align="center">
         <input type="submit" value="글수정">&nbsp;&nbsp;
       
         <a href="list.do">목록보기</a>&nbsp;&nbsp;
         <a href="delete.do?bId=${bdto.bId}">삭제</a>&nbsp;&nbsp;
         <a href="replyView.do?bId=${bdto.bId}">답변</a>
         
       </td>
     </tr>
   </table>
 </form>
</body>
</html>