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

<script>
//-----------------------------
//Ajax사용하여 id사용 여부 체크
//-----------------------------
 function confirmIdCheck(){
    if($('#id').val()==''){
       alert("ID를 입력하세요");
    }else{
      //alert("Ajax");////////////////********
      $.ajax({
         type:'POST',
         url:'idCheck.do',
         data:"id="+$('#id').val(),
          dataType:'JSON',
         success:function(data){
            //alert(data.check);////////////************
            
            if(data.check==-1){
               alert("사용 중인 ID입니다.");
               $('#id').val('').focus();
               
            }else if(data.check==1){//사용가능한
               //$('#idcheck').val('1');//id중복 체크가 되었을때 
               alert("사용 가능 한 ID입니다.");
               $('#pw').focus();
            }
         }//success
       });
      
    }//else end
 }//confirmIdCheck() end
 </script>
<script type="text/javascript">
function check() {
	if($('#id').val()==''){
		alert("ID를 입력하세요");
		$('#id').focus();
		return false;
	}
	if($('#pw').val()==''){
		alert("암호를 입력하세요")
		$('#pw').focus();
		return false;
	}
	if($('#pw2').val()==''){
		alert("암호확인을 입력하세요")
		$('#pw2').focus();
		return false;
	}
	if($('#pw').val() != $('#pw2').val()){
		alert("암호확인이 일치하지 않습니다");
		$('#pw2').val('');
		$('#pw').val('').focus();
		return false;
	}
	if($('#name').val()==''){
		alert("이름을 입력하세요");
		$('#name').focus();
		return false;
	}
	return true;
}
</script>
<style type="text/css">
h2{
	text-align: center;
}
table {
	margin: auto;
	line-height: 30px;
	background-color: #FFEFD5;
}
</style>
</head>
<body>
<h2>회원가입</h2>
<form method="post" action="insertPro.do" onsubmit="return check()">
  <table border="1">
    <tr>
      <td>ID</td>
      <td>
        <input type="text" name="id" id="id" size="20">
        <input type="button" value="중복확인" onclick="confirmIdCheck()">
      </td>
    </tr>
    <tr>
      <td>암호</td>
      <td>
        <input type="password" name="pw" id="pw" size="15">
      </td>
    </tr>
    <tr>
      <td>암호확인</td>
      <td>
        <input type="password" name="pw2" id="pw2" size="15">
      </td>
    </tr>
    <tr>
      <td>이름</td>
      <td>
        <input type="text" name="name" id="name" size="20">
      </td>
    </tr>
    <tr>
      <td>이메일</td>
      <td>
        <input type="text" name="email" id="eamil" size="20">@
        <select name="email2" id="email2">
          <option value="">선택하세요</option>
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
          <option value="">선택하세요</option>
          <option value="010">010</option>
          <option value="018">018</option>
          <option value="017">017</option>
        </select>
        -
        <input type="text" name="tel2" id="tel2" size="4">-
        <input type="text" name="tel3" id="tel2" size="4">
      </td>
    </tr>
    <tr>
      <td>우편번호</td>
      <td>
        <input type="text" name="zipcode" id="zipcode" readonly="readonly" size="7">
        <input type="button" value="주소검색" onclick="openDaumPostcode()">
      </td>
    </tr>
    <tr>
      <td>주소</td>
      <td>
        <input type="text" name="addr" id="addr" readonly="readonly" size="50"><br>
    상세주소<input type="text" name="addr2" id="addr2" size="20">
      </td>
    </tr>
    <tr>
      <td colspan="2" align="center">
        <input type="submit" value="회원가입">
        <input type="reset" value="다시입력">
        <input type="button" value="취소" onclick="${ctxpath}/member/main.do">
      </td>
    </tr>
  </table>
</form>
</body>
</html>