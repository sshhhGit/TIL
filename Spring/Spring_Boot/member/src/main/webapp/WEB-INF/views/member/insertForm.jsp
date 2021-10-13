<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>insertForm.jsp</title>
<script src="//code.jquery.com/jquery-3.6.0.min.js"></script>
    
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
  function check(){
	  //데이터 휴효성 체크
	  if($('#id').val()==''){
		  alert("Id을 입력 하세요");
		  $('#id').focus();
		  return false;
	  }
	  
	  if($('#pw').val()==''){
		  alert("암호을 입력 하세요");
		  $('#pw').focus();
		  return false;
	  }
	  
	  if($('#pw2').val()==''){
		  alert("암호확인을 입력 하세요");
		  $('#pw2').focus();
		  return false;
	  }
	  
	  //암호와 암호확인이 같은지 비교
	   if($('#pw').val()!=$('#pw2').val()){
		   alert("암호와 암호확인이 틀립니다")
		   $('#pw').val('');
		   $('#pw2').val('');
		   
		   $('#pw').focus();
		   return false;
	   }
  
	  if($('#name').val()==''){
		  alert("이름을 입력 하세요");
		  $('#name').focus();
		  return false;
	  }

	  return true;
  }//check()-end
  
  //Ajax
  function confirmIDCheck(){
	  //alert("aaa")
	  
	  if($('#id').val()==''){
		  alert("ID을 입력 하세요");
		  $('#id').focus();
	  }else{
		 // alert("bbb");
		 
		  $.ajax({
			  type:"POST",
			  url:'confirmID.do',
			  data:"id="+$('#id').val(),//서버로 넘길 인수값
			  dataType:'JSON',//서버가 보내준 자료 타입
			  success:function(data){
				  //alert(data.check);
				   
				  if(data.check==1){//사용가능
					  alert("사용 가능한 ID입니다");
				      $('#pw').focus();
				  }else if(data.check==-1){//사용중
					  alert("사용중인 ID 입니다");
				      $('#id').val('').focus();
				  }
				  
			  }//success-end
			  
		  });
		 
	  }//else-end
	   
  }//confirmIDCheck()-end 
  </script>
  
<style type="text/css">
h2{text-align: center;}

table{
margin:auto;
background-color: ivory;
}
</style>

</head>
<body>
  <h2>^.^회원가입^.^</h2>
  <form method="post" action="insertPro.do" onSubmit="return check()">
    <table border="1">
    <tr>
      <td>ID</td>
      <td>
      <input type="text" name="id" id="id" size="10">
      <input type="button" value="ID중복체크" onClick="confirmIDCheck()">
      </td>
    </tr>
    
    <tr>
      <td>암호</td>
      <td><input type="password" name="pw" id="pw" size="10"></td>
    </tr>
    
    <tr>
      <td>암호확인</td>
      <td><input type="password" name="pw2" id="pw2" size="10"></td>
    </tr>
    
    <tr>
      <td>이름</td>
      <td><input type="text" name="name" id='name' size="30"></td>
    </tr>
    
    <tr>
      <td>이메일</td>
      <td>
      <input type="text" name="email1" id="email1">@
      
      <select name="email2" id="email2">
        <option value="@naver.com">naver.com</option>
        <option value="@daum.net">daum.net</option>
        <option value="@nate.com">nate.com</option>
      </select>
      </td>
    </tr>
    
    <tr>
      <td>전화번호</td>
      <td>
       <select name="tel1" id="tel1">
         <option value="010">010</option>
         <option value="018">018</option>
         <option value="017">017</option>
       </select>
       
       <input type="text" name="tel2" id="tel2" size="4">
       <input type="text" name="tel3" id="tel3" size="4">
      </td>
    </tr>
    
    <tr>
      <td>우편번호</td>
      <td>
      <input type="text" name="zipcode" id="zipcode" size="7">
      <input type="button" value="주소검색" onClick="openDaumPostcode()">      
      </td>
    </tr>
    
    <tr>
      <td>주소</td>
      <td>
        <input type="text" name="addr" id="addr" size="60" readonly>
        <br>
              상세주소:
        <input type="text" name="addr2" id="addr2" size="40">
      </td>
    </tr>
    
    <tr>
      <td colspan="2" align="center">
        <input type="submit" value="회원가입">
        <input type="reset" value="다시입력">
        <input type="button" value="가입안함" onClick="location='main.do'">
      </td>
    </tr>
    
    </table>
  </form>
  
</body>
</html>
