<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--inputForm.jsp --%>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>Insert title here</title>
  
 <script src="//code.jquery.com/jquery-3.6.0.min.js">
 </script>
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
    	 if(document.inForm.id.value==''){
    		 alert("id입력 하시오");
    		 document.inForm.id.focus();
    		 return false;
    	 }
    	 if(document.inForm.pw.value==''){
    		 alert("암호입력 하시오");
    		 document.inForm.pw.focus();
    		 return false;
    	 }
    	 if(document.inForm.pw2.value==''){
    		 alert("암호확인을 입력 하시오");
    		 document.inForm.pw2.focus();
    		 return false;
    	 }
    	 if(document.inForm.pw.value != document.inForm.pw2.value){
    		 alert("암호와 암호확인이 일치하지 않습니다");
    		 document.inForm.pw.value='';
    		 document.inForm.pw2.value='';
    		 document.inForm.pw.focus();
    		 return false;
    	 }
    	 if(document.inForm.name.value==''){
    		 alert("이름입력 하시오");
    		 document.inForm.name.focus();
    		 return false;
    	 }
    	 /*
       	 if($('#idcheck').val()=='false'){
       		 alert("id중복 체크 하세요");
       		 $('#id').focus();
       		 return false;
       	 }
    	 */
    	 return true;
    	 //document.inForm.submit();//전송
     }//check()-end
     //----------------------------------
     //Ajax으로 //id중복체크
     function checkID(){
     		 if($('#id').val()==''){
    			 alert("ID를 입력 하세요");
    		 }else{//ID가 입력 되었으면
    			 
    			 $.ajax({
    				 type:"POST",
    				 url:"confirmID.jsp",
    				 data:"id="+$('#id').val(),//서버로 보낼 값
    				 dataType:'JSON',//서버가 보내준 타입
    				 success:function(data){
    					 //alert(data);
 	   					 //alert(data.check);//1 -1
    					 if(data.check==1){
    						 alert("사용중인 ID");
    						 $('#id').val('').focus();
    					 }else{
    						 alert("사용가능한 ID");
    						 $('#idcheck').val('true');
    						 $('#pw').focus();
    					 }
    				 }//success:function() -end
    			 });
    		 }//else-end
     }//checkID() end
     
     //id중복체크 여부 지정
     function idCheck() {
    	 if($('#idcheck').val()=='false'){
    		 alert("ID중복을 확인하세요");
    		 $('#id').focus();
    		 return false;
    	 }
	}
   </script>
</head>
<body>
  <form name="inForm" method="post" action="inputPro.jsp" onsubmit="return check()">
    <table border="1" align="center">
      
      <tr>
        <td colspan="2" align="center">
          <font size="5">회원가입</font>
        </td>
      </tr>
    
      <tr>
        <td>ID</td>
        <td>
          <input type="text" name="id" id="id" size="20">
          
          <input type="hidden" name="idcheck" id="idcheck" value="false">
          <input type="button" value="ID중복체크" id="btn" onClick="checkID()">
        </td>
      </tr>
      
      <tr>
        <td>암호</td>
        <td>
          <input type="password" name="pw" id="pw" size="20" onfocus="idCheck()">
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
          <input type="text" name="name" id="name" size="30">
        </td>
      </tr>
      
      <tr>
        <td>이메일</td>
        <td>
          <input type="text" name="email" id="email" size="12">@
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
            <input type="text" name="tel2" id="tel2" size="4">
            -
            <input type="text" name="tel3" id="tel3" size="4">
        </td>
      </tr>
      
      <tr>
        <td>우편번호</td>
        <td>
        <input type="text" name="zipcode" id="zipcode" size="7" readonly="readonly">
        <input type="button" value="주소찾기" onclick="openDaumPostcode()">
        </td>
      </tr>
      
      <tr>
        <td>주소</td>
        <td>
          <input type="text" name="addr" id="addr" size="60">
          <br>
          	상세주소 : <input type="text" name="addr2" id="addr2" size="20">
        </td>
      </tr>
      
      <tr>
        <td colspan="2" align="center">
          <input type="submit" value="회원가입">
          <input type="reset" value="취소">
          <!-- 
          <input type="button" value="가입안함" onclick="javaScript:window.location='main.jsp'">
          <input type="button" value="가입안함" onclick="javaScript:location='main.jsp'">
          <input type="button" value="가입안함" onclick="window.location='main.jsp'">
          <input type="button" value="가입안함" onclick="document.location='main.jsp'">
           -->
          <input type="button" value="가입안함" onclick="location='main.jsp'">
        </td>
      </tr>
      
      
      
    </table>
  </form>
</body>
</html>