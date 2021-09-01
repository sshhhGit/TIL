<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--memberForm.jsp --%>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>Insert title here</title>
  
  <script src="//code.jquery.com/jquery-3.6.0.min.js">
 </script>
  
  <script>
     function check(){
    	 if(document.inForm.id.value==''){
    		 alert("id입력 하시오");
    		 document.inForm.id.focus();
    		 return false;
    	 }
    	 if(document.inForm.pwd.value==''){
    		 alert("암호입력 하시오");
    		 document.inForm.pwd.focus();
    		 return false;
    	 }
    	 if(document.inForm.name.value==''){
    		 alert("이름입력 하시오");
    		 document.inForm.name.focus();
    		 return false;
    	 }
    	 document.inForm.submit();//전송
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
    					 alert(data.check);//1 -1
    					 if(data.check==1){
    						 alert("사용중인 ID");
    						 $('#id').val('').focus();
    					 }else{
    						 alert("사용가능한 ID");
    						 $('#pw').focus();
    					 }
    				 }//success:function() -end
    			 });
    		 }//else-end
    	 
     }//checkID() end
   </script>
</head>
<body>
  <form name="inForm" method="post" action="inputPro.jsp">
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
          <input type="button" value="ID중복체크" id="btn" onClick="checkID()">
        </td>
      </tr>
      
      <tr>
        <td>암호</td>
        <td>
          <input type="password" name="pwd" id="pwd" size="20">
        </td>
      </tr>
      
      <tr>
        <td>이름</td>
        <td>
          <input type="text" name="name" id="name" size="30">
        </td>
      </tr>
      
      <tr>
        <td colspan="2" align="center">
          <input type="button" value="회원가입" onClick="check()">
          <input type="reset" value="취소">
        </td>
      </tr>
      
      
      
    </table>
  </form>
</body>
</html>