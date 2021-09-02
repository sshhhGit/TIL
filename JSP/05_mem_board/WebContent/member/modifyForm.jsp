<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="member.*"
    %>
<%-- modifyForm.jsp --%>
<%
request.setCharacterEncoding("UTF-8");
String id = (String)session.getAttribute("id");

MemberDAO dao = MemberDAO.getInstance();	//dao객체 얻기
MemberDTO dto = dao.getMember(id);			//dao메서드 호출
%>


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>modifyForm.jsp</title>
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
  <script type="text/javascript">
  function check() {
	if($('#pw').val()==''){
		alert("암호를 입력하세요");
		$('#pw').focus();
		return false;
	}
	if($('#pw2').val()==''){
		alert("암호확인을 입력하세요");
		$('#pw2').focus();
		return false;
	}
	 if($('#pw').val() != $('#pw2').val()){
		 alert("암호와 암호확인이 일치하지 않습니다");
		 $('#pw2').val('');
		 $('#pw').val('').focus();
	 }
}
  </script>
  <style type="text/css">
  h2 {
	text-align: center;
}
table {
	margin: auto;
	width: 60%;
}
  </style>
</head>
<body>
<h2>내정보수정</h2>

<form name="updateForm" action="modifyPro.jsp" method="post" onsubmit="return check()">
  <table border="1" cellspacing="0">
    <tr>
      <td>ID</td>
      <td>
      <%=dto.getId() %>
      <!-- <input type="hidden" name="id" value="<%=dto.getId()%>"> -->
      </td>
    </tr>
  
   <tr>
     <td>암호</td>
     <td>
       <input type="password" name="pw" id="pw" size="15">*필수입력
     </td>
   </tr>
   
   <tr>
     <td>암호확인</td>
     <td>
       <input type="password" name="pw2" id="pw2" size="15">*필수입력
     </td>
   </tr>
   
   <tr>
     <td>이름</td>
     <td>
       <input type="text" name="name" value="<%=dto.getName()%>">
     </td>
   </tr>
  
	  <%
	  String totalEmail = dto.getEmail();
	  int index = totalEmail.indexOf('@');
	  String email = totalEmail.substring(0, index); //@전까지 String
	  String email2 = totalEmail.substring(index);	 //@이후 String
	  %>
	  
   <tr>
     <td>Email</td>
     <td>
       <input type="text" name="email" value="<%=email%>" size="10">
       @
       <select name="email2">
         <option value="<%=email2%>"><%=email2%></option>
         <option value="@naver.com">naver.com</option>
         <option value="@daum.net">daum.net</option>
         <option value="@nate.com">nate.com</option>
       </select>
     </td>
   </tr>
   <tr>
     <td>전화</td>
     <td>
       <select name="tel">
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
       <input type="text" name="zipcode" id="zipcode" size="7">
       <input type="button" value="주소검색" onclick="openDaumPostcode()">
     </td> 
   </tr>
   <tr>
     <td>주소</td>
     <td>
       <input type="text" name="addr" id="addr" size="50">
       <br>
       상세주소 입력 : 
       <input type="text" name="addr2" size="20">
     </td>
   </tr>
   
   <tr>
     <td colspan="2" align="center">
       <input type="submit" value="정보수정">
       <input type="button" value="취소" onclick="location='main.jsp'">
     </td>
   </tr>
  </table>
</form>
</body>
</html>