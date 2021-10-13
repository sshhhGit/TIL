<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>writeForm.jsp</title>

<style type="text/css">
h2{text-align: center;}
table{
margin:auto;
background-color: ivory;
}
</style>


<script src="//code.jquery.com/jquery-3.6.0.min.js"></script>

<script type="text/javascript">
  function check(){
	  if($("#writer").val()==''){
		  alert("이름을 입력 하세요");
		  $("#writer").focus();
		  return false;
	  }
	  if($("#subject").val()==''){
		  alert("글 제목 입력 하세요");
		  $("#subject").focus();
		  return false;
	  }
	  if($("#content").val()==''){
		  alert("글내용 입력 하세요");
		  $("#content").focus();
		  return false;
	  }
	  if($("#pw").val()==''){
		  alert("암호을 입력 하세요");
		  $("#pw").focus();
		  return false;
	  }
	  return true;
  }
</script>

</head>
<body>
<c:if test="${num==0}">
  <h2>게시판 글쓰기</h2>
</c:if>

<c:if test="${num!=0}">
  <h2>답글쓰기</h2>
</c:if>

  <form method="post" action="writePro.do" onSubmit="return check()">
    <input type="hidden" name="pageNum" value="${pageNum}">
    <input type="hidden" name="num" value="${num}">
    <input type="hidden" name="ref" value="${ref}">
    <input type="hidden" name="re_step" value="${re_step}">
    <input type="hidden" name="re_level" value="${re_level}">
    
    <table border="1">
    
      <tr>
        <td colspan="2" align="right">
          <a href="list.do">글목록</a>
        </td>
      </tr>
      
      <tr>
        <td>이름</td>
        <td><input type="text" name="writer" id="writer" size="30"></td>
      </tr>
      
     <tr>
       <td>글제목</td>
       <td>
	      <!-- 원글 -->
	      <c:if test="${num==0}">
	       <input type="text" name="subject" id="subject" size="40">
	      </c:if>
	      
	       <!-- 답글 -->
	      <c:if test="${num!=0}">
	        <input type="text" name="subject" id="subject" size="40" value="[답변]">
	      </c:if>
       </td>
     </tr>
     
     <tr>
       <td>글내용</td>
       <td>
        <textarea name="content" id="content" rows="10" cols="50"></textarea>
       </td>
     </tr>      
      
     <tr>
       <td>암호</td>
       <td><input type="password" name="pw" id="pwd" size="15"></td>
     </tr>
      
     <tr>
       <td colspan="2" align="center">
        <c:if test="${num==0}">
         <input type="submit" value="글쓰기">
        </c:if>
        
        <c:if test="${num!=0}">
         <input type="submit" value="답글쓰기">
        </c:if>
         
        <input type="reset" value="다시쓰기">
        <input type="button" value="글목록" onclick="location.href='list.do'">
       </td>
     </tr>
    </table>
  </form>
</body>
</html>