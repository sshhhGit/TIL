<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>writeForm</title>
<style type="text/css">
h2{text-align: center}
table{margin: auto;
width:50%
}
</style>
</head>
<body>
<h2>글 쓰기 폼</h2>

<form method="post" action="writePro.do">
  <table border="1">
  
    <tr>
     <td>이름</td>
     <td><input type="text" name="bName" id="bName" size="30"></td>
    </tr>
    
    <tr>
     <td>글제목</td>
     <td><input type="text" name="bTitle" id="bTitle" size="50"></td>
    </tr>
    
    <tr>
     <td>글내용</td>
     <td>
     <textarea name="bContent" id="bContent" rows="10" cols="50"></textarea>
     </td>
    </tr>
    
    <tr>
      <td colspan="2" align="center">
        <input type="submit" value="글쓰기">
        <input type="reset">
      </td>
    </tr>
    
  </table>
</form>

</body>
</html>