<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<h2>답글 쓰기 폼</h2>
<form method="post" action="replyPro.do">
  <table border="1">
    <tr>
      <td>글번호</td>
      <td>
      ${bdto.bId }
      <input type="hidden" name="bId" value="${bdto.bId }">
      <input type="hidden" name="bGroup" value="${bdto.bGroup }">
      <input type="hidden" name="bStep" value="${bdto.bStep }">
      <input type="hidden" name="bIndent" value="${bdto.bIndent }">
      </td>
    </tr>
    <tr>
      <td>조회수</td>
      <td>${bdto.bHit }</td>
    </tr>
    <tr>
      <td>이름</td>
      <td>
      <input type="text" name="bName" id="bName" value="${bdto.bName }">
      </td>
    </tr>
    <tr>
      <td>글제목</td>
      <td>
      <input type="text" name="bTitle" id="bTitle" value="${bdto.bTitle }">
      </td>
    </tr>
    <tr>
      <td>글내용</td>
      <td>
      <textarea name="bContent" rows="10" cols="50">[답글]${bdto.bContent }</textarea>
      </td>
    </tr>
    <tr>
      <td colspan="2" align="center">
        <input type="submit" value="답글">&nbsp;
        <a href="list.do">글목록</a>
      </td>
    </tr>
  </table>
</form>
</body>
</html>