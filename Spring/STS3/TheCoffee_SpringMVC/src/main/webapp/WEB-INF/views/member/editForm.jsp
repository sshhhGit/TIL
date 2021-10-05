<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../module/jsp-header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="//code.jquery.com/jquery-3.5.1.min.js"></script>
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script>
function openDaumPostcode(){
   new daum.Postcode({
      oncomplete:function(data){
         document.getElementById('zipcode').value=data.zonecode;
         document.getElementById('addr').value=data.address;
       }
   }).open();
}//openDaumPostcode()---
</script>
<style type="text/css">
h2{
	text-align: center;
}
table {
	margin: auto;
	line-height: 30px;
	padding : 3px;
	background-color: #FFEFD5;
}
</style>
</head>
<body>
<h2>내정보 수정</h2>
<form action="editPro.do" method="post">
  <table border="1">
    <tr>
      <td>ID</td>
      <td>
        ${mdto.id }
        <input type="hidden" name="id" id="id" value="${mdto.id }">
      </td>
    </tr>
    <tr>
      <td>암호</td>
      <td>
        <input type="password" name="pw" id="pw" size="20">
      </td>
    </tr>
    <tr>
      <td>암호확인</td>
      <td>
        <input type="password" name="pw2" id="pw2" size="20">
      </td>
    </tr>
    <tr>
      <td>이름</td>
      <td>
        <input type="text" name="name" id="name" size="20" value="${mdto.name }">
      </td>
    </tr>
    <tr>
      <td>이메일</td>
      <td>
        <input type="text" name="email" id="email" value="${email }" size="20">
        <select name="email2" id="email2">
          <option value="@${email2 }">${email2}</option>
          <option value="@naver.com">naver.com</option>
          <option value="@daum.net">daum.net</option>
          <option value="@nate.com">nate.com</option>
        </select>
      </td>
    </tr>
    <tr>
      <td>전화</td>
      <td>
        <select name="tel" id="tel">
          <option value="${tel }">${tel} </option>
          <option value="010">010</option>
          <option value="018">018</option>
          <option value="017">017</option>
          <option value="032">032</option>
        </select>
        -
        <input type="text" name="tel2" id="tel2" size="4" value="${tel2 }">-
        <input type="text" name="tel3" id="tel3" size="4" value="${tel3 }">
      </td>
    </tr>
    <tr>
      <td>우편번호</td>
      <td>
        <input type="text" name="zipcode" id="zipcode" size="7" value="${mdto.zipcode }" readonly="readonly">
        <input type="button" value="주소찾기" onclick="openDaumPostcode()">
      </td>
    </tr>
    <tr>
      <td>주소</td>
      <td>
        <input type="text" name="addr" id="addr" size="50" value="${mdto.addr }" readonly="readonly">
        <br>
  상세주소:<input type="text" name="addr2" id="addr2" size="20" value="${mdto.addr2 }">
      </td>
    </tr>
    <tr>
      <td colspan="2" align="center">
        <input type="submit" value="내정보 수정">
        <input type="reset" value="다시입력">
      </td>
    </tr>
  </table>
</form>
</body>
</html>