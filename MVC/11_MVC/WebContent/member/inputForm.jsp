<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/module/header.jsp" %>
<%--inputForm.jsp --%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>inputForm.jsp</title>
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
  <script type="text/javascript">
  function idCheck() {
	  //id중복체크, 암호칸이 클릭되었을때 호출
	if($('#idcheck').val()=='false'){
		alert("ID 중복을 확인하세요");
		$('#id').focus();
		return false;
	}
}
//Ajax
  function confirmIDCheck(){
	   if($('#id').val()==''){
		   alert("ID를 입력 하세요");
		   $('#id').focus();
	   }else{
		   $.ajax({
			   type:"POST",
			   url:'confirmID.jsp',
			   data:"id="+$('#id').val(),//서버로 보내는 인수 값
			   dataType:'JSON',//서버가 보내준 타입(Type)
			   success:function(data){
				   if(data.x==1){
					   alert("사용중인 ID");
					   $('#id').val('').focus();
					   return;
				   }else if(data.x==-1){
					   alert("사용가능한 ID");
					   $('#pw').focus();
					   $('#idcheck').val('true');
				   }
			   }//success end
		   });
		   $('idcheck').val('true');//id 중복 체크 완료
	   }//else end
  }//confirmIDCheck() end  
  </script>
<script src="//code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript" src="script.js"></script>
<link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
<h2>회원가입</h2>
  <form action="${ctxpath }/member/inputPro.do" name="inputForm" method="post" onsubmit="return check()">
    <table border="1">
      <tr>
        <td>사용자ID</td>
        <td>
          <input type="text" name="id" id="id" size="15">
          <input type="hidden" name="idcheck" id="idcheck" value="false">
          <input type="button" value="ID중복체크" onclick="confirmIDCheck()">
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
          <input type="text" name="name" id="name" size="15">
        </td>
      </tr>
      <tr>
        <td>이메일</td>
        <td>
          <input type="text" name="email" id="email" size="15">@
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
          <input type="text" name="tel3" id="tel3" size="4">
        </td>
      </tr>
      <tr>
        <td>우편번호</td>
        <td>
          <input type="text" name="zipcode" id="zipcode" size="7">
          <input type="button" value="주소검색" onclick="openDaumPostcode()">
        </td>
      </tr>
      <tr>
        <td>주소</td>
        <td>
          <input type="text" name="addr" id="addr" size="50" readonly="readonly">
          <br>
          상세주소 : <input type="text" name="addr2" id="addr2" size="20">
        </td>
      </tr>
      <tr>
        <td colspan="2" align="center">
          <input type="submit" value="회원가입">
          <input type="reset" value="다시입력">
          <input type="button" value="돌아가기" onclick="location='${ctxpath}/member/main.do'">
        </td>
      </tr>
    </table> 
  </form>
</body>
</html>